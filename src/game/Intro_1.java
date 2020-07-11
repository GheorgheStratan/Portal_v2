package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*In Intro vi e' il menu' iniziale. Quando si accedende il gioco si accede a questo menu' 
 * e solo premento 'Barra spaziatrice' si entra nel menu' di scelta delle Opzioni: Nuova Partita,Carica Partita,SpeedRun,Opzioni,Credits*/
public class Intro_1 extends BasicGameState {
	private SpriteSheet logo;
	private Animation logoAnimation;

	@Override
	public void init(GameContainer arg0, StateBasedGame state) throws SlickException {
		logo = new SpriteSheet("images/Intro/LogoGioco.png", 720, 360);
		logoAnimation = new Animation(logo, 40);
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			state.enterState(1);
		}
		
		logoAnimation.update(delta);
	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		logoAnimation.stopAt(209);
		logoAnimation.draw(180, 180);
		if (logoAnimation.getFrame() > 208)
			g.drawString("Press SPACE to continue", 760, 760);
	}

	@Override
	public int getID() {

		return 3;
	}
}