package vista;

/*********************************************************
 *   Interfaz para las Vistas
 *********************************************************/
import java.awt.event.*;

public interface IVistaConversor {
	
	// el controlador puede manejar ciertos eventos
	// y leer/escribir datos de la vista
	
	// lectura de datos del formulario
	double obtenerCantidad();
	
	// escritura de datos en el formulario
	void valorDivisa(double saldo);
	void valorCambio(double cambio);
	void mensaje(String m);

	// para registrar el controlador	
	void controlador(ActionListener ctr);

	// eventos exportados al controlador
	String CAMBIO = "C";
}
