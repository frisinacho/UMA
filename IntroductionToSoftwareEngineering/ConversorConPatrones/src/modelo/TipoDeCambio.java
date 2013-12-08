package modelo;

import java.util.ArrayList;

import controlador.IObserver;

public class TipoDeCambio implements ISubject {
	private double cambioEuroDolar;
	public static TipoDeCambio elTipo = null;
	private ArrayList<IObserver> observers;

	private TipoDeCambio(double cambioEuroDolar) {
		this.cambioEuroDolar = cambioEuroDolar;
		observers = new ArrayList<>();
	}
	
	public static synchronized TipoDeCambio obtenerCuenta(){
		if (elTipo == null){
			elTipo = new TipoDeCambio(0);
		}
		return elTipo;
	}

	public double getCambioEuroDolar() {
		return cambioEuroDolar;
	}

	public double getCambioDolarEuro() {
		return 1.0/cambioEuroDolar;
	}

	public void setCambioEuroDolar(double cambioEuroDolar) {
		this.cambioEuroDolar = cambioEuroDolar;
		notifyObservers();
	}

	@Override
	public void register(IObserver o) {
		observers.add(o);	
	}

	@Override
	public void unregister(IObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (IObserver observer : observers) {
			observer.update();
			
		}
		
	}

}
