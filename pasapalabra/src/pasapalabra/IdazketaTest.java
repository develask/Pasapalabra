package pasapalabra;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

import org.jdom2.JDOMException;
import org.junit.Test;

public class IdazketaTest {

	@Test
	public void test() throws TransformerException, JDOMException, IOException {
		Jokalaria j1 = new Jokalaria("Unai", 5);
		Jokalaria j2 = new Jokalaria("Ander",5);
		Jokalaria j3 = new Jokalaria("Aitor", 9);
		ArrayList<Jokalaria> joks = new ArrayList<Jokalaria>();
		joks.add(j3);
		joks.add(j2);
		joks.add(j1);
		Idazketa.getIdazketa().idatzi(joks);

	}

}
