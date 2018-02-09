
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
	//static
	private static  LocalDateTime data;
	private static String dataString;
	
	public static LocalDateTime creaData(){
		data = LocalDateTime.now();
		return data;
	}
	
	public static String convertoData(LocalDateTime d){
		 dataString = d.format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
		 return dataString;
	}
	//come converto in uno oggetto di tipo data????
	public static LocalDateTime cambiaAnno(int a){
		return data.plusYears(a);
	}

	
	
	
}
