package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceRigheLette;
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public String[] getMessaggiProdotti() {
		return this.messaggiProdotti;
	}
	
	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}
	
	
	
	public IOSimulator (String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new String[42*43];
	}
	
	@Override
	public void mostraMessaggio(String msg) {
		this.messaggiProdotti[indiceMessaggiProdotti] = msg;
		this.indiceMessaggiProdotti++;
		
	}

	@Override
	public String leggiRiga() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return next;
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}
	
}
