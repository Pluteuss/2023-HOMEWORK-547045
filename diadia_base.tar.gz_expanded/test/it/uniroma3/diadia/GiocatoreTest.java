package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	private Giocatore player;
	
	@BeforeEach
	public void setUp() {
		
		player = new Giocatore();
	}
	
	@Test
	public void CfuNullTest() {
		
		assertEquals(player.getCfu(), 20);
	}
	
	public void verificaCfuDiversiTest() {
		
		player.setCfu(6);
		assertNotEquals(player.getCfu(), 7);
	}
	public void verificaCfuUgualiTest() {
		
		player.setCfu(6);
		assertEquals(player.getCfu(), 6);
	}
	
	

}
