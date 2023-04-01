package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore player;
	private Borsa contenitore;
	private IOConsole console;

	public DiaDia(IOConsole console) {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
	
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		processaIstruzione(console.leggiRiga());
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio(" ");
	}

	//gli attrezzi presi vengono rimossi dalla stanza e aggiunti alla borsa

	private void prendi(String nomeAttrezzo){
		//se trovo attrezzo cercato in stanzaCorrente
		if(this.labirinto.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)){
			/*
					//se il peso dell'attrezzo cercato < pesomassimo della borsa
					if(this.labirinto.getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()<this.contenitore.getPesoMax()){
			 */
			//aggiungi attrezzo a borsa
			this.contenitore.addAttrezzo(this.labirinto.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
			this.labirinto.getStanzaCorrente().removeAttrezzo(this.labirinto.getStanzaCorrente().getAttrezzo(nomeAttrezzo));
			console.mostraMessaggio("Hai preso "+ nomeAttrezzo);
		}
		//else System.out.println("Non puoi prenderlo, la borsa pesa troppo");
		//}
		//non trovo attrezzo cercato
		else console.mostraMessaggio("Attrezzo non presente nella stanza");
	}
	//gli attrezzi posati vengono rimossi dalla borsa e aggiunti alla stanza
	private void posa (String nomeAttrezzo) {

		//se trovo attrezzo cercato nella borsa
		if(this.contenitore.hasAttrezzo(nomeAttrezzo)) {
			this.labirinto.getStanzaCorrente().addAttrezzo(this.contenitore.getAttrezzo(nomeAttrezzo));
			this.labirinto.getStanzaCorrente().removeAttrezzo(this.contenitore.removeAttrezzo(nomeAttrezzo));
			console.mostraMessaggio("Hai posato "+ nomeAttrezzo);
		}
		else console.mostraMessaggio("Attrezzo non presente nella borsa");
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.player.getCfu();
			this.player.setCfu(cfu--);
		}
		console.mostraMessaggio(this.labirinto.getStanzaCorrente().getDescrizione());
	}


	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}