package leioak;

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
import javax.swing.border.EmptyBorder;

public class Logeatu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel izenaSartu;
	private static JTextField izena;
	private JButton jokatu;
	
	
	

	/**
	 * Create the panel.
	 */
	public Logeatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		
		izenaSartu = new JLabel("Sartu zure izena");
		izenaSartu.setBounds(100, 20, 250, 30);
		Font font = izenaSartu.getFont();
		Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize()+15);
		izenaSartu.setFont(boldFont);
		contentPane.add(izenaSartu);
		
		izena = new JTextField();
		izena.setBounds(90, 70, 250, 30);
		contentPane.add(izena);
		
		jokatu = new JButton("jokatu");
		jokatu.setBounds(160, 110, 100, 30);
		contentPane.add(jokatu);
		
		Kudeatzaile kud = new Kudeatzaile();
		jokatu.addActionListener(kud);
		izena.addKeyListener(kud);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private class Kudeatzaile implements ActionListener, KeyListener {
		
		private void egin(){
			String izen = Logeatu.izena.getText();
			if (!izen.equals("")){
				JFrame logeatu = new Jokatu(izen);
				logeatu.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(contentPane, "Izena beharrezkoa da","Izena",JOptionPane.WARNING_MESSAGE);
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			int key = arg0.getKeyCode();
			if (key == KeyEvent.VK_ENTER){
				this.egin();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (arg0.getSource().equals(jokatu)){
				this.egin();
			}
			
		}
		
		
		
	}

}
