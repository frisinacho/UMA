package controlador;

/*********************************************************
 *    Controlador
 *********************************************************/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.TipoDeCambio;

import vista.IVistaTipoCambio;




public class CtrTipoCambio implements ActionListener {

	private IVistaTipoCambio vistaTC;
	private TipoDeCambio tipoCambio;

	// Al constructor se le pasan la vista y el modelo
	public CtrTipoCambio(IVistaTipoCambio vtc, TipoDeCambio tc) {
		vistaTC = vtc;
		tipoCambio = tc;
		vistaTC.mensaje("tipo de cambio inicializado con exito");
		vistaTC.valorCambio(tc.getCambioEuroDolar());
		// Asignamos el controlador a la vista, lo enganchamos
		vistaTC.controlador(this);
	}

	public void actionPerformed(ActionEvent evento) {
		// procesar los eventos propagados por la vista:

		String comando = evento.getActionCommand();
		vistaTC.mensaje(" ");

		switch (comando) {

		case IVistaTipoCambio.EURODOLAR: {
			double cantidad = vistaTC.obtenerCantidad();
			tipoCambio.setCambioEuroDolar(cantidad);
			vistaTC.valorCambio(tipoCambio.getCambioEuroDolar());
			vistaTC.mensaje("Cambio actualizado con exito");
			break;
		}
		}
	}
}
