package practicaCSP;


import java.util.ArrayList;
import java.util.List;
import aima.core.search.csp.Domain;
import aima.core.search.csp.*;


/**
 * PRÁCTICA: Código para representar el problema de las 4 reinas mediante un CSP.
 */

public class LasaosaSaezReinasCSP extends CSP {
	public static final Variable F1 = new Variable("F1");  //Fila de la reina 1
	public static final Variable C1 = new Variable("C1");  //Columna de la reina 1
	public static final Variable F2 = new Variable("F2");  // .. el resto análogamente.
	public static final Variable C2 = new Variable("C2");
	public static final Variable F3 = new Variable("F3");
	public static final Variable C3 = new Variable("C3");
	public static final Variable F4 = new Variable("F4");
	public static final Variable C4 = new Variable("C4");
	


	/**
	 * @return las filas y columnas de cada reina como una lista de variables.
	 */

	private static List<Variable> collectVariables() {
		List<Variable> variables = new ArrayList<Variable>();
		variables.add(F1);
		variables.add(C1);
		variables.add(F2);
		variables.add(C2);
		variables.add(F3);
		variables.add(C3);
		variables.add(F4);
		variables.add(C4);
		return variables;
	}

	/**
	 * Constructor
	 */

	public LasaosaSaezReinasCSP() {
		super(collectVariables());

		// 1) Definir el dominio de todas las variables { 1, 2, 3, 4 };

		Domain posicion = new Domain(new Object[] {1, 2, 3, 4});
		for (Variable var : getVariables())
			setDomain(var, posicion);
		
		// 2) Añadir las restricciones

		addConstraint(new NotEqualConstraint(F1,F2));
		addConstraint(new NotEqualConstraint(F1,F3));
		addConstraint(new NotEqualConstraint(F1,F4));
		addConstraint(new NotEqualConstraint(F2,F3));
		addConstraint(new NotEqualConstraint(F2,F4));
		addConstraint(new NotEqualConstraint(F3,F4));
		
		addConstraint(new NotEqualConstraint(C1,C2));
		addConstraint(new NotEqualConstraint(C1,C3));
		addConstraint(new NotEqualConstraint(C1,C4));
		addConstraint(new NotEqualConstraint(C2,C3));
		addConstraint(new NotEqualConstraint(C2,C4));
		addConstraint(new NotEqualConstraint(C3,C4));
		
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F1,C1,F2,C2));
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F1,C1,F3,C3));
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F1,C1,F4,C4));
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F2,C2,F3,C3));
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F2,C2,F4,C4));
		addConstraint(new LasaosaSaezNotSameDiagonalConstraint(F3,C3,F4,C4));
		
	}
}
 
