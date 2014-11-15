package pasapalabra;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.List;

import org.jdom2.Document;      
import org.jdom2.Element;         
import org.jdom2.JDOMException;    
import org.jdom2.input.SAXBuilder;



public class DatuKargatzaile {
	private static DatuKargatzaile ni;
	private Element rootNode;
	
	private DatuKargatzaile() throws JDOMException, IOException {
		File fileXML=new File("GalderakAmaituta.xml");
		SAXBuilder builder=new SAXBuilder();
		Document document=(Document)builder.build(fileXML);
		rootNode = document.getRootElement();
	}
	
	public static DatuKargatzaile getDatuKargatzaile(){
		if (DatuKargatzaile.ni == null){
			try {
				DatuKargatzaile.ni = new DatuKargatzaile();
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return DatuKargatzaile.ni;
	}
	
	 public Galdera prestatuGalderak(String pLetra){
		List<Element> list=rootNode.getChildren("hizkia");
		Element hizkia = null;
		for (int i=0; i<list.size();i++){
			hizkia= (Element) list.get(i);
			//System.out.println("for ean sartu da " + pLetra+ " - " + i + " - " + hizkia.getAttributeValue("id"));
			if(hizkia.getAttributeValue("id").equals(pLetra)){
				break;
			}
		}
		List<Element> galderak=hizkia.getChildren("galdera");
		Random r1=new Random();
		int hautatua=r1.nextInt(galderak.size());
		Element galdera = (Element) galderak.get(hautatua);
		//System.out.println("hurrengo letra");
		return new Galdera(galdera.getChildTextTrim("enuntziatua"), galdera.getChildTextTrim("erantzuna"));
		
	 } 
		
}
