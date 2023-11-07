package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Evento {

	private String nombre;
	private TipoDeEvento tipoDeEvento;
	private Integer numeroDeInscripcion = 1;
	private Map<Integer, Deportista> participantes;

	public Evento(TipoDeEvento tipoDeEvento, String nombre) {
		this.tipoDeEvento = tipoDeEvento;
		this.nombre = nombre;
		this.participantes = new HashMap<>();
	}

	public void agregarParticipante(Deportista deportista) throws NoEstaPreparado {

		if(getDeportista().equals(1) && (deportista instanceof Corredor || deportista instanceof Triatleta)) {
			this.participantes.put(numeroDeInscripcion, deportista);
			this.numeroDeInscripcion++;
		}else if(getDeportista().equals(2) && (deportista instanceof Nadador || deportista instanceof Triatleta)) {
			this.participantes.put(numeroDeInscripcion, deportista);
			this.numeroDeInscripcion++;
		}else if(getDeportista().equals(3) && (deportista instanceof Ciclista || deportista instanceof Triatleta)) {
			this.participantes.put(numeroDeInscripcion, deportista);
			this.numeroDeInscripcion++;
		}else {
			throw new NoEstaPreparado("No esta preparado");
		}

	}

	public Integer getDeportista() {
		Integer deporte = 0;
		if (tipoDeEvento.equals(TipoDeEvento.values()[0]) || tipoDeEvento.equals(TipoDeEvento.values()[1])
				|| tipoDeEvento.equals(TipoDeEvento.values()[2]) || tipoDeEvento.equals(TipoDeEvento.values()[3])) {
			deporte = 1;
		}else if(tipoDeEvento.equals(TipoDeEvento.values()[4]) || tipoDeEvento.equals(TipoDeEvento.values()[5])
				|| tipoDeEvento.equals(TipoDeEvento.values()[6])) {
			deporte = 2;
		}else {
			deporte = 3;
		}
		return deporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
