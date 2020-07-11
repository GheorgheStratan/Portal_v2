package game;



import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Player{
	private static final float  JUMP_VELOCITY = 0.008f,GRAVITY_CHANGE = 0.00001f, GRAVITY = -0.1f;
	public final float SQRT2 = (float) Math.sqrt(2);
	private float  dx ,dy;
	protected float xAcceleration;
	protected float yAcceleration;
	protected int x, y;
	protected float xmov = 0, ymov = 0;
	private SpriteSheet player;
	private Animation playerAnimation;
	public Player(int x, int y) throws SlickException  {
		this.x=x;
		this.y=y;
		player=new SpriteSheet("Maps/player.png", 80, 90);
		playerAnimation=new Animation(player, 1200);
	}
	public void render(GameContainer container, StateBasedGame state, Graphics g) throws SlickException {
		playerAnimation.stopAt(2);
		
		playerAnimation.draw(x, y);
		
	}
	public void update(GameContainer container, StateBasedGame state, int delta, int objectlayer, TiledMap map) throws SlickException {
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_D)){
			xmov += delta;
			//System.out.println(xmov);
		}
		if(input.isKeyDown(Input.KEY_A)){
			xmov -= delta;
		}	
		
		if (input.isKeyDown(Input.KEY_SPACE)){
			ymov -= delta;
			dy = JUMP_VELOCITY;
		}
		else if (dy > GRAVITY) dy -= delta * GRAVITY_CHANGE;
		xAcceleration = xmov * (xmov * ymov == 0 ? SQRT2 : 1) * 0.1f;
		yAcceleration = ymov * (xmov * ymov == 0 ? SQRT2 : 1) * 0.1f;
		
		int xx=(int) (x+xAcceleration);
		int yy= (int) (y+yAcceleration);
		map.getTileId(0, 0, objectlayer);
		//System.out.println(map.getTileId(x, yy, objectlayer));
		//if(map.getTileId(xx, yy, objectlayer)!=3) {
		
		//System.out.println(y+yAcceleration);
		
			x += xAcceleration;
			y += yAcceleration;
		
		//}
		xAcceleration=0; yAcceleration=0;
		xmov=0; ymov=0;
		playerAnimation.update(delta);
		
	}
	
	
	
	
}
