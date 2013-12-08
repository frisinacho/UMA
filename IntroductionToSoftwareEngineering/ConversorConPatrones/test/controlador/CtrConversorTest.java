package controlador;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import modelo.TipoDeCambio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import vista.IVistaConversor;
import vista.VistaEuroDolar;

public class CtrConversorTest {

	private IVistaConversor mockVC;
	private TipoDeCambio mockTipo;

	@Before
	public void setUp() throws Exception {
		mockVC = mock(IVistaConversor.class);
		mockTipo = mock(TipoDeCambio.class);
	}

	@After
	public void tearDown() throws Exception {
		mockVC = null;
		mockTipo = null;
	}

	@Test
	public void testCrearControlador() {
		// inicializacion-mock y stub
		when(mockTipo.getCambioEuroDolar()).thenReturn(2.5);
		// ejecucion
		CtrConversor ctr = new CtrConversor(mockVC, mockTipo);

		// verificacion
		verify(mockVC).mensaje(
				"vista conversor Euro-Dolar inicializado con exito");
		verify(mockVC).controlador(ctr);
		verify(mockTipo).register(ctr);
		verify(mockVC).valorCambio(2.5);
	}

	@Test
	public void cambio() {
		// inicializacion-mock y stub
		ActionEvent mockEvento = mock(ActionEvent.class);
		when(mockEvento.getActionCommand()).thenReturn(VistaEuroDolar.CAMBIO);
		when(mockVC.obtenerCantidad()).thenReturn(2.0);
		when(mockTipo.getCambioEuroDolar()).thenReturn(2.5);
		// ejecucion
		CtrConversor ctr = new CtrConversor(mockVC, mockTipo);
		ctr.actionPerformed(mockEvento);
		//verificacion
		verify(mockVC,times(1)).valorDivisa(2.5*2);
		verify(mockVC).mensaje("Valor divisas actualizado con exito");
	}

}
