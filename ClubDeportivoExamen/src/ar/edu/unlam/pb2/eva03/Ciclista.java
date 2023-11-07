package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;

public class Ciclista extends Deportista implements ICiclista {

	private TipoDeBicicleta tipoDeBicicleta;

	public Ciclista(Integer numeroDeSocio, String nombre, TipoDeBicicleta tipoDeBicicleta) {
		super(numeroDeSocio, nombre);
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

	@Override
	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	@Override
	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

}
