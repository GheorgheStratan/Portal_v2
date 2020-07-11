package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.lang.reflect.Field;

import sun.misc.*;

public class Main extends StateBasedGame{
	
	public Main(String name) {
		super(name);
	}

	/*Qui sotto aggiungiamo gli stati di quando incominciamo*/
	@Override
	public void initStatesList(GameContainer 
			container) throws SlickException {
		/*
		 * l'idea alla base di questo stato è questa:
		 * aggiungo questo stato al bottone new game con mode=0
		 * resume con mode 1
		 * speedrun con mode 2
		 * ora l'ho messo qui per fare delle semplici prove, per cui se non lo vuoi vedere commentalo
		 */
		this.addState(new Level("Maps/levels.txt", "Maps/Player.txt", 0, 0));
		this.addState(new SelectWindow());
		this.addState(new Tutorial());
	}
	public static void load()
	{
		 String fileNatives = OperatingSystem.getOSforLWJGLNatives();
		    System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + File.separator + "natives" + File.separator + fileNatives);
	}
	
	public static void disableWarning() {
	    try {
	        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
	        theUnsafe.setAccessible(true);
	        Unsafe u = (Unsafe) theUnsafe.get(null);
	        Class cls = Class.forName("jdk.internal.module.IllegalAccessLogger");
	        Field logger = cls.getDeclaredField("logger");
	        u.putObjectVolatile(cls, u.staticFieldOffset(logger), null);
	    } catch (Exception e) {
	        
	    }
	}
	public static void main(String[] args) throws SlickException {
		
		// da quel che ho capito questa soluzione resetta IllegalAccessLogger che è responsabile degli warnings, al momento lasciamola commentata. Non vorrei che copra qualche warning
		
		disableWarning();
		//load();
		AppGameContainer game = new AppGameContainer(new Main("Portal2D"));
		
		game.setDisplayMode(1024,800,false);
		game.setAlwaysRender(true);
		//game.setShowFPS(false);
		game.setTargetFrameRate(60);
		game.setMaximumLogicUpdateInterval(60);
		game.start();
	}
}
