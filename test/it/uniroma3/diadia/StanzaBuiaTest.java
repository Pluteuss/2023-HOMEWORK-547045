package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanza;
	private Attrezzo lanterna;
	
	@Before
	public void setUp() {
		stanza = new StanzaBuia("StanzaBuia", "lanterna");
		lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	public void testGetDescrizioneConAttrezzo() {
		
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSenzaAttrezzo() {
		
		String d = "qui c'e un buio pesto";
		assertEquals(d, stanza.getDescrizione());
	}

}
