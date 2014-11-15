package pasapalabra;


import org.junit.Test;

public class DenboraTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testRun() throws InterruptedException{
		try{
			Denbora d= Denbora.getDenbora(null);
			d.start();
			Thread.sleep(10000);
			System.out.println("kill");
			d.destroy();
			Thread.sleep(1000000);
		}catch(NoSuchMethodError e){
			System.out.println("Excepcion atrapada");
		}
	}

}
