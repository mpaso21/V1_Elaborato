package main;
import java.time.LocalDateTime;

import mylib.Constants;
import mylib.Data;
import mylib.MyMenu;
//test jUnit

public class Main {

	public static void main(String[] args) {

		LocalDateTime termine;
		Cittadino cittadino;
		Fruitore fruitore;
		
		ElencoFruitori elencoFruitori = new ElencoFruitori();
		boolean uscita = false;
		
		String titolo = "BENVENUTO NEL NOSTRO REGISTRO DI ARCHIVIAZIONE PRESTITI!";
		String opzioni[] = {
				"Iscrizione al registro" , "Rinnovo iscrizione", "Stampa registro fruitori" };
		MyMenu m = new MyMenu(titolo, opzioni);
		
		do{
			switch(m.scegli()){
			case 1:
				  cittadino = Cittadino.creaCittadino();
				  if(cittadino.richiestaIscrizione()){//ISCRIZIONE VA A BUON FINE
					  fruitore = new Fruitore(cittadino.getNome());
					 // System.out.println(fruitore.toString());
					  if(elencoFruitori.iscrizioneFruitore(fruitore)){
						  System.out.println(Constants.ISCRITTO);
					  }
					  else{
						  System.out.println(Constants.FRUITORE_GIA_PRESENTE);
					  }
				  }
		          else{//ISCRIZIONE NON VA A BUON FINE
						System.out.println(Constants.NON_ISCRITTO);
				  }
				  break;
			case 2:
				  fruitore = elencoFruitori.selezionaFruitore();
				  termine = Data.creaData(); //DATA IN CUI FACCIO LA RICHIESTA DI RINNOVO

				  fruitore.rinnovo(termine, elencoFruitori);
				  break;
			case 3:
				  System.out.println(elencoFruitori.stampaElenco());
				  break;
			case 0:
				 uscita = true;
				 break;
			}
		}while(uscita != true);
	
	}

}
