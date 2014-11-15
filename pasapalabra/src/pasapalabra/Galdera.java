package pasapalabra;

public class Galdera {
	private String enuntziatua;
	private String erantzuna;
	private Aukera aukera;
	
	public Galdera(String pEnun,String pEran) {
		this.enuntziatua=pEnun;
		this.erantzuna=pEran;
		this.aukera=Aukera.HUTSIK;
	}
	public Aukera getAukera() {
		return aukera;
	}
	public String getEnuntziatua() {
		return enuntziatua;
	}
	public String getErantzuna() {
		return erantzuna;
	}
	private void aukeraAldatu(int pOption){
		switch (pOption) {
		case 1:
			this.aukera=Aukera.ONDO1;
		break;
		case 2:
			this.aukera=Aukera.ONDO2;
		break;
		case 3:
			this.aukera=Aukera.ONDO3;
		break;
		case -1:
			this.aukera=Aukera.HUTSIK;
		break;
		case 0:
			this.aukera=Aukera.TXARTO;
		break;
		}
	}
	public int gehituPuntuak(){
		int i=this.interpretatuAukera(this.aukera);
		return i;
	}
	private int interpretatuAukera(Aukera auk){
		switch (auk) {
		case TXARTO:
			return -1;
		case ONDO1:
			return 3;
		case ONDO2:
			return 2;
		case ONDO3:
			return 1;
		default:
			return 0;
		}
	}
	public int konprobatuErantzuna(String pErantzuna,int pBuelta){	
		if (this.getErantzuna().toLowerCase().equals(pErantzuna.toLowerCase())){
			this.aukeraAldatu(pBuelta);
			return 1;
		}else if(pErantzuna.toLowerCase().contains("pasapalabra")){
			this.aukeraAldatu(-1);
			return 0;
		}else {
			this.aukeraAldatu(0);
			return 2;
		}
	}
}
