import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Slate extends JFrame{

	// Menu
	private JMenuBar menuBar = new JMenuBar();
	JMenu fichier = new JMenu("Fichier"), 
			edition = new JMenu("Edition"), 
			forme = new JMenu("Forme"),
			couleur = new JMenu("Couleur");
	JMenuItem nouveau = new JMenuItem("Nouveau"),
			quitter= new JMenuItem("Quitter"),
			rond= new JMenuItem("Rond"),
			carre= new JMenuItem("Carré"),
			bleu= new JMenuItem("Bleu"), 
			vert = new JMenuItem ("Vert"),
			rouge= new JMenuItem("Rouge"),
			rose= new JMenuItem("Rose");
	
	//Barre d'outils 
	JToolBar toolBar= new JToolBar();
	
	JButton square= new JButton(new ImageIcon("carre.png")),
			circle= new JButton(new ImageIcon("circle.png")),
			red= new JButton(new ImageIcon("red.png")),
			green= new JButton(new ImageIcon("green.png")),
			blue = new JButton(new ImageIcon("blue.png")),
			pink = new JButton(new ImageIcon("pink.png"));
	
	//Listener
	private FormeListener fListener= new FormeListener();
	private ColorListener cListener= new ColorListener();
	
	private DrawPanel drawPanel= new DrawPanel();
	
	//constructeur
	public Slate() { 
		this.setSize(800, 800);
		this.setLocationRelativeTo(nouveau);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.initMenu();
		this.initToolBar();
		this.getContentPane().add(drawPanel, BorderLayout.CENTER);
		this.setVisible(true);
		}
		
	private void initMenu() {
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawPanel.erase();
				
			}
		
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		
		fichier.add(nouveau);
		fichier.addSeparator();
		fichier.add(quitter);
		fichier.setMnemonic('F');
		
		
		edition.add(forme);
		edition.addSeparator();
		edition.add(couleur);
		edition.setMnemonic('E');
		
		carre.addActionListener(fListener);
	    rond.addActionListener(fListener);
		forme.add(rond);
		forme.add(carre);
		
		rouge.addActionListener(cListener);
		vert.addActionListener(cListener);
		bleu.addActionListener(cListener);
		rose.addActionListener(cListener);
		couleur.add(rouge);
		couleur.add(vert);
		couleur.add(bleu);
		couleur.add(rose);
		
		menuBar.add(fichier);
		menuBar.add(edition);
		
		this.setJMenuBar(menuBar);
	}
	
	private void initToolBar() {
		
		JPanel panneau= new JPanel();
		
		square.addActionListener(fListener);
		circle.addActionListener(fListener);
		red.addActionListener(cListener);
		green.addActionListener(cListener);
		blue.addActionListener(cListener);
		pink.addActionListener(cListener);
		
		toolBar.add(square);
		toolBar.add(circle);
		
		toolBar.addSeparator();
		toolBar.add(red);
		toolBar.add(green);
		toolBar.add(blue);
		toolBar.add(pink);
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		
	}
	
	//Listener
	class FormeListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")) {
				if(e.getSource() == carre)
					drawPanel.setPointerType("SQUARE");
				else
					drawPanel.setPointerType("CIRCLE");
			}
			else {
				if(e.getSource()== square)
					drawPanel.setPointerType("SQUARE");
				else
					drawPanel.setPointerType("CIRCLE");
			}
		}
	}
	
	class ColorListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().getClass().getName().equals("javax.swing.JMenuItem")) {
				if(e.getSource()== vert)
					drawPanel.setPointerColor(Color.green);
				else if(e.getSource()== bleu)
					drawPanel.setPointerColor(Color.blue);
				else if(e.getSource()== rouge)
					drawPanel.setPointerColor(Color.red);
				else
					drawPanel.setPointerColor(Color.pink);
				
			}
			else {
				if(e.getSource()== green)
					drawPanel.setPointerColor(Color.green);
				else if(e.getSource()== blue)
					drawPanel.setPointerColor(Color.blue);
				else if(e.getSource()== red)
					drawPanel.setPointerColor(Color.red);
				else
					drawPanel.setPointerColor(Color.pink);
			}
		}
	}

}
