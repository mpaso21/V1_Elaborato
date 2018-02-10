import java.util.*;

import mylib.InputDati;
import mylib.UtilitàControllo;

public class Cittadino {
	protected String nome;
	private String status;//devo mettere come enum
	private int età;
	
	
	public Cittadino(String nome, int età){
		this.nome = nome;
		this.status = "noFruitore"; //quando fa richiesta diventa fruitore
		this.età = età;
	}

	 public Cittadino(String nome){
		 this.nome = nome;
	 }
	 
	public static Cittadino creaCittadino(){
		String nome = Cittadino.creaNome();
		int età = Cittadino.creaEtà();
		Cittadino c = new Cittadino(nome, età);
		return c;
	}
	
	private static String creaNome(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		String nome;
		do{
			nome = mylib.InputDati.leggiStringaNonVuota("inserisci il tuo nome: ");
		}while(!(mylib.UtilitàControllo.controlloStringa(nome)));//VERIFICO NOME E DICI DI REINSERIRE SE NON è NEL FORMATO CORRETTO
		//verifica maiuscolo minouscolo
		return nome;
	}
	
	private static int creaEtà(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		int età;
		età = mylib.InputDati.leggiIntero("inserisci la tua età: ", 10, 90);
		return età;
	}
	
	public boolean richiestaIscrizione(){
		if(this.getEtà()>= 18){
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

	public int getEtà() {
		return età;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEtà(int età) {
		this.età = età;
	}
	
	
}
