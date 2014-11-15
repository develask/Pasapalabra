package pasapalabra;


public class Jokalaria {
	
	private String izena;
	private int puntuazioa;
	
	
	public Jokalaria(String pIzena) {
		this.izena=pIzena;
		this.puntuazioa=0;
	}
	public Jokalaria(String pIzena,int pPunt) {
		this.izena=pIzena;
		this.puntuazioa=pPunt;
	}
	public void setPuntuazioa(int puntuazioa) {
		if	(this.puntuazioa<puntuazioa){
			this.puntuazioa = puntuazioa;
		}
	}
	public int getPuntuazioa() {
		return puntuazioa;
	}
	public String getPuntuazioaS() {
		return puntuazioa+"";
	}
	public String getIzena() {
		return izena;
	}
	public void puntuazioaAktualizatu(int puntuak){
		this.setPuntuazioa(puntuak);
		Ranking.getRanking().aktualizatuJokalaria(this);
	}
	public boolean jokalariaDa(String pJokIzen){
		return (this.getIzena().equals(pJokIzen));
	}
}
