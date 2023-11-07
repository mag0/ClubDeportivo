package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Nadador extends Deportista implements INadador{

	private String estiloPreferido;

	public Nadador(Integer numeroDeSocio, String nombre, String estiloPreferido) {
		super(numeroDeSocio, nombre);
		this.estiloPreferido = estiloPreferido;
	}

	@Override
	public void setEstiloPreferido(String estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
		
	}

	@Override
	public String getEstiloPreferido() {
		return this.estiloPreferido;
	}

}
