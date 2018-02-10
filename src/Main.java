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
				 // d = Data.creaData();
				 // s.controlloScadenza(d);
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
				//  d = Data.creaData();
				 // s.controlloScadenza(d);
				  f = s.selezionaFruitore();
				  termine = Data.creaData();//DATA IN CUI FACCIO LA RICHIESTA DI RINNOVO
				  s.rinnovo(termine, f);
				  //f.rinnovo(termine);
				  break;
			case 3:
				  System.out.println(s.stampaElenco());
				  break;
			case 0:
				 uscita = true;
				 break;
			}
		}while(uscita != true);
	
//		char a = InputDati.leggiChar("VUOI DIVENTARE UN FRUITORE DEL NOSTRO SERVIZIO? S/N");
//		
//		do{
//	     c = Cittadino.creaCittadino();
//		 if(c.richiestaIscrizione()){//sarà un opzione del menù
//			  f = new Fruitore(c.getNome());
//			  //System.out.println(f.toString());
//			  s.iscrizioneFruitore(f);//iscrizione va a buon fine
//			  System.out.println("SEI DIVENTATO FRUITORE! ORA POTRAI USUFRUIRE DEI PRESTITI BIBLIOTECARI");
//			   a = InputDati.leggiChar("VUOI RINNOVARE LA TUA ISCRIZIONE? S/N");//ci sarà un opzione nel menù
//			   if(a == 'S'){
//				   termine = Data.creaData();//FINO A QUI GIUSTO
//				   System.out.println(termine.toString());
//				   f.rinnovo(termine);
//					  //System.out.println(f.toString());
//
//			   }
//		 }
//		 else{//iscrizione non va a buon fine
//			System.out.println("NON PUOI DIVENTARE UN FRUITORE PERCHE' HAI MENO DI 18 ANNI");
//		 }
//		}while(mylib.InputDati.yesOrNo("VUOI CONTINUARE? "));
//		
//		System.out.println(s.stampaElenco());
	}

}
