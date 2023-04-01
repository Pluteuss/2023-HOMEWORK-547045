package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	private Borsa contenitore;
	private Attrezzo oggetto1;
	private Attrezzo oggetto2;
	private Attrezzo oggetto3;
	

	@BeforeEach
	public void setUp() {
		
		contenitore = new Borsa();
		oggetto1 = new Attrezzo("sasso", 1);
		oggetto2 = new Attrezzo("armadio", 30);
		oggetto3 = new Attrezzo("matita", 2);
	}
	
	@Test
	public void isEmptyTest() {
		
		assertTrue(contenitore.isEmpty());
	}
	
	@Test
	public void isNotEmptyTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertFalse(contenitore.isEmpty());
	}
	
	@Test
	public void getPesoZeroTest() {
		
		assertEquals(contenitore.getPeso(), 0);
		
	}
	
	@Test
	public void getPesoSpecificoTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertEquals(contenitore.getPeso(), 1);
	}
	
	@Test
	public void addAttrezzoFallitaPesoTest() {
		
		contenitore.addAttrezzo(oggetto2);
		assertFalse(contenitore.addAttrezzo(oggetto2));
		
	}
	
	@Test
	public void addAttrezzoFallitaNumeroTest() {
		
		for(int i=0; i<10; i++) {
			contenitore.addAttrezzo(oggetto1);
		}
		assertFalse(contenitore.addAttrezzo(oggetto2));
	}
	
	@Test
	public void addAttrezzoRiuscitaTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertTrue(contenitore.addAttrezzo(oggetto1));
		
	}
	
	@Test
	public void getAttrezzoCiStaTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertEquals(contenitore.getAttrezzo("sasso"), oggetto1);
		
	}
	
	@Test
	public void getAttrezzoNonCiStaTest() {
		
		assertEquals(contenitore.getAttrezzo("sasso"), null);
	}
	
	@Test
	public void removeAttrezzoCiStaTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertEquals(contenitore.removeAttrezzo("sasso"), oggetto1);
		
	}
	
	@Test
	public void removeAttrezzoNonCiStaTest() {
		
		contenitore.addAttrezzo(oggetto1);
		assertNotEquals(contenitore.removeAttrezzo("armadio"), oggetto1);
	}
	public BorsaTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void removeUltimoPrimoTest() {
		contenitore.addAttrezzo(oggetto1);
		contenitore.addAttrezzo(oggetto3);
		
		assertEquals(contenitore.removeAttrezzo("matita"), oggetto3);
		assertEquals(contenitore.removeAttrezzo("sasso"), oggetto1);
		
	}
	
	@Test
	public void removePrimoUltimoTest() {
		contenitore.addAttrezzo(oggetto1);
		contenitore.addAttrezzo(oggetto3);
		
		assertEquals(contenitore.removeAttrezzo("sasso"), oggetto1);
		assertEquals(contenitore.removeAttrezzo("matita"), oggetto3);
		
	}
}