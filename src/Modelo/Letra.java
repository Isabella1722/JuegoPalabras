package Modelo;
import processing.core.PApplet;

public class Letra {

	char letra; 
	int posX;
	int posY;
	PApplet app;

	
	public Letra(char letra, PApplet app) {
		
		this.letra = letra;
		definirPosX();
		this.posY=30;
		this.app=app;
		
	}
	
	public void definirPosX() {
		int numero;
		numero = (int) (Math.random() * 550) + 30;
		this.posX = numero;
	}
	
	public void moverLetras(int step) {
		
	if (posY<=550) {
		posY+=1+step;
	}else {
		posY = 30;
	}
		
	}
	
	public void dibujar() {
		app.fill(0,100,100);
		app.ellipse(this.getPosX(), this.getPosY(), 40, 40);
		app.fill(255);
		app.textSize(30);
		app.text(this.getLetra(), this.getPosX(), this.getPosY());
	}
	
	public void esconder() {
		
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

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}
	
	

}
