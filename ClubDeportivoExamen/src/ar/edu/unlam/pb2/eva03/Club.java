package ar.edu.unlam.pb2.eva03;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<String, Evento> competencias;

	public Club(String nombre) {
		this.nombre = nombre;
		this.socios = new HashSet<>();
		this.competencias = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarDeportista(Deportista corredor) {
		socios.add(corredor);
	}

	public Object getCantidadSocios() {
		return this.socios.size();
	}

	public void buscarDeportista(Deportista deportista) throws DeportistaInexistente {
		if (!socios.contains(deportista))
			throw new DeportistaInexistente("No existe el deportista");
	}

	public void buscarCompetencia(String evento) throws CompetenciaInexistente {
		if (!competencias.containsKey(evento))
			throw new CompetenciaInexistente("No existe la competencia");
	}

	public void crearEvento(TipoDeEvento tipoDeEvento, String nombre) {
		Evento evento = new Evento(tipoDeEvento, nombre);
		this.competencias.put(nombre, evento);
	}

	public Integer inscribirEnEvento(String nombre, Deportista celeste)
			throws NoEstaPreparado, DeportistaInexistente, CompetenciaInexistente {
		buscarDeportista(celeste);
		buscarCompetencia(nombre);
		for (Map.Entry<String, Evento> entry : competencias.entrySet()) {
			String key = entry.getKey();
			Evento val = entry.getValue();
			if (key.equals(nombre)) {
				val.agregarParticipante(celeste);
			}
		}
		return 1;
	}
}
