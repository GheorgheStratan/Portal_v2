package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class LevelRead {
	private ArrayList<LevelType> livelli;
	private Coordinate coor;
	private Integer x, y;
	private String Nomemappa, str="", l="";
	private String s[];
	private Boolean firstline;
	private int dim;
	public String toString() {
		return "Level [s=" + Arrays.toString(s) + "]";
	}
	public LevelRead(String fileName) {
		//Lettura dei dati di tutti i livelli
		//WARNINING: da implementare una finiestra d'errore in caso di assenza del file a causa di eliminazioni ecc: Uscita dal gioco
		FileReader fr;
		BufferedReader br;
		livelli=new ArrayList<LevelType>();
		dim=0;
		Coordinate coor;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while((l=br.readLine())!=null) { 
			    str += " " + l;
			}
			br.close();	
			String[] array = str.trim().split(",");
			firstline=false;
			for(int i=0; i<array.length; ++i) {
					if(firstline==false && i==0) {
						firstline=true;
						Nomemappa=array[i];
					}
					if(firstline==true && i!=0) {
						Nomemappa=array[i].substring(1);
					}
					x=Integer.parseInt(array[++i]);
					y=Integer.parseInt(array[++i]);
					coor=new Coordinate(x, y);
					dim++;
					livelli.add(new LevelType(coor, Nomemappa));
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getDim() {
		return dim;
	}
	public LevelType getLevel(int index) {
		return livelli.get(index); 
	}
	public int size(){
		return getDim();
	}
	public Coordinate getCoor() {
		return coor;
	}
}
