package game;

import java.util.ArrayList;
import java.util.List;

/*Questa classe serve per rendere l'update di SelectWindow più "Automatico"*/
public class ListaBottoni {
	List<Buttons> bottoni;
	List<Coordinate> coordinate;	/*Le coordinate indicano il punto in altro a sinistra di una immagine (NOSTRA CONVENZIONE)*/
	
	/*Si decide che la Lista di Bottoni parte sempre da vuota e si introducono man mano i vari componenti*/
	public ListaBottoni() {
		bottoni=new ArrayList<Buttons>();
		coordinate= new ArrayList<Coordinate>();
	}

	
	public void addElement(Buttons bottone,Coordinate coord) {
		bottoni.add(bottone);
		coordinate.add(coord);
	}
	
	
	public void removeElement(int index) {
		bottoni.remove(index);
		coordinate.remove(index);
	}
}
