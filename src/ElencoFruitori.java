import java.util.ArrayList;

public class ElencoFruitori {
	private ArrayList<Fruitore> elenco;
	
	public ElencoFruitori(){
		elenco = new ArrayList<Fruitore>();
	}
	
	public void aggiungiFruitore(Fruitore f){
		elenco.add(f);
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
	
}
