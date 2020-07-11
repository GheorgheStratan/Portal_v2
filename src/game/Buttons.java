package game;

import org.newdawn.slick.Image;

/*Classe che rappresenta un bottone della HomeScreen(Select Window)
 * Nota bene: NON è possibile modificare le immagini, NON è stato volutamente implementato il setter 
 * per le immagini*/
public class Buttons {
	private Image iniziale;
	private Image finale;
	private boolean stato;
	private int ID;
	
	/*Il Bottone di default ha come stato false, ovvero viene mostrata la immagine iniziale,
	 * inoltre in buttons viene immagazzinato l'ID dello stato in caso che venga cliccato*/
	public Buttons(Image iniziale, Image finale,int ID) {
		this.iniziale = iniziale;
		this.finale = finale;
		this.stato=false;
		this.ID=ID;
	}
	

	public int getID() {
		return ID;
	}
	
	public Image getIniziale() {
		return iniziale;
	}

	public Image getFinale() {
		return finale;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}
}
