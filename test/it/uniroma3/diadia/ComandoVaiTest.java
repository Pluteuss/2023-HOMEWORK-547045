package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVaiTest {
	
	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	private IO io;
	private Labirinto labirinto;
	private Giocatore player;
	
	@Before
	public void setUp() {
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai(io);
		player = new Giocatore();
		
		labirinto = new Labirinto();
		p = new Partita(labirinto, player);
		vai.setIO(new IOConsole());
	}

	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("sud-ovest");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-ovest", s2);
		vai.setParametro("in fondo");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
	}

	//@Test
	//public void testPartitaComandoVai () {
	//	String[] righeDaLeggere = {"vai nord", "fine"};
	//	IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
	//	assertTrue(io.hasNextMessaggio());
	//	assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
	//	assertTrue(io.hasNextMessaggio());
	//	assertEquals("Biblioteca", io.nextMessaggio());
	//	assertTrue(io.hasNextMessaggio());
	//	assertEquals("Hai vinto!", io.nextMessaggio());
	//}
}
