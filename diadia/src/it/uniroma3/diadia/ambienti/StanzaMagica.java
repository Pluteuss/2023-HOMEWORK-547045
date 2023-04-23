package it.uniroma3.diadia.ambienti;

//import java.lang.invoke.StringConcatFactory;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	
	private int contaAttrezziPosati;
	private int sogliaMagica;
	private static final int SOGLIA_MAGICA_DEFAULT = 1;
	
	public StanzaMagica (String nome) {
		
		this(nome, SOGLIA_MAGICA_DEFAULT);
		
	}
	
	public StanzaMagica (String nome, int soglia) {
		
		super(nome);
		this.contaAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		if(attrezzo == null) {
			return null;
		}
		
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		return attrezzo;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		if( attrezzo == null) {
			return false;
		}
		this.contaAttrezziPosati++;
		if(this.contaAttrezziPosati>this.sogliaMagica){
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		
		return super.addAttrezzo(attrezzo);
	}
	

}
