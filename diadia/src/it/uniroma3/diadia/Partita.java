package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private boolean finita;
	private Labirinto reticolo;
	private Giocatore player;
	
	//aggiungo riferimento alla classe labirinto nella classe partita
	public Partita(Labirinto reticolo, Giocatore x){
		
		this.reticolo = reticolo;
		this.finita = false;
		this.player = x;
	}
	
	public Labirinto getLabirinto() {
		return reticolo;
	}
	
	public void setLabirinto(Labirinto reticolo) {
		this.reticolo = reticolo;
	}
	
	public Giocatore getGiocatore() {
		return player;
	}
	
	public void setGiocatore (Giocatore player) {
		this.player = player;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.reticolo.getStanzaCorrente().equals(this.reticolo.getStanzaVincente());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		return this.player.getCfu()>0;
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		
		this.getLabirinto().setStanzaCorrente(stanza);
	}
	
	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
}