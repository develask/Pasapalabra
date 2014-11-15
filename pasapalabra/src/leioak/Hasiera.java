package leioak;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pasapalabra.Idazketa;
import pasapalabra.Ranking;

public class Hasiera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private JButton jokatu;
	private JButton ranking;
	private JButton irten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking.getRanking().kargatu();
					Hasiera frame = new Hasiera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hasiera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new Irudia();
		
		jokatu = new JButton("jokatu");
		jokatu.setBounds(40, 400, 140, 50);
		contentPane.add(jokatu);
		ranking = new JButton("Ranking-a ikusi");
		ranking.setBounds(230, 400, 240, 50);
		contentPane.add(ranking);
		irten = new JButton("irten");
		irten.setBounds(520, 400, 140, 50);
		contentPane.add(irten);
		Irudia background = new Irudia();
		background.setBounds(0, 0, 700, 500);
		this.add(background);
		Kudeatzaile kud = new Kudeatzaile();
		jokatu.addActionListener(kud);
		ranking.addActionListener(kud);
		irten.addActionListener(kud);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	
	private class Kudeatzaile implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (arg0.getSource().equals(jokatu)){
				JFrame logeatu = new Logeatu();
				logeatu.setVisible(true);
				dispose();
			}else if (arg0.getSource().equals(ranking)){
				RankingL ranking = new RankingL();
				ranking.marraztu(Ranking.getRanking().getListaJokalari());
				ranking.setVisible(true);
				dispose();
			}else if (arg0.getSource().equals(irten)){
				try {
					Idazketa.getIdazketa().idatzi(Ranking.getRanking().getListaJokalari());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Arazo bat egon da ranking-a aktualizatzen","Arazoa",JOptionPane.WARNING_MESSAGE);
				}
				dispose();
				System.exit(0);
			}
			
		}
		
		
		
	}
}
