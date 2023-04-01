package it.uniroma3.diadia;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		stanza = new Stanza("bagno");
		attrezzo = new Attrezzo("Ascia", 4);
	}

	
	
	@Test
	void hasAttrezzoTest() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("Ascia"));
	}

}
