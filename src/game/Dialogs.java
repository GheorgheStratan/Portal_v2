package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Image;

public class Dialogs {
	private List<Image> dialog;
	private List<Boolean> state;

	public Dialogs() {
		dialog = new ArrayList<Image>();
		state = new ArrayList<Boolean>();
	}

	public void addElement(Image dialogo,Boolean stato) {
		dialog.add(dialogo);
		state.add(stato);
	}

	public void remove(int index) {
		dialog.remove(index);
		state.remove(index);
	}
	
	public Image getImage(int index) {
		return dialog.get(index);
	}

	public Boolean getState(int i) {
		return state.get(i);
	}

	public void setState(int index, boolean stato) {
		state.add(index, stato);
	}
	
	public int size() {
		return dialog.size();
	}
}
