package vista;

/*********************************************************
 * 	Primera Vista para Cuenta
 *********************************************************/
import java.awt.*;
import javax.swing.*;

import controlador.IObserver;

import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class VistaEuroDolar extends JPanel implements IVistaConversor{
	
	private JTextField cantidadJTF;
	private JLabel valorDivisaJL;
	private JLabel cambioJL;
	private JLabel mensajeJL;
	private JButton cambiarJB;
	private ArrayList<IObserver> observers;

	public VistaEuroDolar() {
		// Definicion de componentes basicos
		cantidadJTF = new JTextField(10);
		valorDivisaJL = new JLabel("0", SwingConstants.RIGHT);
		cambioJL = new JLabel("1.00", SwingConstants.CENTER);
		cambiarJB = new JButton("Cambiar");
		mensajeJL = new JLabel("vista creada");
		
		// Panel central
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(3, 2));
		panelC.add(new JLabel("Euro", SwingConstants.CENTER));
		panelC.add(new JLabel("Dolar", SwingConstants.CENTER));
		panelC.add(cantidadJTF);
		panelC.add(valorDivisaJL);
		panelC.add(cambioJL);
		panelC.add(cambiarJB);
		
		// Panelk sur para el mensaje
		JPanel panelS = new JPanel();
		panelS.add(mensajeJL);
		
		// Confeccion del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelC, BorderLayout.CENTER);
		add(panelS, BorderLayout.SOUTH);
	}

	public void controlador(ActionListener ctr) {
		cambiarJB.addActionListener(ctr);
		cambiarJB.setActionCommand(CAMBIO);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cantidadJTF.getText());
	}

	
	@Override
	public void valorCambio(double cambio) {
		cambioJL.setText(String.format("%,8.5f", cambio));	
	}

	@Override
	public void valorDivisa(double valor) {
		valorDivisaJL.setText(String.format("%,12.2f", valor));		
	}

	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}


}
