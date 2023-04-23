package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private IO console;
	private final static String NOME = "guarda";
	
	public ComandoGuarda (IO console) {
		
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public void setIO(IO console) {
		// TODO Auto-generated method stub
		this.console = console;
	}

}
