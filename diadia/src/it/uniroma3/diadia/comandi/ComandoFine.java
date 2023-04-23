package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{
	
	private IO console;
	private final static String NOME_STRING = "fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	
	public ComandoFine (IO console) {
		
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		console.mostraMessaggio(MESSAGGIO_FINE);	//si desidera smettere
		
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
	public void setIO(IO console) {
		this.console = console;
		
	}

	@Override
	public String getNome() {
		return NOME_STRING;
	}

	

}
