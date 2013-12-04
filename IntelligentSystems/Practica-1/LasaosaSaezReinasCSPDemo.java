package practicaCSP;


import aima.core.search.csp.Assignment;
import aima.core.search.csp.BacktrackingStrategy;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CSPStateListener;
import aima.core.search.csp.MinConflictsStrategy;
import aima.core.search.csp.SolutionStrategy;

/**
 * Resolver el problema de las 4 reinas mediante satisfacción de restricciones.
 * Hay que tener en cuenta que no todas las restricciones son binarias, por ello aplicaremos
 * solo dos resolutores
 * 
 * SolutionStrategy solver1 = new MinConflictsStrategy(1000);
 * SolutionStrategy solver2 = new BacktrackingStrategy();
 * 
 * El programa debe mostrar por la consola:
 *   - el resultado devuelto por el resolutor
 *   - estadísticas de la ejecución 
 *   
 */

public class LasaosaSaezReinasCSPDemo {
	public static void main(String[] args) {
		CSP csp = new LasaosaSaezReinasCSP();
		
		StepCounter stepCounter = new StepCounter();
	 	SolutionStrategy solver;
	 	
		solver = new MinConflictsStrategy(1000);
		solver.addCSPStateListener(stepCounter);
		stepCounter.reset();
		System.out.println("4_Reinas (Minimum Conflicts)");
		System.out.println(solver.solve(csp.copyDomains()));
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new BacktrackingStrategy();
		solver.addCSPStateListener(stepCounter);
		stepCounter.reset();
		System.out.println("4_Reinas (Backtracking)");
		System.out.println(solver.solve(csp.copyDomains()));
		System.out.println(stepCounter.getResults() + "\n");
		
	}
	
	/** Counts assignment and domain changes during CSP solving. */
	protected static class StepCounter implements CSPStateListener {
         
		private int assignmentCount = 0;
		private int domainCount = 0;
		
		public void stateChanged(Assignment assignment, CSP csp) {
			++assignmentCount;
		}
		
		public void stateChanged(CSP csp) {
			++domainCount;
		}
		
		public void reset() {
			assignmentCount = 0;
			domainCount = 0;
		}
		
		public String getResults() {
			StringBuffer result = new StringBuffer();
			result.append("assignment changes: " + assignmentCount);
			if (domainCount != 0)
				result.append(", domain changes: " + domainCount);
			return result.toString();
		}
	}
}

 
