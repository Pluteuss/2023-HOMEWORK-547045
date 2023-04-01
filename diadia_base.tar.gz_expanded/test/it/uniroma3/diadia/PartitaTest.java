package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class PartitaTest {

	private Partita partita;
	
	
	@BeforeEach
	public void setUp() {
		
		partita = new Partita();
	}
	
	
	
	@Test
	void test() {
		
		partita.setStanzaCorrente(partita.getStanzaVincente());
		assertEquals(partita.getStanzaCorrente(), partita.getStanzaVincente());
	}

}
