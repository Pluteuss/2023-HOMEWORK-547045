package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {

	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	private Labirinto reticolo;
	
	@BeforeEach
	public void setUp() {
		
		stanzaVincente = new Stanza("Atrio");
		stanzaCorrente = new Stanza("Laboratorio Campus");
		reticolo = new Labirinto();		
	}
	
	@Test
	
	public void getStanzaVincenteTest() {
		
		assertEquals(reticolo.getStanzaVincente().getNome(), stanzaVincente.getNome());
		
	}
	@Test
	public void getStanzaVincenteNotNullTest() {
		
		assertNotEquals(reticolo.getStanzaVincente(), null);
	}

	@Test
	public void getStanzaCorrenteTest() {
		
		assertEquals(reticolo.getStanzaCorrente().getNome(), stanzaCorrente.getNome());
	}
	
	@Test
	public void getStanzaCorrenteNotNullTest() {
		
		assertNotEquals(reticolo.getStanzaCorrente().getNome(), null);
	}
}

