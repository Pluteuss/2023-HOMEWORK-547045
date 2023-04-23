package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	
	private Stanza stanza1; 
	private Stanza stanzaCorrente;
	private Stanza stanzaVittoria;
	
	private Partita partita;
	private Labirinto reticolo;
	private Giocatore player;
	
	
	@Before
	public void setUp () {
		
		stanza1 = new Stanza ("Stanza1");
		stanzaCorrente = new Stanza ("StanzaCorrente");
		stanzaVittoria = new Stanza("Biblioteca");
		reticolo = new Labirinto();
		player = new Giocatore();
		partita = new Partita(reticolo, player);
		
	}
	
	/* 
	@Test
	public void getStanzaVincenteTest() {
		
		assertEquals(reticolo.getStanzaVincente().getNome(), stanzaVittoria.getNome());
		
		
	}
	
	@Test
	public void getStanzaVincenteNotNullTest() {
		
		assertNotNull(reticolo.getStanzaVincente());
		
		
	}
	
	@Test
	public void getStanzaVincenteEqualsCorrenteTest() {
		
		reticolo.setStanzaCorrente(reticolo.getStanzaVincente());
		assertEquals(reticolo.getStanzaVincente(), reticolo.getStanzaCorrente());
		
	}
	*/ 
	
	@Test
	public void vintaFallitaTest() {
		
		assertFalse(partita.vinta());
		
	}
	
	@Test
	public void vintaDavveroTest() {
		
		reticolo.setStanzaCorrente(reticolo.getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void vintaNullTest() {
		
		reticolo.setStanzaCorrente(null);
		assertFalse(partita.vinta());
	}
	
	@Test
	public void finitaFinitaTest() {
		
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void finitaVintaTest() {
		
		reticolo.setStanzaCorrente(reticolo.getStanzaVincente());
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void finitaCfuTest() {
		
		player.setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void finitaIsNotFinitaTest() {
		
		assertFalse(partita.isFinita());
	}
}




