package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanza;
	private Attrezzo bacchetta;
	
	
	@Before
	public void setUp() {
		
		stanza = new StanzaMagica ("StanzaMagica");
		bacchetta = new Attrezzo("bacchetta", 1);
	}
	
	@Test
	public void testModifcaAttrezzo1() {
		stanza.addAttrezzo(bacchetta);
		assertEquals(stanza.getAttrezzo("bacchetta").getNome(), "bacchetta");
		assertEquals(stanza.getAttrezzo("bacchetta").getPeso(), 1);
		
	}
	
	@Test
	public void testModifcaAttrezzo2() {
		stanza.addAttrezzo(bacchetta);
		stanza.removeAttrezzo(bacchetta);
		stanza.addAttrezzo(bacchetta);
		assertEquals(stanza.getAttrezzo("attehccab").getNome(), "attehccab");
		assertEquals(stanza.getAttrezzo("attehccab").getPeso(), 2);
		
	}

	
}
