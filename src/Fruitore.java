import java.time.LocalDateTime;

import sun.util.calendar.BaseCalendar.Date;

public class Fruitore extends Cittadino{
	
	private LocalDateTime inizio_iscrizione;
	private LocalDateTime scadenza_iscrizione;
	
	public Fruitore(String nome){
	    super(nome);
		this.inizio_iscrizione = Data.creaData();
		this.scadenza_iscrizione = calcolo_scadenza();
	}
	
	public LocalDateTime calcolo_scadenza(){
	  //5 anni dopo quella di iscrizione
	  scadenza_iscrizione = Data.cambiaAnno(5);
	  return scadenza_iscrizione;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("#########################################################################");
		sb.append("FRUITORE: " + nome);
		sb.append("\nDATA ISCRIZIONE: " + Data.convertoData(inizio_iscrizione));
		sb.append("\nDATA SCADENZA: " + Data.convertoData(scadenza_iscrizione) );
		return sb.toString();
	}
}
