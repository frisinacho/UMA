package vista;

import java.awt.event.ActionListener;

public interface IVistaTipoCambio {
	// el controlador puede manejar ciertos eventos
	// y leer/escribir datos de la vista

	// lectura de datos del formulario
	double obtenerCantidad();

	// escritura de datos en el formulario
	void valorCambio(double cambio);
	void mensaje(String m);

	// para registrar el controlador
	void controlador(ActionListener ctr);

	// eventos exportados al controlador
	String EURODOLAR = "ED";

}
