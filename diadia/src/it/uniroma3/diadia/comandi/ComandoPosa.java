package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	
	private IO console;
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	
	public ComandoPosa (IO console) {
		
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		
		if(nomeAttrezzo == null) {
			console.mostraMessaggio("non c'e nulla");
		}
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		
		if( a == null) {
			console.mostraMessaggio("Quale attrezzo vuoi posare?");
		}
		
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("attrezzo posato");
		}
		else {
			console.mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questi attrezzo!");
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
