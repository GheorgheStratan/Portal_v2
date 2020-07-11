package game;


import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Level extends BasicGameState{
	private String fileNameMap, fileNamePlayer;
	private LevelRead ListLevel;
	private PlayerRead pr;
	private TiledMap map;
	private Player player;
	Random random;
	int x, y;
	protected int shiftX = 0, shiftY = 0;
	private int levelInput;//rappresenta il level scelto dall'utente tra quelli sbloccati da lui
	private int mode;//0 - new game, 1 - resume, 2 - speedrun
	public Level(String fileNameMap,  String fileNamePlayer, int mode, int levelInput)   {
		this.fileNameMap=fileNameMap;
		this.fileNamePlayer=fileNamePlayer;
		this.mode=mode;
		this.levelInput=levelInput;
	}
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		ListLevel=new LevelRead(this.fileNameMap);
		LevelType CurrentLevel=ListLevel.getLevel(0);
		pr=new PlayerRead(this.fileNamePlayer);
		//al momento per lo speedrun in maniera random prendo una mappa tra quelle presenti, in seguito farò delle mappe apposite
		switch(this.mode){
		case 0: map=new TiledMap(ListLevel.getLevel(0).getPathMappa()); break;
		case 1: map=new TiledMap(ListLevel.getLevel(1).getPathMappa()); break;
		case 2:{
			random = new Random(ListLevel.size());
			int rand = random.nextInt();
			map=new TiledMap(ListLevel.getLevel(rand).getPathMappa());
			break;
		}
		}
		player=new Player(2, 700);
	}


	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		map.render(0, 0);
		player.render(container, state, g);
		
		
		

	}


	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		
			int objectlayer=map.getLayerIndex("Borders");
	
			player.update(container, state, delta, objectlayer, map);
			
	
	}


	public int getID() {

		return 0;
	}

}
