package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Tutorial extends BasicGameState {
	private Image glados;
	private Dialogs dialog;
	private long elapsedTime = 0L;
	public boolean chiamato = false;
	private Image[] images1;
	private Image[] images2;
	private int[] duration1;
	private int[] duration2;
	private Animation ani;
	private Animation ani2;
	private boolean uno = true;
	
	public void init(GameContainer container, StateBasedGame state) throws SlickException {
		images1 = new Image[] { new Image("images/Tutorial/1.png"), new Image("images/Tutorial/2.png"),
				new Image("images/Tutorial/3.png"), new Image("images/Tutorial/4.png"),
				new Image("images/Tutorial/5.png") };
		images2 = new Image[] { new Image("images/Tutorial/6.png"), new Image("images/Tutorial/8.png"),
				new Image("images/Tutorial/9.png"), new Image("images/Tutorial/10.png") };
		/*
		 * 10000, 1000000000 }; new Image("images/Tutorial/11.png"), new
		 * Image("images/Tutorial/12.png") Creo una animazione con frame aventi durate
		 * differenti (NB: non e' efficiente, si sarebbe potuto scrivere anche creando N
		 * BasicGameState ma ho evitato cio' introducendo dove necessario un lasso di
		 * tempo difficilmente realizzabile da un utente)
		 */
		duration1 = new int[] { 8000, 1000000000, 1000000000, 1000000000, 1000000000 };
		duration2 = new int[] { 5000, 1000000000, 1000000000, 1000000000 };
		ani = new Animation(images1, duration1);
		ani2 = new Animation(images2, duration2);
		dialog = new Dialogs();
		glados = new Image("images/Tutorial/glados.png");
	}

	@Override
	public void update(GameContainer container, StateBasedGame state, int delta) throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_LEFT) && ani.getFrame() == 1)
			ani.setCurrentFrame(2);
		if (container.getInput().isKeyPressed(Input.KEY_RIGHT) && ani.getFrame() == 2)
			ani.setCurrentFrame(3);
		if (container.getInput().isKeyPressed(Input.KEY_UP) && ani.getFrame() == 3)
			ani.setCurrentFrame(4);
		if (container.getInput().isKeyPressed(Input.KEY_SPACE) && ani.getFrame() == 4) {
			ani.stop();
			uno = false;
		}
		if (container.getInput().isKeyPressed(Input.KEY_D) && ani.getFrame() == 6)
			ani.setCurrentFrame(7);
		if (container.getInput().isKeyPressed(Input.KEY_A) && ani.getFrame() == 7)
			ani.setCurrentFrame(8);

	}

	@Override
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		glados.draw(0, 0, 0.6f);
		if (uno == true)
			ani.draw(400, -150);
		else
			ani2.draw(400, -150);

	}

	@Override
	public int getID() {
		return 2;
	}

}
