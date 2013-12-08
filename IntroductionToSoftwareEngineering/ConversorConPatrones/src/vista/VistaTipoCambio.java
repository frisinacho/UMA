package vista;

/*********************************************************
 * 	Primera Vista para Cuenta
 *********************************************************/
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class VistaTipoCambio extends JPanel implements IVistaTipoCambio {
	
	private JTextField cambioEuroDolarJTF;
	private JLabel cambioDolarEuroJL;
	private JLabel cambioEuroDolarJL;
	private JButton actualizarCambioJB;
	private JLabel mensajeJL;

	public VistaTipoCambio() {
		// Definicion de componentes basicos
		cambioEuroDolarJTF = new JTextField(10);
		cambioEuroDolarJL = new JLabel("1.0",SwingConstants.CENTER);
		cambioDolarEuroJL = new JLabel("1.0", SwingConstants.CENTER);
		cambioEuroDolarJL.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
		cambioDolarEuroJL.setFont(new java.awt.Font("Bookman Old Style", 1, 18));

		actualizarCambioJB = new JButton("Actualizar Cambio");
		mensajeJL = new JLabel("vista creada");
		
		// Panel Norte entrada nuevo cambio
		JPanel panelN = new JPanel();
		panelN.setLayout(new GridLayout(1, 3));
		panelN.add(new JLabel("Nuevo Cambio €/$", SwingConstants.CENTER));
		panelN.add(cambioEuroDolarJTF);
		panelN.add(actualizarCambioJB);
		
		// Panel central
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(2, 3));
		panelC.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		panelC.setBackground(Color.LIGHT_GRAY);
		panelC.add(new JLabel("Euro - Dolar: ", SwingConstants.RIGHT));
		panelC.add(cambioEuroDolarJL);
		panelC.add(new JLabel(""));
		panelC.add(new JLabel("Dolar - Euro: ", SwingConstants.RIGHT));
		panelC.add(cambioDolarEuroJL);
		panelC.add(new JLabel(""));

		// Panel sur para el mensaje
		JPanel panelS = new JPanel();
		panelS.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelS.add(mensajeJL);
		
		// Confeccion del panel principal de contenidos
		setLayout(new BorderLayout());
		add(panelN, BorderLayout.NORTH);
		add(panelC, BorderLayout.CENTER);
		add(panelS, BorderLayout.SOUTH);
		
	}

	public void controlador(ActionListener ctr) {
		actualizarCambioJB.addActionListener(ctr);
		actualizarCambioJB.setActionCommand(EURODOLAR);
	}

	public double obtenerCantidad() {
		return Double.parseDouble(cambioEuroDolarJTF.getText());
	}

	
	public void mensaje(String msg) {
		mensajeJL.setText(msg);
	}

	public void valorCambio(double c) {
		cambioEuroDolarJL.setText(String.format("%,8.5f", c));
		cambioDolarEuroJL.setText(String.format("%,8.5f", 1/c));
	}

}
