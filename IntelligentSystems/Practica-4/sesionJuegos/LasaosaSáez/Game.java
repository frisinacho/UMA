package sesionJuegos;

import java.util.List;

import aima.core.util.Util;

import aima.core.search.adversarial.AlphaBeta;
import aima.core.search.adversarial.GameState;

/**
 * @param <MOVE>
 *            the type of moves that can be made within the game.
 * 
 * @author Ravi Mohan
 * @author Mike Stampone
 * 
 * @author  L.Mandow
 * @author I.Lasaosa
 * Sistemas Inteligentes - m�todos adicionales al final del fichero.
 */
public abstract class Game<MOVE> {
	protected GameState initialState = new GameState();

	protected GameState presentState = new GameState();

	protected int level;

	public abstract List<GameState> getSuccessorStates(GameState state);

	public abstract GameState makeMove(GameState state, Object o);

	public abstract int getMiniMaxValue(GameState state);

	public abstract int getAlphaBetaValue(GameState state);

	public boolean hasEnded() {
		return (terminalTest(getState()));
	}

	public int getLevel(GameState g) {
		return (((Integer) g.get("level")).intValue());
	}

	@SuppressWarnings("unchecked")
	public List<MOVE> getMoves(GameState state) {
		return (List<MOVE>) state.get("moves");
	}

	/**
	 * Returns the player to move at the specified game state.
	 * 
	 * @param state
	 *            a game state
	 * 
	 * @return the player to move at the specified game state.
	 */
	public String getPlayerToMove(GameState state) {
		return (String) state.get("player");
	}

	/**
	 * Returns a numeric value for the outcome of the game. In chess, the
	 * outcome is a win, loss, or draw, which we can represent by the value +1,
	 * -1, or 0. Some games have a wider variety of possible outcomes; for
	 * example, the payoffs in backgammon range from + 192 to -192.
	 * 
	 * @param h
	 *            a game state to evaluate.
	 * 
	 * @return a numeric value for the outcome of the game.
	 */
	public int getUtility(GameState h) {
		return ((Integer) h.get("utility")).intValue();
	}

	/**
	 * Returns the present state of the game.
	 * 
	 * @return the present state of the game.
	 */
	public GameState getState() {
		return presentState;
	}

	
	
	public int maxValue(GameState state) {
		int v = Integer.MIN_VALUE;
		if (terminalTest(state)) {
			return computeUtility(state);
		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = successorList.get(i);
				int minimumValueOfSuccessor = minValue(successor);
				if (minimumValueOfSuccessor > v) {
					v = minimumValueOfSuccessor;
					state.put("next", successor);
				}
			}
			return v;
		}

	}
	
	public int minValue(GameState state) {

		int v = Integer.MAX_VALUE;

		if (terminalTest(state)) {
			return computeUtility(state);

		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = successorList.get(i);
				int maximumValueOfSuccessors = maxValue(successor);
				if (maximumValueOfSuccessors < v) {
					v = maximumValueOfSuccessors;
					state.put("next", successor);
				}
			}
			return v;
		}

	}

	public int minValue(GameState state, AlphaBeta ab) {
		int v = Integer.MAX_VALUE;

		if (terminalTest(state)) {
			return (computeUtility(state));

		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = successorList.get(i);
				int maximumValueOfSuccessor = maxValue(successor, ab.copy());
				if (maximumValueOfSuccessor < v) {
					v = maximumValueOfSuccessor;
					state.put("next", successor);
				}
				if (v <= ab.alpha()) {
					// System.out.println("pruning from min");
					return v;
				}
				ab.setBeta(Util.min(ab.beta(), v));

			}
			return v;
		}

	}

	public void makeMiniMaxMove() {
		getMiniMaxValue(presentState);
		GameState nextState = (GameState) presentState.get("next");
		if (nextState == null) {
			throw new RuntimeException("Mini Max Move failed");

		}
		makeMove(presentState, nextState.get("moveMade"));

	}

	public void makeAlphaBetaMove() {
		getAlphaBetaValue(presentState);

		GameState nextState = (GameState) presentState.get("next");
		if (nextState == null) {
			throw new RuntimeException("Alpha Beta Move failed");
		}
		makeMove(presentState, nextState.get("moveMade"));

	}

	//
	// PROTECTED METHODS
	//
	protected abstract int computeUtility(GameState state);

	protected abstract boolean terminalTest(GameState state);

	protected int maxValue(GameState state, AlphaBeta ab) {
		int v = Integer.MIN_VALUE;
		if (terminalTest(state)) {
			return computeUtility(state);
		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = (GameState) successorList.get(i);
				int minimumValueOfSuccessor = minValue(successor, ab.copy());
				if (minimumValueOfSuccessor > v) {
					v = minimumValueOfSuccessor;
					state.put("next", successor);
				}
				if (v >= ab.beta()) {
					// System.out.println("pruning from max");
					return v;
				}
				ab.setAlpha(Util.max(ab.alpha(), v));
			}
			return v;
		}
	}
	
	
	/// M�TODOS DE LA PR�CTICA //////////////////////////////////////
	// M�todos para contar las hojas generadas por MiniMax
	
	public int maxValueLeafs(GameState state) {
		
		int cont = 0;

		if (terminalTest(state)) {
			return 1;
		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				cont = cont + minValueLeafs(successorList.get(i));
			}
			return cont;
		}

	}

	public int minValueLeafs(GameState state) {

	    int cont = 0;	

		if (terminalTest(state)) {
			return 1;
		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				// GameState successor = successorList.get(i);
				cont = cont + maxValueLeafs(successorList.get(i));
				
			}
			return cont;
		}

	}
	
	/// M�TODOS DE LA PR�CTICA //////////////////////////////////////
	// Incluir aqu� los m�todos para contar las hojas generadas por Alfa-Beta

	protected int[] maxValueLeafs(GameState state, AlphaBeta ab) {
		int[] result = new int[2];
		result[0] = Integer.MIN_VALUE;
		result[1] = 0;

		if (terminalTest(state)) {
			result[0] = computeUtility(state);
			result[1] = 1;
			return result;

		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = (GameState) successorList.get(i);
				int[] resSuc = minValueLeafs(successor, ab.copy());
				int minimumValueOfSuccessor = resSuc[0];
				int hojasSuc = resSuc[1];

				result[1] = result[1] + hojasSuc;
				if (minimumValueOfSuccessor > result[0]) {
					result[0] = minimumValueOfSuccessor;
					state.put("next", successor);
				}
				if (result[0] >= ab.beta()) {
					return result;

				}

				ab.setAlpha(Util.max(ab.alpha(), result[0]));
			}
			return result;
		}
	}
	
	public int[] minValueLeafs(GameState state, AlphaBeta ab) {
		int[] result = new int[2];
		result[0] = Integer.MAX_VALUE;
		result[1] = 0;

		if (terminalTest(state)) {
			result[0] = computeUtility(state);
			result[1] = 1;
			return result;

		} else {
			List<GameState> successorList = getSuccessorStates(state);
			for (int i = 0; i < successorList.size(); i++) {
				GameState successor = (GameState) successorList.get(i);
				int[] resSuc = maxValueLeafs(successor, ab.copy());
				int maximumValueOfSuccessor = resSuc[0];
				int hojasSuc = resSuc[1];

				result[1] = result[1] + hojasSuc;
				if (maximumValueOfSuccessor < result[0]) {
					result[0] = maximumValueOfSuccessor;
					state.put("next", successor);
				}
				if (result[0] <= ab.alpha()) {
					return result;

				}

				ab.setBeta(Util.min(ab.beta(), result[0]));
			}
			return result;
		}
	}
		
}
