package leioak;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pasapalabra.Denbora;
import pasapalabra.Galdera;
import pasapalabra.Jokalaria;
import pasapalabra.Ranking;
import pasapalabra.Roskoa;
import pasapalabra.Wait;

public class Jokatu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4647788642856569461L;
	public static JPanel contentPane;
	public static JLabel timer;
	private JTextField erantzuna;
	private JButton pasapalabra;
	private Galdera gal;
	private JLabel galdera;
	public JLabel[] letrak;
	private Denbora d =Denbora.getDenbora(this);
	public Jokalaria jok;
	private Kudeatzaile kud;

	/**
	 * Create the panel.
	 * @param izena 
	 */
	public Jokatu(String izena) {
		
		jok = Ranking.getRanking().bueltatuJokalaria(izena);
		Roskoa.getRoskoa().kargatuRoskoa(jok);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		
		JLabel izen = new JLabel(jok.getIzena() +": " + jok.getPuntuazioa());
		izen.setBounds(20, 10, 150, 30);
		Font font = izen.getFont();
		Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize()+10);
		izen.setFont(boldFont);
		contentPane.add(izen);
		
		kud = new Kudeatzaile();
		
		erantzuna = new JTextField();
		erantzuna.setBounds(40, 435, 300, 30);
		contentPane.add(erantzuna);
		erantzuna.addKeyListener(kud);
		
		pasapalabra = new JButton("PasaPalabra");
		pasapalabra.setBounds(340, 435, 100, 30);
		contentPane.add(pasapalabra);
		pasapalabra.addActionListener(kud);
		
		galdera = new JLabel("Here come the questions");
		galdera.setBounds(40, 390, 600, 45);
		contentPane.add(galdera);
		
		letrak = new JLabel[26];
		for (int i=1; i<=26; i++){
			letrak[i-1]=new JLabel((((char) (i+96))+"").toUpperCase());
			letrak[i-1].setBounds(this.getXKoordenatua(i), this.getYKoordenatua(i),30,30);
			font = letrak[i-1].getFont();
			boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize()+5);
			letrak[i-1].setFont(boldFont);
			letrak[i-1].setHorizontalAlignment(SwingConstants.CENTER);
			letrak[i-1].setForeground(Color.WHITE);
			letrak[i-1].setBackground(Color.BLUE);
			//letrak[i-1].setBorder(new RoundedBorder(30));
			letrak[i-1].setOpaque(true);
			letrak[i-1].repaint();
			contentPane.add(letrak[i-1]);
		}
		
		timer = new JLabel("3:00");
		font = timer.getFont();
		boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize()+20);
		timer.setFont(boldFont);
		timer.setBounds(330,180, 80, 30);
		contentPane.add(timer);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		d.start();
		try {
			gal=Roskoa.getRoskoa().galderak.HurrengoGalderaEman();
			String str = ((char)(Roskoa.getRoskoa().galderak.getEgungoHizkia()+97)+"").toUpperCase()+ ": " + gal.getEnuntziatua();
			galdera.setText("<HTML>"+str+"</HTML>");
			letrak[Roskoa.getRoskoa().galderak.getEgungoHizkia()].setBackground(Color.ORANGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private int getXKoordenatua(int i){
		int luzera = 180;
		return 350 + (int) (Math.sin(2*Math.PI*(i-1)/26)*luzera);
	}
	
	private int getYKoordenatua(int i){
		int luzera = 180;
		return luzera - (int) (Math.cos(2*Math.PI*(i-1)/26)*luzera);
	}
	public void irten(){
		int puntuak=Roskoa.getRoskoa().galderak.lortuPuntuazioa();
		Roskoa.getRoskoa().borratuRoskoa();
		this.jok.puntuazioaAktualizatu(puntuak);
		JOptionPane.showMessageDialog(Jokatu.contentPane,"Lortu duzun puntuazioa: " + puntuak);
		if (kud != null){
			kud.irten();
		}
	}
	
	private class Kudeatzaile implements ActionListener, KeyListener {
		
		private void irten(){
			Hasiera has=new Hasiera();
			has.setVisible(true);
			dispose();
		}
		
		private void egin(String erantzun){
			if (d.isAlive()){
				try {
					int er = gal.konprobatuErantzuna(erantzun, Roskoa.getRoskoa().galderak.getBuelta()+1);
					switch (er){
					case 1:
						letrak[Roskoa.getRoskoa().galderak.getEgungoHizkia()].setBackground(Color.GREEN);
						break;
					case 2:
						letrak[Roskoa.getRoskoa().galderak.getEgungoHizkia()].setBackground(Color.RED);
						d.pause();
						JOptionPane.showMessageDialog(Jokatu.contentPane, "Aukera egoekia: " + gal.getErantzuna(),"Txarto!",JOptionPane.ERROR_MESSAGE);
						d.segi();
						break;
					default:
						letrak[Roskoa.getRoskoa().galderak.getEgungoHizkia()].setBackground(Color.BLUE);
					}
					gal=Roskoa.getRoskoa().galderak.HurrengoGalderaEman();
					letrak[Roskoa.getRoskoa().galderak.getEgungoHizkia()].setBackground(Color.ORANGE);
					String str = ((char)(Roskoa.getRoskoa().galderak.getEgungoHizkia()+97)+"").toUpperCase()+ ": " + gal.getEnuntziatua();
					galdera.setText("<HTML>"+str+"</HTML>");
					erantzuna.setText("");
				} catch (Exception e) {
					d.exit();
					Wait.manySec(1);
					System.out.println("AMAITU DA ");
				}
			}else{
				d.exit();
				Wait.manySec(1);
				dispose();
				System.out.println("AMAITU DA ");
			}
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			int key = arg0.getKeyCode();
			if (key == KeyEvent.VK_ENTER){
				if (erantzuna.getText().equals("")){
					this.egin("PasaPalabra");
				}else{
					this.egin(erantzuna.getText());
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.egin("PasaPalabra");
		}
		
	}

}
