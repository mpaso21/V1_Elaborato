import java.util.*;

import mylib.InputDati;
import mylib.Utilit�Controllo;

public class Cittadino {
	protected String nome;
	private String status;//devo mettere come enum
	private int et�;
	
	
	public Cittadino(String nome, int et�){
		this.nome = nome;
		this.status = "noFruitore"; //quando fa richiesta diventa fruitore
		this.et� = et�;
	}

	 public Cittadino(String nome){
		 this.nome = nome;
	 }
	 
	public static Cittadino creaCittadino(){
		String nome = Cittadino.creaNome();
		int et� = Cittadino.creaEt�();
		Cittadino c = new Cittadino(nome, et�);
		return c;
	}
	
	private static String creaNome(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		String nome;
		do{
			nome = mylib.InputDati.leggiStringaNonVuota("inserisci il tuo nome: ");
		}while(!(mylib.Utilit�Controllo.controlloStringa(nome)));//VERIFICO NOME E DICI DI REINSERIRE SE NON � NEL FORMATO CORRETTO
		//verifica maiuscolo minouscolo
		return nome;
	}
	
	private static int creaEt�(){ //METTO PRIVATE PERCHE' LO USO NELLA CLASSE E NON NEL MAIN.  
		
		int et�;
		et� = mylib.InputDati.leggiIntero("inserisci la tua et�: ", 10, 90);
		return et�;
	}
	
	public boolean richiestaIscrizione(){
		if(this.getEt�()>= 18){
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

	public int getEt�() {
		return et�;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEt�(int et�) {
		this.et� = et�;
	}
	
	
}
