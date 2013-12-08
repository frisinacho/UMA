package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TipoDeCambioTest {

	@Test
	public void testSinglenton() {
		TipoDeCambio c1,c2;
		c1 = TipoDeCambio.obtenerCuenta();
		c2 = TipoDeCambio.obtenerCuenta();
		
		assertSame(c1, c2);
	}

}
