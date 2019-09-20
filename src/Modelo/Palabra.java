package Modelo;

import java.util.ArrayList;
import processing.core.PApplet;

public class Palabra {
	
	ArrayList <Letra> letrasPalabra; 
	ArrayList <Letra> letrasPalabraAuxiliar; 
	String palabra;
	PApplet app; 
	
	public ArrayList <Letra> getLetrasPalabra() {
		return letrasPalabra;
	}


	public void setLetrasPalabra(ArrayList <Letra> letrasPalabra) {
		this.letrasPalabra = letrasPalabra;
	}


	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public Palabra(String palabra, PApplet app) {
		this.letrasPalabra = new ArrayList();
		this.palabra = palabra;
		this.app = app;
		extraeLetras(this.palabra);
		this.letrasPalabraAuxiliar = letrasPalabra; 
		//mostrarPalabra(this.palabra);
	}
	
	public ArrayList<Letra> getLetrasPalabraAuxiliar() {
		return letrasPalabraAuxiliar;
	}


	public void setLetrasPalabraAuxiliar(ArrayList<Letra> letrasPalabraAuxiliar) {
		this.letrasPalabraAuxiliar = letrasPalabraAuxiliar;
	}


	public void extraeLetras(String palabra) {
		
		for (int i = 0; i < palabra.length(); i++) {
			Letra  nueva = new Letra(palabra.charAt(i), this.app);
			letrasPalabra.add(nueva);
		}
	}
public void mostrarPalabra() {
		
		for (int i = 0; i < palabra.length(); i++) {
			
		System.out.println(letrasPalabra.get(0));
		}
	}
	
}
