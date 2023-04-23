package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	
	private IO console;
	private final static String NOME = "non valido";
	
	public ComandoNonValido (IO console) {
		
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio("Comando non valido");
		
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
		return NOME;
	}

	

}