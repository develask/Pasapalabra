package pasapalabra;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;      
import org.jdom2.Element;         
import org.jdom2.JDOMException;    
import org.jdom2.input.SAXBuilder;


public class Ranking {
	private ArrayList<Jokalaria> listaJokalari;
	private static Ranking nListaJokalari=null;
	
	private Ranking(){
		this.listaJokalari=new ArrayList<Jokalaria>();
	}
	public static Ranking getRanking(){
		if(Ranking.nListaJokalari==null){
			Ranking.nListaJokalari= new Ranking();
		}
		return Ranking.nListaJokalari;
	}
	public void aktualizatuJokalaria(Jokalaria pJok){
		Ranking.getRanking().bueltatuJokalaria(pJok.getIzena());
		if (!Ranking.getRanking().listaJokalari.contains(pJok)){
			Ranking.getRanking().listaJokalari.add(pJok);	
		}
		Collections.sort(Ranking.getRanking().listaJokalari,new Comparator<Jokalaria>() {
			@Override
			public int compare(Jokalaria o1, Jokalaria o2) {
				return o2.getPuntuazioa()- o1.getPuntuazioa();
			}
		});
	}
	public Jokalaria bueltatuJokalaria(String pJokIzena){
		boolean aurkitua=false;
		Iterator<Jokalaria> it=Ranking.getRanking().getIteradorea();
		Jokalaria jok=null;
		while(!aurkitua  && it.hasNext()){
			jok=it.next();
			if(jok.getIzena().equals(pJokIzena)){
				aurkitua=true;
			}
		}
		if (!aurkitua){
			Jokalaria jk=new Jokalaria(pJokIzena);
			return jk;
		}else{
			return jok;
		}
	}
	public void kargatu() throws JDOMException, IOException{
		File fileXML=new File("Ranking.xml");
		SAXBuilder builder=new SAXBuilder();
		Document document=(Document)builder.build(fileXML);
		Element rootNode = document.getRootElement();
		
		List<Element> list=rootNode.getChildren("Jokalaria");
		Element jokalaria;
		for (int i =0; i<list.size(); i++){
			jokalaria=(Element)list.get(i);
			this.listaJokalari.add(new Jokalaria(jokalaria.getChildTextTrim("izena"), Integer.parseInt(jokalaria.getChildTextTrim("puntuazioa"))));
		}
	}
	private Iterator<Jokalaria> getIteradorea(){
		return Ranking.getRanking().listaJokalari.iterator();
	}
	
	public ArrayList<Jokalaria> getListaJokalari() {
		return listaJokalari;
	}

	
}
