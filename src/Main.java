import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import mylib.InputDati;

public class Main {

	public static void main(String[] args) {
     
//	 
//	 LocalDateTime c = d.cambiaAnno(5);
//	 dataString1 = c.format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
//     System.out.println(dataString1);
		
		Cittadino c;
		Fruitore f;
		ElencoFruitori s = new ElencoFruitori();
		System.out.println("BENVENUTO NEL NOSTRO REGISTRO DI ARCHIVIAZIONE PRESTITI!");
		//RICHIESTA MENU
		char a = InputDati.leggiChar("VUOI DIVENTARE UN FRUITORE DEL NOSTRO SERVIZIO? S/N");
		
		do{
	     c = Cittadino.creaCittadino();
		 if(c.iscrizione()){
			  System.out.println("SEI DIVENTATO FRUITORE! ORA POTRAI USUFRUIRE DEI PRESTITI BIBLIOTECARI");
			  f = new Fruitore(c.getNome());
			  System.out.println(f.toString());
			  s.aggiungiFruitore(f);
		 }
		 else{
			System.out.println("NON PUOI DIVENTARE UN FRUITORE PERCHE' HAI MENO DI 18 ANNI");
		 }
		}while(mylib.InputDati.yesOrNo("VUOI CONTINUARE? "));
		
		System.out.println(s.stampaElenco());
	}

}
