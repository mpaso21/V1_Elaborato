package main;

import mylib.*;

/**
 * La classe Cittadino rappresenta una persona appartenente a una comunità che vuole fare 
 * una richiesta per diventare fruitore dei servizi di prestito temporaneo.
 * @author Marika
 *
 */
public class Cittadino {
	protected String nome;
	private enum Status { FRUITORE, NON_FRUITORE };//ENUM GIUSTA?
	private int eta;
	private Status status;
	
	/**
	 * Costruttore classe Cittadino. Ciascun cittadino è costituito da un nome, da un'età e da
	 * uno status.
	 * @param nome
	 * @param eta
	 */
	public Cittadino(String nome, int eta){
		this.nome = nome;
		this.status = Status.NON_FRUITORE; //quando fa richiesta può diventare fruitore
		this.eta = eta;
	}

	/**
	 * Costruttore classe Cittadino con la differenza che ciascun cittadino è rappresentato solo
	 * dal nome. Utile per le classi che ereditano da essa.
	 * @param nome
	 */
	 public Cittadino(String nome){
		 this.nome = nome;
	 }
	 
	 /**
	  * Il metodo creaCittadino permette la creazione di un cittadino con l'inserimento da parte
	  * dell'utente del nome, dell'età.
	  * @return
	  */
	public static Cittadino creaCittadino(){
		String nome = Cittadino.creaNome();
		int eta = Cittadino.creaEta();
		Cittadino c = new Cittadino(nome, eta);
		return c;
	}
	
	/**
	 * Metodo creaNome di utilità per il metodo creaCittadino. Esso controlla che il nome inserito è 
	 * composta da lettere e non da cifre. Inoltre controlla che la stringa inserita non sia vuota.
	 * 
	 * @return
	 */
	private static String creaNome(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		String nome;
		do{
			nome = mylib.InputDati.leggiStringaNonVuota("inserisci il tuo nome: ");
		}while(!(UtilitaControllo.controlloStringa(nome)));//VERIFICO NOME E DICI DI REINSERIRE SE NON ï¿½ NEL FORMATO CORRETTO
		//verifica maiuscolo minouscolo
		return nome;
	}
	
	/**
	 * Metodo creaEta di utilità per il metodo creaCittadino. Esso controlla che la cifra inserita
	 * dall'utente sia compresa tra un massimo e un minimo numerico.
	 * @return
	 */
	private static int creaEta(){  
		
		int eta;
		eta = mylib.InputDati.leggiIntero("inserisci la tua etï¿½: ", 10, 90);
		return eta;
	}
	
	/**
	 * Metodo richiestaIscrizione verifica che l'età inserita dal cittadino sia maggiore/uguale a 18.
	 * Se sì, il cittadino diventa fruitore. Se no, il cittadino non diventa fruitore.
	 * @return
	 */
	public boolean richiestaIscrizione(){
		if(this.getEta()>= 18){
			this.setStatus(Status.FRUITORE);
		}
		else{
			return false;
		}
		return true;
	}
	
	public String getNome() {
		return nome;
	}

	public Status getStatus() {
		return status;
	}

	public int getEta() {
		return eta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
}
