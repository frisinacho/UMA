package sesionJuegos;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.adversarial.AlphaBeta;
import aima.core.search.adversarial.Game;
import aima.core.search.adversarial.GameState;
import aima.core.environment.tictactoe.TicTacToeBoard;



import aima.core.util.datastructure.XYLocation;

/**
 * @author Ravi Mohan
 * 
 * @author L. Mandow
 * @author I.Lasaosa
 * Fichero para la pr�ctica de Sistemas Inteligentes
 * 
 */
public class TicTacToe extends Game<XYLocation> {
	public TicTacToe() {
		List<XYLocation> moves = new ArrayList<XYLocation>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				XYLocation loc = new XYLocation(i, j);
				moves.add(loc);
			}
		}
		initialState.put("moves", moves);
		initialState.put("player", "X");
		initialState.put("utility", new Integer(0));
		initialState.put("board", new TicTacToeBoard());
		initialState.put("level", new Integer(0));
		
		presentState = initialState;
	}

	public TicTacToeBoard getBoard(GameState state) {

		return (TicTacToeBoard) state.get("board");
	}

	@Override
	public List<GameState> getSuccessorStates(GameState state) {
		GameState temp = presentState;
		List<GameState> retVal = new ArrayList<GameState>();
		int parentLevel = getLevel(state);
		for (int i = 0; i < getMoves(state).size(); i++) {
			XYLocation loc = (XYLocation) getMoves(state).get(i);

			GameState aState = makeMove(state, loc);
			aState.put("moveMade", loc);
			aState.put("level", new Integer(parentLevel + 1));
			retVal.add(aState);

		}
		presentState = temp;
		return retVal;
	}

	@Override
	public GameState makeMove(GameState state, Object o) {
		XYLocation loc = (XYLocation) o;
		return makeMove(state, loc.getXCoOrdinate(), loc.getYCoOrdinate());
	}

	public GameState makeMove(GameState state, int x, int y) {
		GameState temp = getMove(state, x, y);
		if (temp != null) {
			presentState = temp;
		}
		return presentState;
	}

	public GameState makeMove(int x, int y) {
		GameState state = presentState;
		GameState temp = getMove(state, x, y);
		if (temp != null) {
			presentState = temp;
		}
		return presentState;
	}

	public GameState getMove(GameState state, int x, int y) {
		GameState retVal = null;
		XYLocation loc = new XYLocation(x, y);
		List<XYLocation> moves = getMoves(state);
		List<XYLocation> newMoves = new ArrayList<XYLocation>(moves);
		if (moves.contains(loc)) {
			int index = newMoves.indexOf(loc);
			newMoves.remove(index);

			retVal = new GameState();

			retVal.put("moves", newMoves);
			TicTacToeBoard newBoard = getBoard(state).cloneBoard();
			if (getPlayerToMove(state) == "X") {
				newBoard.markX(x, y);
				retVal.put("player", "O");

			} else {
				newBoard.markO(x, y);
				retVal.put("player", "X");

			}
			retVal.put("board", newBoard);
			retVal.put(
					"utility",
					new Integer(computeUtility(newBoard,
							getPlayerToMove(getState()))));
			retVal.put("level", new Integer(getLevel(state) + 1));
			// presentState = retVal;
		}
		return retVal;
	}

	@Override
	public int computeUtility(GameState state) {
		int utility = computeUtility((TicTacToeBoard) state.get("board"),
				(getPlayerToMove(state)));
		return utility;
	}

	@Override
	public boolean terminalTest(GameState state) {
		TicTacToeBoard board = (TicTacToeBoard) state.get("board");
		boolean line = board.lineThroughBoard();
		boolean filled = board.getNumberOfMarkedPositions() == 9;
		return (line || filled);
	}

	public void printPossibleMoves() {
		System.out.println("Possible moves");

		List<XYLocation> moves = getMoves(presentState);
		for (int i = 0; i < moves.size(); i++) {
			XYLocation moveLoc = (XYLocation) moves.get(i);
			GameState newState = getMove(presentState,
					moveLoc.getXCoOrdinate(), moveLoc.getYCoOrdinate());
			System.out.println("utility = " + computeUtility(newState));
			System.out.println("");
		}

	}

	@Override
	public int getMiniMaxValue(GameState state) {
		// statesSeen = new ArrayList();
		// System.out.println("In get Minimax Value");
		// System.out.println("Received state ");
		// ((TicTacToeBoard)state.get("board")).print();
		if (getPlayerToMove(state).equalsIgnoreCase("X")) {
			return maxValue(state);

		} else {
			return minValue(state);
		}
	}

	
	@Override
	public int getAlphaBetaValue(GameState state) {

		if (getPlayerToMove(state).equalsIgnoreCase("X")) {
			AlphaBeta initial = new AlphaBeta(Integer.MIN_VALUE,
					Integer.MAX_VALUE);
			int max = maxValue(state, initial);
			return max;

		} else {
			// invert?
			AlphaBeta initial = new AlphaBeta(Integer.MIN_VALUE,
					Integer.MAX_VALUE);
			return minValue(state, initial);
		}
	}

	//
	// PRIVATE METHODS
	//
	private int computeUtility(TicTacToeBoard aBoard, String playerToMove) {
		int retVal = 0;
		if (aBoard.lineThroughBoard()) {
			if (playerToMove.equals("X")) {
				retVal = -1;
			} else {
				retVal = 1;
			}

		}
		return retVal;
	}
	
	//// M�TODOS DE LA PR�CTICA  ///////////////////////////////
	// M�todo que devuelve el n�mero de nodos hoja visitados por MiniMAX
	
	public int getMiniMaxLeafs() {
		
		GameState state = presentState;
		int valor = 0;
		
		state.put("contador", 0);
		
		
		if (getPlayerToMove(state).equalsIgnoreCase("X")) {
			valor =  maxValueLeafs(state);

		} else {
			valor = minValueLeafs(state);
		}
		
		return valor;
	}
	
	/// M�TODOS DE LA PR�CTICA //////////////////////////////////////
	// Incluir aqu� el m�todo que devuelve el n�mero de nodos hoja visitados por Alfa-Beta

	
	public int getAlphaBetaLeafs() {
		GameState state = presentState;
		int valor = 0;
		
		if (getPlayerToMove(state).equalsIgnoreCase("X")) {
			valor = maxValueLeafs(state,new AlphaBeta(Integer.MIN_VALUE,Integer.MAX_VALUE))[1];
		}else{
			valor = minValueLeafs(state,new AlphaBeta(Integer.MIN_VALUE,Integer.MAX_VALUE))[1];
		}
		return valor;
	}
	
}
