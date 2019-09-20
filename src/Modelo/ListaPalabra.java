package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import processing.core.PApplet;

public class ListaPalabra {
	
ArrayList<Palabra> listaPalabra;

PApplet app;

public ListaPalabra(PApplet app) {
	listaPalabra = new ArrayList<Palabra>();
	this.app = app;
	cargarPalabra();
}

public void cargarPalabra() {
	try {
		
		FileReader archivo = new FileReader(".\\src\\Modelo\\words.txt");
		String cadena;
		BufferedReader b = new BufferedReader(archivo);
	      while((cadena = b.readLine())!=null) {
	    	  Palabra nueva = new Palabra(cadena, this.app);
	    	  this.listaPalabra.add(nueva);
	      }
	      b.close();
	} catch (IOException e) {
		System.out.println("No encontré archivo");
	}	
}

public ArrayList<Palabra> getListaPalabra() {
	return listaPalabra;
}

public boolean validateWord(char word) {
	boolean result = false; 
	int i = 0;
	for (int k = 0; k < listaPalabra.get(i).getLetrasPalabra().size(); k++) {
		if(listaPalabra.get(i).getLetrasPalabra().get(k).getLetra() == word) {
			result = true;
			return result;
		}
	}
		
	
	return result;
}

public boolean emptyArrayWords(int i) {
	boolean result = false; 

	if(listaPalabra.get(i).getLetrasPalabraAuxiliar().isEmpty()) {
		result = true;
	}
	
	return result;
}

public void setListaPalabra(ArrayList<Palabra> listaPalabra) {
	this.listaPalabra = listaPalabra;
}
}

