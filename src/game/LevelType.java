package game;

public class LevelType {
	private Coordinate CoordinatePlayerinit;
	private String PathMappa;
	public LevelType(Coordinate CoordinatePlayerinit, String PathMappa) {
		this.CoordinatePlayerinit=CoordinatePlayerinit;
		this.PathMappa=PathMappa;
	}
	public Coordinate getCoordinatePlayerinit() {
		return CoordinatePlayerinit;
	}

	public String getPathMappa() {
		return PathMappa;
	}
	@Override
	public String toString() {
		return "LevelType [CoordinatePlayerinit=" + CoordinatePlayerinit + ", PathMappa=" + PathMappa + "]";
	}

	
}
