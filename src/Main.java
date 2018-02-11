import java.time.LocalDateTime;
import mylib.MyMenu;


public class Main {

	public static void main(String[] args) {
		LocalDateTime d;
		LocalDateTime termine;
		Cittadino c;
		Fruitore f;
		ElencoFruitori s = new ElencoFruitori();
		boolean uscita = false;
		
		String titolo = "BENVENUTO NEL NOSTRO REGISTRO DI ARCHIVIAZIONE PRESTITI!";
		String opzioni[] = {
				"Iscrizione al registro" , "Rinnovo iscrizione", "Stampa registro fruitori" };
		MyMenu m = new MyMenu(titolo, opzioni);
		//RICHIESTA MENU
		
		do{
			switch(m.scegli()){
			case 1:
				  c = Cittadino.creaCittadino();
				  if(c.richiestaIscrizione()){//ISCRIZIONE VA A BUON FINE
					  f = new Fruitore(c.getNome());
					  System.out.println(f.toString());
					  s.iscrizioneFruitore(f);
					  System.out.println("SEI DIVENTATO FRUITORE! ORA POTRAI USUFRUIRE DEI PRESTITI BIBLIOTECARI");
				  }
		          else{//ISCRIZIONE NON VA A BUON FINE
						System.out.println("NON PUOI DIVENTARE UN FRUITORE PERCHE' HAI MENO DI 18 ANNI");
				  }
				  break;
			case 2:
				  f = s.selezionaFruitore();
				  termine = Data.creaData();//DATA IN CUI FACCIO LA RICHIESTA DI RINNOVO
				  s.rinnovo(termine, f);
				  //f.rinnovo(termine);
				  break;
			case 3:
			      d = Data.creaData();
				  s.controlloScadenza(d);
				  //System.out.println(s.stampaElenco());
				  break;
			case 0:
				 uscita = true;
				 break;
			}
		}while(uscita != true);
	
	}

}
