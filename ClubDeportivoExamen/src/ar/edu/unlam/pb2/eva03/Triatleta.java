package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;

public class Triatleta extends Deportista implements ICiclista{

	private TipoDeEvento tipoDeEvento;
	private TipoDeBicicleta tipoDeBicicleta;

	public Triatleta(Integer numeroDeSocio, String nombre, TipoDeEvento tipoDeEvento, TipoDeBicicleta tipoDeBicicleta) {
		super(numeroDeSocio, nombre);
		this.tipoDeEvento = tipoDeEvento;
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

	public TipoDeEvento getDistanciaPreferida() {
		return tipoDeEvento;
	}

	@Override
	public TipoDeBicicleta getTipoDeBicicleta() {
		return this.tipoDeBicicleta;
	}

	@Override
	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
		
	}
	
}
