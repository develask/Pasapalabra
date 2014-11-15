package leioak;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Irudia extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Irudia() {
	}

	public void paintComponent(Graphics g){
		Dimension dim=getSize();
		ImageIcon imagen = new ImageIcon(getClass().getResource("/leioak/pasapalabra1.jpg"));
		g.drawImage(imagen.getImage(), 0,0, dim.width, dim.height, null);
	}

}
