package gameobject;

import game.Punto;

import javax.swing.JLabel;

public class GameObject {
	protected JLabel imagen;

	protected GameObject(JLabel img) {
		imagen = img;
	}
	
	public Punto getCentroCoordenadas() {
		return new Punto( (imagen.getWidth()/2) + getX(), (imagen.getHeight()/2) + getY());
	}
	
	public int getCentroCoordenadasX() {
		return ((imagen.getWidth()/2) + getX());
	}
	
	public int getCentroCoordenadasY() {
		return ((imagen.getHeight()/2) + getY());
	}
	
	public int getX() {
		return imagen.getX();
	}
	
	public int getY() {
		return imagen.getY();
	}
	
	public int getWidth(){
		return imagen.getWidth();
	}
	
	public int getHeight(){
		return imagen.getHeight();
	}
	
	public Punto getLocation(){
		return new Punto(imagen.getLocation().x,imagen.getLocation().y);
	}
	
	public void setLocation(int x, int y){
		imagen.setLocation(x,y);
	}
	
	public JLabel getImagen() {
		return imagen;
	}
}