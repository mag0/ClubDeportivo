package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;

public class Corredor extends Deportista implements ICorredor {

	private TipoDeEvento distanciaPreferida;
	private Integer cantidadDeKilometrosEntrenados;

	public Corredor(Integer numeroDeSocio, String nombre, TipoDeEvento distanciaPreferida) {
		super(numeroDeSocio, nombre);
		this.distanciaPreferida = distanciaPreferida;
		this.cantidadDeKilometrosEntrenados = 0;
	}

	public TipoDeEvento getDistanciaPreferida() {
		return distanciaPreferida;
	}

	@Override
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.cantidadDeKilometrosEntrenados = km;
	}

	@Override
	public Integer getCantidadDeKilometrosEntrenados() {
		return this.cantidadDeKilometrosEntrenados;
	}

}
