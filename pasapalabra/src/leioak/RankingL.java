package leioak;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pasapalabra.Jokalaria;


public class RankingL extends JFrame {

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
 private JTextField[] textField;
 private JButton btnIrten;


 /*
  * Create the frame.
  */
 public RankingL() {
 	setFont(new Font("Courier 10 Pitch", Font.PLAIN, 14));
 	setTitle("RANKING");
 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	setBounds(100, 100, 450, 300);
 	contentPane = new JPanel();
 	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 	setContentPane(contentPane);
 	contentPane.setLayout(null);
 	 
 	btnIrten = new JButton("irten");
 	btnIrten.setBounds(298, 223, 117, 25);
 	contentPane.add(btnIrten);
 	
 	textField = new JTextField[10];
 	 
 	textField[0] = new JTextField();
 	textField[0].setText("1.");
 	textField[0].setBounds(32, 49, 114, 19);
 	contentPane.add(textField[0]);
 	textField[0].setColumns(10);
 	 
 	textField[1] = new JTextField();
 	textField[1].setText("2.");
 	textField[1].setBounds(176, 49, 114, 19);
 	contentPane.add(textField[1]);
 	textField[1].setColumns(10);
 	 
 	textField[2] = new JTextField();
 	textField[2].setText("3.");
 	textField[2].setBounds(322, 49, 114, 19);
 	contentPane.add(textField[2]);
 	textField[2].setColumns(10);
 	 
 	textField[3] = new JTextField();
 	textField[3].setText("4.");
 	textField[3].setBounds(32, 96, 114, 19);
 	contentPane.add(textField[3]);
 	textField[3].setColumns(10);
 	 
 	textField[4] = new JTextField();
 	textField[4].setText("5.");
 	textField[4].setBounds(176, 96, 114, 19);
 	contentPane.add(textField[4]);
 	textField[4].setColumns(10);
 	 
 	textField[5] = new JTextField();
 	textField[5].setText("6.");
 	textField[5].setBounds(322, 96, 114, 19);
 	contentPane.add(textField[5]);
 	textField[5].setColumns(10);
 	 
 	textField[6] = new JTextField();
 	textField[6].setText("7.");
 	textField[6].setBounds(32, 147, 114, 19);
 	contentPane.add(textField[6]);
 	textField[6].setColumns(10);
 	 
 	textField[7] = new JTextField();
 	textField[7].setText("8.");
 	textField[7].setBounds(176, 147, 114, 19);
 	contentPane.add(textField[7]);
 	textField[7].setColumns(10);
 	 
 	textField[8] = new JTextField();
 	textField[8].setText("9.");
 	textField[8].setBounds(322, 147, 114, 19);
 	contentPane.add(textField[8]);
 	textField[8].setColumns(10);
 	 
 	textField[9] = new JTextField();
 	textField[9].setText("10.");
 	textField[9].setBounds(32, 198, 114, 19);
 	contentPane.add(textField[9]);
 	textField[9].setColumns(10);
 	
 	for (JTextField t: textField){
 		t.setEditable(false);
 	}
 	 
 	Kudeatzailea3 kud = new Kudeatzailea3();
 	btnIrten.addActionListener((ActionListener) kud);
 	 
 }
 public void marraztu(ArrayList<Jokalaria> listaJokalari){
	 int a = 0;
		for(Jokalaria i: listaJokalari){
			textField[a].setText((a+1)+". "+i.getIzena()+": "+ i.getPuntuazioa());
			a++;
			if (a==10){
				break;
			}
		}
 }
 private class Kudeatzailea3 implements ActionListener{

 	@Override
 	public void actionPerformed(ActionEvent evento) {
 	 if(evento.getSource().equals(btnIrten)){
 	 JFrame leihoa = new Hasiera();
 	 leihoa.setVisible(true);
 	 dispose();
 	 }
 	}
 	 
 }
}
