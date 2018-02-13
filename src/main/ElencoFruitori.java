package main;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mylib.Constants;
import mylib.InputDati;

/**
 * La classe ElencoFruitori rappresenta un elenco di fruitori del servizio di prestito
 * temporaneo. Ciascun fruitore è rappresentato mediante un nome, data di iscrizione e 
 * data di scadenza dell'iscrizione.
 * @author Marika
 *
 */
public class ElencoFruitori {
	private ArrayList<Fruitore> elenco;

	/**
	 * Costruttore classe ElencoFruitori. elenco è un'ArrayList di Fruitori del servizio prestito.
	 */
	public ElencoFruitori(){
		elenco = new ArrayList<Fruitore>();
	}
	
	/**
	 * Il metodo iscrizioneFruitore permette l'aggiunta di un fruitore all'elenco dei fruitori,
	 * controllando che il fruitore non sia già presente nell'elenco.
	 * @param f
	 */
	public boolean iscrizioneFruitore(Fruitore f){
		if(elenco.isEmpty()){
			elenco.add(f);
			return true;
		}
		else{
			for(int i=0; i< elenco.size(); i++){
				if(f.getNome().equalsIgnoreCase(elenco.get(i).getNome())){
					return false;
				}
			}
		}
		elenco.add(f);
		return true;
	}
	
	/**
	 * Il metodo rimozioneFruitore permette la rimozione di un fruitore dall'elenco dei fruitori.
	 * @param f
	 */
	public void rimozioneFruitore(Fruitore f){
		elenco.remove(f); 
	}

	/**
	 * Il metodo stampaElenco stampa l'elenco degli attuali fruitori. Inoltre, verifica che le iscrizioni
	 * dei singoli fruitori non siano scadute, cancellando eventualmente il fruitore scaduto dall'elenco.
	 * @return
	 */
	public String stampaElenco(){
		controlloScadenza(LocalDateTime.now());
		StringBuilder sb = new StringBuilder();
		sb.append("ELENCO FRUITORI: " + "\n" + "\n");
		for(int i = 0; i < elenco.size(); i++){
			sb.append(i+1 + " ");
			sb.append(elenco.get(i).toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Il metodo selezionaFruitore consente di selezionare un fruitore dall'elenco dei fruitori.
	 * @return
	 */
	public Fruitore selezionaFruitore(){
		System.out.println(this.stampaElenco());
		int valore = InputDati.leggiIntero("inserisci il numero relativo al cittadino", 1, elenco.size());
		return elenco.get(valore -1);
	}
	
	/**
	 *Il metodo controlloScadenza permette di controllare per ogni fruitore la data di scadenza 
	 *dell'iscrizione. Se la data è scaduta, il fruitore viene rimosso dall'elenco dei fruitori.
	 * @param d
	 */
	private void controlloScadenza(LocalDateTime d){
			if( !elenco.isEmpty()){//d data corrente
				
				List<Fruitore> toRemove = new ArrayList<Fruitore>();
				
				for(Fruitore f : elenco){
					if(f.getScadenzaIscrizione().isAfter(d)){
						System.out.println( f.toString() + Constants.ISCRIZIONE_NON_SCADUTA + "\n");
					}
					else{
						System.out.println(Constants.ISCRIZIONE_SCADUTA);
						toRemove.add(f);
					}
				}
				
				elenco.removeAll(toRemove);
				
				
			 } else{
					System.out.println(Constants.ELENCO_VUOTO);
			}
	}
}
