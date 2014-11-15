package pasapalabra;


import java.util.Scanner;



public class Roskoa  extends Thread {
	public static Scanner sc=new Scanner(System.in);
	public Jokalaria jokalari;
	public GalderaZerrenda galderak;
	private static Roskoa nRoskoa = null;

	private Roskoa() {
		this.galderak = null;
		this.jokalari = null;
	}
	
	public static Roskoa getRoskoa() {
		if (Roskoa.nRoskoa == null) {
			Roskoa.nRoskoa = new Roskoa();
		}
		return Roskoa.nRoskoa;
	}
	public void kargatuRoskoa(Jokalaria jok){
		this.galderak=this.galderakHasieratu();
		this.jokalari = jok;
	}
	public void borratuRoskoa(){
		this.galderak=null;
		this.jokalari=null;
	}

	private GalderaZerrenda galderakHasieratu() {
		GalderaZerrenda Gz = new GalderaZerrenda();
		for (int i = 97; i < 123; i++) {
			String letra = (char) i + "";
			try {
				Gz.gehituGaldera(DatuKargatzaile.getDatuKargatzaile()
						.prestatuGalderak(letra));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Arazoa Roskoa.galderaHasieratu metodoan");
				System.exit(0);
			}
		}
		return Gz;
	}

}
