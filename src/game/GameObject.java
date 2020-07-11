package game;


public abstract class GameObject {
	
	protected ID id;
	protected int x,y;
	protected int SpeedX,SpeedY;

	public GameObject(int x, int y) {
		//this.id = id;
		this.x = x;
		this.y = y;
	}

	/*Aggiungo i getter e i setter*/
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedX() {
		return SpeedX;
	}

	public int setSpeedX(int speedX) {
		return SpeedX = speedX;
	}

	public int getSpeedY() {
		return SpeedY;
	}

	public int setSpeedY(int speedY) {
		return SpeedY = speedY;
	}
}
