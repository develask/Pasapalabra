package pasapalabra;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Idazketa {
	
		private static String path1 ="Ranking.xml";
		private static Idazketa nIdazketa;
		
		private Idazketa(){
			
		}
		public static Idazketa getIdazketa(){
			if(Idazketa.nIdazketa==null){
				Idazketa.nIdazketa= new Idazketa();
			}
			return Idazketa.nIdazketa;
		}
		private Document sartuJokalaria(Document doc, Jokalaria ji, String i) {
			Element Jokalaria = new Element("Jokalaria");
			Jokalaria.setAttribute(new Attribute("id", i));
			Jokalaria.addContent(new Element("izena").setText(ji.getIzena()));
			Jokalaria.addContent(new Element("puntuazioa").setText(ji.getPuntuazioaS()));
			doc.getRootElement().addContent(Jokalaria);
			return doc;
		}

		public void idatzi(ArrayList<Jokalaria> joks) throws TransformerException, JDOMException, IOException {
			// Document de XML
			File fileXML=new File(path1);
			SAXBuilder builder=new SAXBuilder();
			Document documento=(Document)builder.build(fileXML);
			
			// Obtención del TransfomerFactory y del Transformer a partir de él.
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// Creación de la fuente XML a partir del documento.
			DOMSource source = new DOMSource();

			// Creación del resultado, que será un fichero.
			StreamResult result = new StreamResult(fileXML);

			// Se realiza la transformación, de Document a Fichero.
			transformer.transform(source, result);

			documento.getRootElement().removeContent();
			for (Integer i = 0; i < joks.size(); i++) {
				documento = this.sartuJokalaria(documento, joks.get(i), i.toString());
			}

			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			try {
				xmlOutput.output(documento, new FileWriter(path1));
				System.out.println("File Saved!");
			} catch (IOException e) {
				System.out.println("Arazo idazketa.idazketa catch1");
				e.printStackTrace();
			}

		}

}
