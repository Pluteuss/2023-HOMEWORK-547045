package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	private IO io;
	private Comando comando;
	private Giocatore player;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		
		
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa(io);
		io = new IOConsole();
		comando.setIO(io);
		player = new Giocatore();
		labirinto = new Labirinto();
		partita = new Partita(labirinto, player);
	}
	
	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro(partita.getGiocatore().getBorsa().getAttrezzo("martello").getNome());
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testAttrezzoPosatoNull () {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro(null);
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("martello"));
	}

	//public void creatoreAttrezzi() {
	//	for(int i=0; i<10; i++) {
	//		partita.getStanzaCorrente().addAttrezzo(new Attrezzo("utensile"+i, 1));
	//	}
	//}
	
	//@Test
	//public void testTroppiAttrezzi() {
	//	this.creatoreAttrezzi();
	//	partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	//	comando.setParametro("martello");
	//	comando.esegui(partita);
	//	assertFalse(partita.getStanzaCorrente().hasAttrezzo("martello"));
	//}
}
