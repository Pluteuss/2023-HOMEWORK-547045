package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private IO console;
	private String nomeAttrezzo;
	private final static String NOME = "prendi";
	
	public ComandoPrendi (IO console) {
		
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		
		if( a == null) {
			console.mostraMessaggio("Inserisci attrezzo!");
		}
		else if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			console.mostraMessaggio("Attrezzo preso");
		}
		else {
			console.mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIO(IO console) {
		this.console = console;
		
	}

	@Override
	public String getNome() {
		return NOME;
	}



}
