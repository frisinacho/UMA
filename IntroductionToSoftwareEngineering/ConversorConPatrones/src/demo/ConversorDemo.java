package demo;

/*********************************************************
 *    Aplicacion con GUI MVC
 *********************************************************/

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.CtrConversor;
import controlador.CtrTipoCambio;

import modelo.TipoDeCambio;


import vista.IVistaTipoCambio;
import vista.IVistaConversor;
import vista.VistaTipoCambio;
import vista.VistaEuroDolar;

public class ConversorDemo {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			crearMVC(i,args[i]);
		}
		
		crearMVC_TipoCambio(); // unica

	}
	
	private static void crearMVC(int i, String tipoVista){
		// Montamos el MVC
		
		// Creamos la vista
		IVistaConversor vistaConv = new VistaEuroDolar();
		
		// el modelo
		TipoDeCambio tipoCambio = TipoDeCambio.obtenerCuenta();
		tipoCambio.setCambioEuroDolar(1.3);
		
		// Y el controlador
		CtrConversor ctr = new CtrConversor(vistaConv, tipoCambio);
		

		// Mostramos la vista en una ventana y la activamos
		JFrame ventana = new JFrame("Vista " + i +" " + tipoVista);
//      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // para que se cierren una a una
		ventana.setContentPane((JPanel) vistaConv);
		ventana.setLocation(100*i, 100*i);
		ventana.pack();
		ventana.setVisible(true);
	}
	
	private static void crearMVC_TipoCambio(){
		// Montamos el MVC para el tipo de cambio de divisas
		
		// Creamos la vista
		IVistaTipoCambio vistaTC = new VistaTipoCambio();
		
		// el modelo
		TipoDeCambio tipoCambio = TipoDeCambio.obtenerCuenta();

		
		// Y el controlador
		CtrTipoCambio ctrConv = new CtrTipoCambio(vistaTC, tipoCambio);
		

		// Mostramos la vista en una ventana y la activamos
		JFrame ventana = new JFrame("Vista tipo cambio de divisas");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaTC);
		ventana.setLocation(1000, 100);
		ventana.pack();
		ventana.setVisible(true);
	}
}
