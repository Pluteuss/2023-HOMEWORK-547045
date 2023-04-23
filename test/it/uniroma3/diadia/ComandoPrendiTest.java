package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendiTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoNull;
	private Comando comando;
	private IO io;
	private Labirinto labirinto;
	private Giocatore player;
	
	@Before
	public void setUp() {
		
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 11);
		//attrezzoNull = null;
		io = new IOConsole();
		comando = new ComandoPrendi(io);
		labirinto = new Labirinto();
		player = new Giocatore();
		partita = new Partita(labirinto, player);
	}
	
	public boolean attrezzoPesante(String s) {
		Attrezzo[] array = partita.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if( a != null && s.equals(a.getNome()))
				return true;
		}
		return false;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro(partita.getStanzaCorrente().getAttrezzo("martello").getNome());
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
	
	}
	
	@Test
	public void testAttrezzoNonPresente() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("martello");
		assertNotEquals(comando.getParametro(), partita.getStanzaCorrente().getAttrezzo(attrezzoPesante.getNome()).getNome());
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getStanzaCorrente().addAttrezzo(attrezzoPesante);
		comando.setParametro("incudine");
		comando.esegui(partita);
		assertTrue(attrezzoPesante("incudine"));
	}

}
