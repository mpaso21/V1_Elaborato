package main;
import java.time.LocalDateTime;

import mylib.Constants;
import mylib.Data;

/**
 * La classe Fruitore rappresenta un cittadino maggiorenne che può quindi diventare
 * fruitore dei servizi di prestito temporaneo.
 * @author Marika
 *
 */
public class Fruitore extends Cittadino{
	
	private LocalDateTime inizio_iscrizione;
	private LocalDateTime scadenza_iscrizione;
	
	/**
	 * Costruttore classe Fruitore. Ciascun fruitore è composto da un nome, da una data
	 * di iscrizione e da una data di scadenza dell'iscrizione.
	 * @param nome
	 */
	public Fruitore(String nome){
	    super(nome);
		this.inizio_iscrizione = Data.creaData();
		this.scadenza_iscrizione = calcoloScadenza();
	}
	
	/**
	 * Metodo calcolo_scadenza permette avendo una data di iscrizione di calcolare su essa la scadenza che
	 * è esattamente 5 anni dopo dall data di iscrizione.
	 * @return
	 */
	public LocalDateTime calcoloScadenza(){
	  //5 anni dopo quella di iscrizione
	 // scadenza_iscrizione = Data.cambiaAnno(5, inizio_iscrizione);
		scadenza_iscrizione = Data.cambiaMinuto(2, inizio_iscrizione);
	  return scadenza_iscrizione;
	}
	
	/**
	 * Metodo toString fornisce una rappresentazione delle anagrafiche del fruitore.
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		//sb.append("#########################################################################");
		//sb.append("\n");
		sb.append("FRUITORE: " + nome);
		sb.append("\nDATA ISCRIZIONE: " + Data.convertoData(inizio_iscrizione));
		sb.append("\nDATA SCADENZA: " + Data.convertoData(scadenza_iscrizione) );
		sb.append("\n------------------------------------------\n");
		return sb.toString();
	}
	
	/**
	 * Metodo calcoloTerminiPrescritti permette di calcolare il termine entro cui poter
	 * chiedere il rinnovo. (non prima dei 10 giorni antecedenti la data di scadenza).
	 * @return
	 */
	public LocalDateTime calcoloTerminiPrescritti(){
		LocalDateTime d;
		//d = Data.cambiaGiorno(10, scadenza_iscrizione);
		d = Data.menoMinuto(1,scadenza_iscrizione);
		return d;
	}
	
	/**
	 * Metodo rinnovo controlla se è possibile rinnovare l'iscrizione del fruitore oppure no.
	 * Per poter rinnovare l'iscrizione del fruitore è necessario che la richiesta non avvenga prima dei 
	 * 10 giorni antecedenti la scandenza e non dopo la data di scadenza.
	 * @param la
	 * @param elenco
	 */
	public void rinnovo(LocalDateTime la, ElencoFruitori elenco) {// la data in cui richiedo rinnovo
		
		if (la.isBefore(scadenza_iscrizione) && la.isAfter(calcoloTerminiPrescritti())) {
			// la data in cui lo richiedo deve essere compresa tra la scadenza e i 10 giorni dopo
			// allora puoi fare rinnovo
			System.out.println(Constants.ISCRIZIONE_ORA);
			inizio_iscrizione = la;
			scadenza_iscrizione = calcoloScadenza();
			System.out.println(Constants.ISCRIZIONE_RINNOVATA);
		} else if (!la.isBefore(scadenza_iscrizione)) {
			System.out.println(Constants.ISCRIZIONE_TERMINI_SCADUTI);
			elenco.rimozioneFruitore(this);
			
		} else if (!la.isAfter(calcoloTerminiPrescritti())) { // puoi rinnovarli da calcolo termini in poi
			LocalDateTime d;
			d = calcoloTerminiPrescritti();
			System.out.println(Constants.ISCRIZIONE_RINNOVATA_TRA_POCO + Data.convertoData(d));
		}

	}

		public LocalDateTime getInizioIscrizione() {
			return inizio_iscrizione;
		}

		public LocalDateTime getScadenzaIscrizione() {
			return scadenza_iscrizione;
		}

		public void setInizioIscrizione(LocalDateTime inizio_iscrizione) {
			this.inizio_iscrizione = inizio_iscrizione;
		}

		public void setScadenzaIscrizione(LocalDateTime scadenza_iscrizione) {
			this.scadenza_iscrizione = scadenza_iscrizione;
		}

		
	
}
