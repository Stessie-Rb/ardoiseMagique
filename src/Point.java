import java.awt.Color;

public class Point {

	// Couleur
	private Color color = Color.magenta;

	// Taille
	private int size = 15;

	// Initialisation de la position (pour partir des bords de l'ardoise on utilise
	// une position négative)
	private int posX = -15;
	private int posY = -15;

	// Forme
	private String type = "ROND";

	// Constructeur
	public Point(int posX, int posY, int size, String type, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.color = color;
		this.type = type;

	}

	// Accesseurs
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
