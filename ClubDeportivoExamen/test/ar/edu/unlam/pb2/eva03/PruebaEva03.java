package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class PruebaEva03 {
	
	@Test
	public void queSePuedaCrearUnNadador() {
		Nadador nuevo = new Nadador(1, "Camila", "Espalda");

		assertEquals("Espalda", nuevo.getEstiloPreferido());
		assertEquals((Integer)1, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void queSePuedaCrearUnCorredor() {
		Corredor nuevo = new Corredor(2, "Carolina", TipoDeEvento.CARRERA_10K);
		nuevo.setCantidadDeKilometrosEntrenados(50000);
		
		assertEquals(TipoDeEvento.CARRERA_10K, nuevo.getDistanciaPreferida());
		assertEquals((Integer)50000, nuevo.getCantidadDeKilometrosEntrenados());
		assertEquals((Integer)2, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void  queSePuedaCrearUnCiclista() {
		Ciclista nuevo = new Ciclista(3, "Enzo", TipoDeBicicleta.RUTA);

		assertEquals(TipoDeBicicleta.RUTA, nuevo.getTipoDeBicicleta());
		assertEquals((Integer) 3, nuevo.getNumeroDeSocio());
	}

	@Test
	public void  queSePuedaCrearUnTriatleta() {
		Triatleta nuevo = new Triatleta(4, "Luna", TipoDeEvento.TRIATLON_OLIMPICO, TipoDeBicicleta.TRIA);
		
		assertEquals(TipoDeEvento.TRIATLON_OLIMPICO, nuevo.getDistanciaPreferida());
		assertEquals(TipoDeBicicleta.TRIA, nuevo.getTipoDeBicicleta());
		assertEquals((Integer) 4, nuevo.getNumeroDeSocio());
	}
	
	@Test
	public void  queSePuedanIncorporarDistintosDeportistas() {
		// El n�mero de socio no se puede repetir
		Club actual = new Club("CARP");
		
		actual.agregarDeportista(new Corredor(1000, "Camila", TipoDeEvento.CARRERA_42K));
		actual.agregarDeportista(new Corredor(1001, "Natalia", TipoDeEvento.CARRERA_5K));
		actual.agregarDeportista(new Corredor(1002, "Jorge", TipoDeEvento.CARRERA_21K));
		actual.agregarDeportista(new Nadador(1003, "Lucrecia", "Pecho"));
		actual.agregarDeportista(new Triatleta(1004, "Tamara", TipoDeEvento.TRIATLON_OLIMPICO, TipoDeBicicleta.RUTA));
		actual.agregarDeportista(new Ciclista(1005, "Alberto", TipoDeBicicleta.MOUNTAIN));
		actual.agregarDeportista(new Ciclista(1006, "Domingo", TipoDeBicicleta.BMX));
		actual.agregarDeportista(new Corredor(1007, "Luciana", TipoDeEvento.CARRERA_10K));
		actual.agregarDeportista(new Nadador(1008, "Luna", "Crol"));
		actual.agregarDeportista(new Nadador(1009, "Victor", "Mariposa"));
		actual.agregarDeportista(new Triatleta(1004, "Cecilia", TipoDeEvento.TRIATLON_IRONMAN, TipoDeBicicleta.TRIA));
		
		assertEquals((Integer) 10, actual.getCantidadSocios());		
	}
	
	@Test (expected = NoEstaPreparado.class)
	public void  queUnCorredorNoSePuedaInscribirEnUnaCarreraDeNatacion () throws NoEstaPreparado, DeportistaInexistente, CompetenciaInexistente{	
		// En las carreras de nataci�n s�lo pueden inscribirse los que sean INadador
		Deportista celeste = new Corredor(1000, "Celeste", TipoDeEvento.CARRERA_10K);
		Club actual = new Club("Sitas");
		actual.agregarDeportista(celeste);
		actual.crearEvento(TipoDeEvento.CARRERA_NATACION_EN_AGUAS_ABIERTAS, "Maraton de aguas abiertas");
		
		assertNotEquals((Integer)1, actual.inscribirEnEvento("Maraton de aguas abiertas", celeste));		
	}
	
	@Test (expected = NoEstaPreparado.class)
	public void  queUnCorredorNoSePuedaInscribirEnUnTriatlon () throws NoEstaPreparado, DeportistaInexistente, CompetenciaInexistente{		
		// En los triatlones s�lo pueden inscribirse los que sean INadador & ICiclista
		Deportista celeste = new Corredor(1000, "Celeste", TipoDeEvento.CARRERA_10K);
		Club actual = new Club("Sitas");
		
		actual.agregarDeportista(celeste);
		actual.crearEvento(TipoDeEvento.TRIATLON_IRONMAN, "Triatlon Khona");
		
		assertNotEquals((Integer)1, actual.inscribirEnEvento("Triatlon Khona", celeste));		
	}
	
	@Test
	public void  queUnCorredorPuedaCorrerUnaMaraton() throws NoEstaPreparado, DeportistaInexistente, CompetenciaInexistente{		
		Deportista celeste = new Corredor(999, "Celeste", TipoDeEvento.CARRERA_42K);
		Club actual = new Club("Moron");
				
		((Corredor)celeste).setCantidadDeKilometrosEntrenados(100000);
		actual.agregarDeportista(celeste);
		actual.crearEvento(TipoDeEvento.CARRERA_42K, "Maraton de New York");
		
		assertEquals((Integer)1, actual.inscribirEnEvento("Maraton de New York", celeste));			
	}
}
