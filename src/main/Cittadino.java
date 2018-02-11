package main;

import mylib.*;


public class Cittadino {
	protected String nome;
	private String status;//devo mettere come enum
	private int eta;
	
	
	public Cittadino(String nome, int eta){
		this.nome = nome;
		this.status = "noFruitore"; //quando fa richiesta diventa fruitore
		this.eta = eta;
	}

	 public Cittadino(String nome){
		 this.nome = nome;
	 }
	 
	public static Cittadino creaCittadino(){
		String nome = Cittadino.creaNome();
		int eta = Cittadino.creaEta();
		Cittadino c = new Cittadino(nome, eta);
		return c;
	}
	
	private static String creaNome(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		String nome;
		do{
			nome = mylib.InputDati.leggiStringaNonVuota("inserisci il tuo nome: ");
		}while(!(UtilitaControllo.controlloStringa(nome)));//VERIFICO NOME E DICI DI REINSERIRE SE NON � NEL FORMATO CORRETTO
		//verifica maiuscolo minouscolo
		return nome;
	}
	
	private static int creaEta(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		int eta;
		eta = mylib.InputDati.leggiIntero("inserisci la tua et�: ", 10, 90);
		return eta;
	}
	
	public boolean richiestaIscrizione(){
		if(this.getEta()>= 18){
			this.setStatus("fruitore");
		}
		else{
			return false;
		}
		return true;
	}
	
	public String getNome() {
		return nome;
	}

	public String getStatus() {
		return status;
	}

	public int getEta() {
		return eta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
}
