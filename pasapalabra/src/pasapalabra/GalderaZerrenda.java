package pasapalabra;

import java.util.Iterator;
import java.util.LinkedList;


public class GalderaZerrenda {
	
	private LinkedList<Galdera> listaGaldera;
	private int egungoHizkia;
	private int buelta;
	
	public GalderaZerrenda(){
		this.listaGaldera=new LinkedList<Galdera>();
		egungoHizkia=-1;
		this.buelta =0;
	}
	
	public int getBuelta() {
		return buelta;
	}
	public int getEgungoHizkia() {
		return egungoHizkia;
	}
	public void gehituGaldera(Galdera pGaldera){
		try{
			if (!this.listaGaldera.contains(pGaldera)){
				this.listaGaldera.add(pGaldera);
			}else{
				throw new GalderaBadagoException();
			}
		}catch(GalderaBadagoException e){
			
		}
	}
	public Galdera HurrengoGalderaEman() throws Exception{
		if(this.egungoHizkia==-1){
			this.egungoHizkia=0;
			char mychar = (char) (65+egungoHizkia);
			System.out.println((buelta+1)+" bueltan gaude ------- "+mychar);
			return this.listaGaldera.getFirst();
		}
		Galdera g=this.listaGaldera.get(egungoHizkia);
		Galdera g2=null;
		Iterator<Galdera> it= this.listaGaldera.iterator();
		while(it.hasNext()){
			g2=it.next();
			if (g2==g){
				break;
			}
		}
		boolean aurkitua = false;
		while (it.hasNext()){
			g2=it.next();
			this.egungoHizkia++;
			if(g2.getAukera()==Aukera.HUTSIK){
				aurkitua=true;
				break;
			}
		}
		if(aurkitua){
			char mychar = (char) (65+egungoHizkia);
			System.out.println((buelta+1)+" bueltan gaude ------- "+mychar);
			return g2;
		}else{
			if(buelta==2){
				throw new Exception();
			}
			buelta++;
			it=this.listaGaldera.iterator();
			g2=it.next();
			this.egungoHizkia=0;
			aurkitua=false;
			while (g2!=g){
				if(g2.getAukera()==Aukera.HUTSIK){
					aurkitua=true;
					break;
				}
				g2=it.next();
				this.egungoHizkia++;
			}
			if(!aurkitua){
				throw new Exception();
			}
			char mychar = (char) (65+egungoHizkia);
			System.out.println((buelta+1)+" bueltan gaude ------- "+mychar);
			return g2;
		}
		
	}
	public int lortuPuntuazioa(){
		Iterator<Galdera> it=this.listaGaldera.iterator();
		int punt=0;
		Galdera gal;
		while(it.hasNext()){
			gal=it.next();
			punt= punt + gal.gehituPuntuak();
		}
		return punt;
		
	}
	

}
