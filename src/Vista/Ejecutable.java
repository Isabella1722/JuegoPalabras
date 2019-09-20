package Vista;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import Modelo.ListaPalabra;
import Modelo.Palabra;
import Modelo.Letra;
import processing.core.PApplet;

public class Ejecutable extends PApplet {
	ListaPalabra hola = new ListaPalabra(this);
	Palabra current = hola.getListaPalabra().get(0);
	char letra_correcta = '_';
	String success = "_____";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Ejecutable.class.getName());

	}

	public void setup() {

	}

	public void settings() {

		size(800, 600);
	}

	public void draw() {

		background(255, 255, 255);
		ArrayList<Letra> temporalLetras;
		try {
			ArrayList<Palabra> temporalPalabras = hola.getListaPalabra();
			for (int i = 0; i < temporalPalabras.size(); i++) {

				temporalLetras = temporalPalabras.get(i).getLetrasPalabra();

				for (int j = 0; j < temporalLetras.size(); j++) {
					Letra letraTemporal = temporalLetras.get(j);

					letraTemporal.dibujar();
					int step = (int) (Math.random() * 10);
					letraTemporal.moverLetras(step);
				}

				// Palabra palabraTemporal =;
				// palabraTemporal.mostrarPalabra();
			}
			

			fill(0);
			textSize(30);
			text(current.getPalabra(), 300, 550);
			fill(0);
			textSize(30);
			text("Letra correcta: " + letra_correcta, 190, 250);
			fill(0);
			textSize(30);
			text("última palabra completada: " + success, 190, 280);
			

		}

		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		} //

	}

	public void mouseMoved() {
		
		int i = 0;
		try {
		current = hola.getListaPalabra().get(i);
		
	
			
			for (int j = 0; j < hola.getListaPalabra().get(i).getLetrasPalabraAuxiliar().size(); j++) {
				
				Letra letraTemporal = hola.getListaPalabra().get(i).getLetrasPalabraAuxiliar().get(j);

				if  ((mouseX >= letraTemporal.getPosX() && mouseX <= letraTemporal.getPosX() + 40)
						&& (mouseY >= letraTemporal.getPosY() && mouseY <= letraTemporal.getPosY() + 40)) {
					System.out.println(hola.getListaPalabra().get(i).getLetrasPalabraAuxiliar().size());
					
					if (hola.validateWord(letraTemporal.getLetra())) {
						
						Palabra palabra = hola.getListaPalabra().get(i);
						palabra.getLetrasPalabraAuxiliar().remove(j);
						
						letra_correcta =  letraTemporal.getLetra();
						
						if (hola.emptyArrayWords(i)) {
							success =  hola.getListaPalabra().get(i).getPalabra();
							hola.getListaPalabra().remove(i);
						}
					}
				}
			}
			
		}catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			textSize(20);
			text("Ya finalizó",250,150);
		}

	}

}
