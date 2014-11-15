package pasapalabra;

import leioak.Jokatu;


public class Denbora extends Thread { 
	private int segundos; 
	private int minutos;
	private boolean exit=false;
	private boolean itxoin=false;
	private static Denbora nDenbora=null;
	private Jokatu jo;
	
	public static Denbora getDenbora(Jokatu j){
		if(Denbora.nDenbora==null){
			Denbora.nDenbora=new Denbora("Denbora", j);
		}
		return Denbora.nDenbora;
	}
	private Denbora(String pNombre, Jokatu j){ 
		super(pNombre);
		this.jo = j;
	} 
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void exit(){
		this.exit=true;
	}
	public void pause(){
		this.itxoin=true;
	}
	public void segi(){
		this.itxoin=false;
	}
	public synchronized void run(){
    	for(minutos=2;minutos>=0;minutos--){
			for(segundos=59;segundos>=0;segundos--){
				if(exit){
					break;
				}
				Jokatu.timer.setText(minutos + ":"+ segundos);
				delaySegundo();
				while (itxoin){
					delaySegundo();
				}
			}
			if(exit){
				break;
			}
		}
    	Denbora.nDenbora=null;
    	jo.irten();
	}
	public static void delaySegundo(){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			
		}
	
	}

} 