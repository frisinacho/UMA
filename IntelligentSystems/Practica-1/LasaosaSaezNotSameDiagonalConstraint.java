package practicaCSP;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.*;

/**
 * PRÁCTICA: Código para representar una restricción cuaternaria para el problema de las N-reinas.
 * Las variables son fila y columna de 2 reinas. No pueden estar en la misma diagonal. 
 */

public class LasaosaSaezNotSameDiagonalConstraint implements Constraint {

	private Variable row1, col1, row2, col2;
	private List<Variable> scope;

	public LasaosaSaezNotSameDiagonalConstraint(Variable row1, Variable col1, Variable row2, Variable col2) {
		this.row1 = row1;
		this.col1 = col1;
		this.row2 = row2;
		this.col2 = col2;
		scope = new ArrayList<Variable>(2);
		scope.add(row1);
		scope.add(col1);
		scope.add(row2);
		scope.add(col2);
	}

	public List<Variable> getScope() {
		return scope;
	}

	public boolean isSatisfiedWith(Assignment assignment) {
		/**
		 * Este método devuelve true si la asignación satisface la restricción, y false en otro caso.
		 */
		
		Assignment assignmnt = assignment;
		for (Variable var : scope) {
			if (assignmnt.getAssignment(var) == null) {
				return true;
			}
		}
		
		if (Math.abs((int) assignmnt.getAssignment(row1) - (int) assignmnt.getAssignment(row2)) == Math.abs((int) assignmnt.getAssignment(col1) - (int) assignmnt.getAssignment(col2))) {
			return false;
		} else {
			return true;
		}
		
		
	}
}
