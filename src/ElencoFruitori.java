import java.time.LocalDateTime;
import java.util.ArrayList;

import mylib.InputDati;

public class ElencoFruitori {
	private ArrayList<Fruitore> elenco;
	
	public ElencoFruitori(){
		elenco = new ArrayList<Fruitore>();
	}
	
	public void iscrizioneFruitore(Fruitore f){
		elenco.add(f);//questo metodo va in questa classe?
	}
	
	public void rimozioneFruitore (Fruitore f){
		elenco.remove(f); //rimuovi da vedere meglio il metoodo guarda carriera studetnte
	}
	public String stampaElenco(){
		StringBuilder sb = new StringBuilder();
		sb.append("ELENCO FRUITORI: " + "\n");
		for(int i = 0; i < elenco.size(); i++){
			sb.append(i+1 + " ");
			sb.append(elenco.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public Fruitore selezionaFruitore(){
		System.out.println(this.stampaElenco());
		int valore = InputDati.leggiIntero("inserisci il numero relativo al cittadino", 1, elenco.size());
		return elenco.get(valore -1);
	}
	
	//il rinnovo comporta l'aggiornamento dell'iscrzione e scadenza nell'elenco fruitori
			public void rinnovo(LocalDateTime la, Fruitore f){//la data in cui richiedo rinnovo
			//se ho ricevuto richiesta rinnovo true devo verificare i termini entro cui l'ha fa
			if(la.isBefore(f.getScadenza_iscrizione()) && la.isAfter(f.calcoloTerminiPrescritti())){
				//la data in cui lo richiedo è compresa tra la scadenza e i 10 giorni dopo
				//allora puoi fare rinnovo
				System.out.println("PUOI RINNOVARE L'ISCRIZIONE ORA");
				//AGGIORNO data iscrizione con data corrente 
				//aggiorno data scadenza con calcolo scadenza su data iscrizione nuova
				f.inizio_iscrizione= la;
				f.scadenza_iscrizione = f.calcolo_scadenza();
				System.out.println("ISCRIZIONE RINNOVATA");
			}
			else if(!la.isBefore(f.scadenza_iscrizione)){
					System.out.println("I TERMINI ENTRO CUI POTER RINNOVARE L'ISCRIZIONE SONO CONCLUSI.");
					System.out.println("NON SEI PIU' UN FRUITORE DEL NOSTRO SERVIZIO");
					elenco.remove(f);
					//il fruitore viene cancellato dall'elencofruitori
					//e il cittadino cambio lo stato da fruitore a non 
				}
			else if(!la.isAfter(f.calcoloTerminiPrescritti())){ //puoi rinnovarli da calcolotermini in poi
					LocalDateTime d;
					d = f.calcoloTerminiPrescritti();
					System.out.println("DEVI ASPETTARE ANCORA QUALCHE MINUTO PER RINNOVARE L'ISCRIZIONE."
							+ " PUOI RINNOVARLA DA QUEST'ORA: " + Data.convertoData(d));	
				}

			}
			
			//controllo scadenza fruitore se è scaduto lo cancello NON VA 
			public void controlloScadenza(LocalDateTime d){
				if(!elenco.isEmpty()){//d data corrente
				for(Fruitore f: elenco){
					if(f.getScadenza_iscrizione().isAfter(d)){
						System.out.println( f.toString() + "\n-->ISCRIZIONE NON ANCORA SCADUTA");
					}
					else{
						System.out.println("-->ISCRIZIONE SCADUTA");
						elenco.remove(f);
					}
				}
			 }
				else{
					System.out.println("L'ELENCO E' VUOTO");
				}
			}
}
