package sesionMDP;

import java.util.Map;

import aima.core.environment.cellworld.Cell;
import aima.core.environment.cellworld.CellWorld;
import aima.core.environment.cellworld.CellWorldAction;
import aima.core.environment.cellworld.CellWorldFactory;
import aima.core.probability.example.MDPFactory;
import aima.core.probability.mdp.MarkovDecisionProcess;
import aima.core.probability.mdp.search.ValueIteration;

/**
 * @author L. Mandow
 * @author I. Lasaosa
 * 
 * Adaptado del original por:
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
 
public class MDPDemo {


	public static void main(String[] args) {

		// Ejemplo mostrado en clase (Cap�tulo 17, libro AIMA)
		//ejemplo1();
		
		// Llamada al ejemplo de la pr�ctica
		ejemplo2();
		
	}

	public static void ejemplo1() {

		System.out.println("DEMO: Iteraci�n de Utilidades");
		System.out.println("=====================");

		// Creamos la rejilla de 4x3 vista en clase:
		//		- cada celda guarda el valor de la recompensa
		//		- las acciones posibles son movimientos arriba, abajo, dcha, e izq (rebotando en los obst�culos)
		CellWorld<Double> cw = CellWorldFactory.createCellWorldForFig17_1();
		
		// Creamos un MDP a partir de la rejilla:
		//         - habr� incertidumbre en los efectos de las acciones
		MarkovDecisionProcess<Cell<Double>, CellWorldAction> mdp = MDPFactory
				.createMDPForFigure17_3(cw);
		
		// Creamos un objeto de la clase ValueIteration, que implementa el algoritmo de iteraci�n de Utilidades
		ValueIteration<Cell<Double>, CellWorldAction> vi = new ValueIteration<Cell<Double>, CellWorldAction>(
				1.0);

		
		// Calculamos las utilidades de cada celda
		Map<Cell<Double>, Double> U = vi.valueIteration(mdp, 0.0001);

		// Mostramos por pantalla los valores de las utilidades de cada celda
		System.out.println("(1,1) = " + U.get(cw.getCellAt(1, 1)));
		System.out.println("(1,2) = " + U.get(cw.getCellAt(1, 2)));
		System.out.println("(1,3) = " + U.get(cw.getCellAt(1, 3)));

		System.out.println("(2,1) = " + U.get(cw.getCellAt(2, 1)));
		System.out.println("(2,3) = " + U.get(cw.getCellAt(2, 3)));

		System.out.println("(3,1) = " + U.get(cw.getCellAt(3, 1)));
		System.out.println("(3,2) = " + U.get(cw.getCellAt(3, 2)));
		System.out.println("(3,3) = " + U.get(cw.getCellAt(3, 3)));

		System.out.println("(4,1) = " + U.get(cw.getCellAt(4, 1)));
		System.out.println("(4,2) = " + U.get(cw.getCellAt(4, 2)));
		System.out.println("(4,3) = " + U.get(cw.getCellAt(4, 3)));

		System.out.println("=========================\n");
		
		System.out.println("An�lisis de la posici�n (3,1):");
		
		Double uArriba = 0.8 * U.get(cw.getCellAt(3, 2)) +
						 0.1 * U.get(cw.getCellAt(4, 1)) +
						 0.1 * U.get(cw.getCellAt(2, 1));
		System.out.format("\nUtilidad esperada (arriba):    %5.3f", uArriba);
		
		Double uIzquierda= 0.8 * U.get(cw.getCellAt(2, 1)) +
				 		   0.1 * U.get(cw.getCellAt(3, 2)) +
				 		   0.1 * U.get(cw.getCellAt(3, 1));     //rebote con la pared
		System.out.format("\nUtilidad esperada (izquierda): %5.3f", uIzquierda);
		
		Double uDerecha =  0.8 * U.get(cw.getCellAt(4, 1)) +
		 		           0.1 * U.get(cw.getCellAt(3, 2)) +
		 		           0.1 * U.get(cw.getCellAt(3, 1));     //rebote con la pared
		System.out.format("\nUtilidad esperada (derecha):   %5.3f", uDerecha);
		
		Double uAbajo =  0.8 * U.get(cw.getCellAt(3, 1)) +      //rebote con la pared
				         0.1 * U.get(cw.getCellAt(4, 1)) +
				         0.1 * U.get(cw.getCellAt(2, 1));
		System.out.format("\nUtilidad esperada (abajo):     %5.3f", uAbajo);
	}
	
	// Ejemplo de la pr�ctica
	
	 public static void ejemplo2() { 
	 

			System.out.println("DEMO: Iteraci�n de Utilidades");
			System.out.println("=====================");

			// Creamos la rejilla de 4x3 vista en clase:
			//		- cada celda guarda el valor de la recompensa
			//		- las acciones posibles son movimientos arriba, abajo, dcha, e izq (rebotando en los obst�culos)
			CellWorld<Double> cw = PracticaCellWorldFactory.createCellWorldPractica();
			
			// Creamos un MDP a partir de la rejilla:
			//         - habr� incertidumbre en los efectos de las acciones
			MarkovDecisionProcess<Cell<Double>, CellWorldAction> mdp = MDPFactory
					.createMDPForFigure17_3(cw);
			
			// Creamos un objeto de la clase ValueIteration, que implementa el algoritmo de iteraci�n de Utilidades
			ValueIteration<Cell<Double>, CellWorldAction> vi = new ValueIteration<Cell<Double>, CellWorldAction>(
					1.0);

			
			// Calculamos las utilidades de cada celda
			Map<Cell<Double>, Double> U = vi.valueIteration(mdp, 0.0001);

			// Mostramos por pantalla los valores de las utilidades de cada celda
			System.out.println("(1,1) = " + U.get(cw.getCellAt(1, 1)));
			System.out.println("(1,2) = " + U.get(cw.getCellAt(1, 2)));
			System.out.println("(1,3) = " + U.get(cw.getCellAt(1, 3)));

			System.out.println("(2,1) = " + U.get(cw.getCellAt(2, 1)));
			System.out.println("(2,3) = " + U.get(cw.getCellAt(2, 3)));

			System.out.println("(3,1) = " + U.get(cw.getCellAt(3, 1)));
			System.out.println("(3,2) = " + U.get(cw.getCellAt(3, 2)));
			System.out.println("(3,3) = " + U.get(cw.getCellAt(3, 3)));

			System.out.println("(4,1) = " + U.get(cw.getCellAt(4, 1)));
			System.out.println("(4,2) = " + U.get(cw.getCellAt(4, 2)));
			System.out.println("(4,3) = " + U.get(cw.getCellAt(4, 3)));

			System.out.println("=========================\n");
			
			System.out.println("An�lisis de la posici�n (3,1):");
			
			Double uArriba = 0.8 * U.get(cw.getCellAt(3, 2)) +
							 0.1 * U.get(cw.getCellAt(4, 1)) +
							 0.1 * U.get(cw.getCellAt(2, 1));
			System.out.format("\nUtilidad esperada (arriba):    %5.3f", uArriba);
			
			Double uIzquierda= 0.8 * U.get(cw.getCellAt(2, 1)) +
					 		   0.1 * U.get(cw.getCellAt(3, 2)) +
					 		   0.1 * U.get(cw.getCellAt(3, 1));     //rebote con la pared
			System.out.format("\nUtilidad esperada (izquierda): %5.3f", uIzquierda);
			
			Double uDerecha =  0.8 * U.get(cw.getCellAt(4, 1)) +
			 		           0.1 * U.get(cw.getCellAt(3, 2)) +
			 		           0.1 * U.get(cw.getCellAt(3, 1));     //rebote con la pared
			System.out.format("\nUtilidad esperada (derecha):   %5.3f", uDerecha);
			
			Double uAbajo =  0.8 * U.get(cw.getCellAt(3, 1)) +      //rebote con la pared
					         0.1 * U.get(cw.getCellAt(4, 1)) +
					         0.1 * U.get(cw.getCellAt(2, 1));
			System.out.format("\nUtilidad esperada (abajo):     %5.3f", uAbajo);
		}
	
}
