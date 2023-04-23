package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	private IO console;
	public FabbricaDiComandiFisarmonica(IO console) {
		this.console = console;
	}
	
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if(scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();	//prima parola: nome del comando
		if(scannerDiParole.hasNext())
			parametro = scannerDiParole.next();		//seconda parola: nome del parametro
		if(nomeComando == null)
			comando = new ComandoNonValido(this.console);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(this.console);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(this.console);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(this.console);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.console);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(this.console);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(this.console);
		else comando = new ComandoNonValido(this.console);
		comando.setParametro(parametro);
		//comando.setIO(this.console);
		return comando;
	}
}
