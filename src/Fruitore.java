import java.time.LocalDateTime;

import sun.util.calendar.BaseCalendar.Date;

public class Fruitore extends Cittadino{
	
	public LocalDateTime inizio_iscrizione;
	public LocalDateTime scadenza_iscrizione;
	
	public Fruitore(String nome){
	    super(nome);
		this.inizio_iscrizione = Data.creaData();
		this.scadenza_iscrizione = calcolo_scadenza();
	}
	
	public LocalDateTime calcolo_scadenza(){
	  //5 anni dopo quella di iscrizione
	 // scadenza_iscrizione = Data.cambiaAnno(5, inizio_iscrizione);
		scadenza_iscrizione = Data.cambiaMinuto(10, inizio_iscrizione);
	  return scadenza_iscrizione;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("#########################################################################");
		sb.append("\n");
		sb.append("FRUITORE: " + nome);
		sb.append("\nDATA ISCRIZIONE: " + Data.convertoData(inizio_iscrizione));
		sb.append("\nDATA SCADENZA: " + Data.convertoData(scadenza_iscrizione) );
		return sb.toString();
	}
	
	public LocalDateTime calcoloTerminiPrescritti(){
		LocalDateTime d;
		//d = Data.cambiaGiorno(10, scadenza_iscrizione);
		d = Data.menoMinuto(6,scadenza_iscrizione);
		return d;
	}
	//il rinnovo comporta l'aggiornamento dell'iscrzione e scadenza nell'elenco fruitori
		//public void rinnovo(LocalDateTime la){//la data in cui richiedo rinnovo
		//se ho ricevuto richiesta rinnovo true devo verificare i termini entro cui l'ha fa
		//if(la.isBefore(scadenza_iscrizione) && la.isAfter(calcoloTerminiPrescritti())){
			//la data in cui lo richiedo è compresa tra la scadenza e i 10 giorni dopo
			//allora puoi fare rinnovo
			//System.out.println("PUOI RINNOVARE L'ISCRIZIONE ORA");
			//AGGIORNO data iscrizione con data corrente 
			//aggiorno data scadenza con calcolo scadenza su data iscrizione nuova
			//inizio_iscrizione = la;
			//scadenza_iscrizione = calcolo_scadenza();
			//System.out.println("ISCRIZIONE RINNOVATA");
		//}
//		else if(!la.isBefore(scadenza_iscrizione)){
//				System.out.println("I TERMINI ENTRO CUI POTER RINNOVARE L'ISCRIZIONE SONO CONCLUSI.");
//				System.out.println("NON SEI PIU' UN FRUITORE DEL NOSTRO SERVIZIO");
				//il fruitore viene cancellato dall'elencofruitori
				//e il cittadino cambio lo stato da fruitore a non 
//			}
//		else if(!la.isAfter(calcoloTerminiPrescritti())){ //puoi rinnovarli da calcolotermini in poi
//				LocalDateTime d;
//				d = calcoloTerminiPrescritti();
//				System.out.println("DEVI ASPETTARE ANCORA QUALCHE MINUTO PER RINNOVARE L'ISCRIZIONE."
//						+ " PUOI RINNOVARLA DA QUEST'ORA: " + Data.convertoData(d));	
//			}

		//}

		public LocalDateTime getInizio_iscrizione() {
			return inizio_iscrizione;
		}

		public LocalDateTime getScadenza_iscrizione() {
			return scadenza_iscrizione;
		}

		public void setInizio_iscrizione(LocalDateTime inizio_iscrizione) {
			this.inizio_iscrizione = inizio_iscrizione;
		}

		public void setScadenza_iscrizione(LocalDateTime scadenza_iscrizione) {
			this.scadenza_iscrizione = scadenza_iscrizione;
		}

		
	
}
