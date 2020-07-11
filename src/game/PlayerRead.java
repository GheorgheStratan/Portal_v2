package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Al momento legge l'ultimo livello sbloccato
public class PlayerRead {
	private int level;
	public PlayerRead(String fileName) {
		   Scanner sc = null;
		   Scanner s2;
		    try {
		        sc = new Scanner(new File("Maps/Player.txt"));
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();  
		    }
		    while (sc.hasNextLine()) {
		            s2 = new Scanner(sc.nextLine());
		        if (s2.hasNext()) {
		            String s = s2.next();
		            level=Integer.parseInt(s);
		        }
		    }
	}
	public int getLevel() {
		return level;
	}
}
