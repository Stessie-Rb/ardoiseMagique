import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	// Couleur du pointeur
	private Color color = Color.magenta;
	// Forme du pointeur
	private String pointerType = "CIRCLE";
	// Position du pointeur
	private int posX = -15, oldX = -15;
	private int posY = -15, oldY = -15;
	// Boolean pour savoir si on doit dessiner
	private boolean erase = true;
	// Taille du pointeur
	private int pointerSize = 15;
	// Liste des points
	private List<Point> points = new ArrayList<Point>();

	public DrawPanel() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				points.add(new Point(e.getX() - (pointerSize /2), e.getY() - (pointerSize /2), pointerSize, pointerType, color));
				repaint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {
				points.add(new Point(e.getX() -(pointerSize /2), e.getY() - (pointerSize /2), pointerSize, pointerType, color));
				repaint();
				
			}

			public void mouseMoved(MouseEvent e) {	
			}
			
		});
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		// On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(this.erase) {
			this.erase= false;
		}
		else {
			for(Point point : points) {
				g.setColor(point.getColor());
				
				if(point.getType().equals("SQUARE")) {
					g.fillRect(point.getPosX(), point.getPosY(), point.getSize(), point.getSize());
				}
				else {
					g.fillOval(point.getPosX(), point.getPosY(), point.getSize(), point.getSize() );
				}
			}
		}
			
	}
	
	public void erase() {
		this.erase= true;
		points= new ArrayList<Point>();
		repaint();
		
	}
	
	//Définir la couleur du point et son type
	public void setPointerColor(Color c) {
		this.color= c;
	}
	
	public void setPointerType(String pointerType) {
		this.pointerType= pointerType;
	}
}
