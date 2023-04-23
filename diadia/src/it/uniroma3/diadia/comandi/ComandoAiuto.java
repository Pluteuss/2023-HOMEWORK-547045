package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO console;
	private final static String NOME_STRING = "aiuto";

	public ComandoAiuto (IO console) {
		
		this.console = console;
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<ELENCO_COMANDI.length; i++)
			console.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		console.mostraMessaggio("");
		
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
		return NOME_STRING;
	}

	@Override
	public void setIO(IO console) {
		// TODO Auto-generated method stub
		this.console = console;
	}

}
