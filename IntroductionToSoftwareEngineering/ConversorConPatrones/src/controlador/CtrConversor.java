package controlador;

/*********************************************************
 *    Controlador
 *********************************************************/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.TipoDeCambio;
import vista.IVistaConversor;


public class CtrConversor implements ActionListener, IObserver{

	private IVistaConversor vistaConv;
	private TipoDeCambio tipoCambio;

	// Al constructor se le pasan la vista y el modelo
	public CtrConversor(IVistaConversor vc, TipoDeCambio tipo) {
		this.vistaConv = vc;
		this.tipoCambio = tipo;
		vistaConv.valorCambio(tipoCambio.getCambioEuroDolar());
		vistaConv.mensaje("vista conversor Euro-Dolar inicializado con exito");
		// Asignamos el controlador a la vista, lo enganchamos
		vistaConv.controlador(this);
		// tenemos que registar al controlador como observador
		tipoCambio.register(this);
	}

	public void actionPerformed(ActionEvent evento) {

		// procesar los eventos propagados por la vista:

		String comando = evento.getActionCommand();
		vistaConv.mensaje(" ");

		switch (comando) {

		case IVistaConversor.CAMBIO: {
			double cantidad = vistaConv.obtenerCantidad();
			double tipo = tipoCambio.getCambioEuroDolar();
			vistaConv.valorDivisa(cantidad*tipo);
			vistaConv.mensaje("Valor divisas actualizado con exito");
			break;
		}
	}
}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		vistaConv.valorCambio(tipoCambio.getCambioEuroDolar());
	}


}