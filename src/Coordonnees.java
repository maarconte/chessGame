
public class Coordonnees {
	private final int x;
	private final int y;
	
	public Coordonnees(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object object){
		if(object instanceof Coordonnees){
			final Coordonnees coords = (Coordonnees) object;
			return this.x == coords.x && this.y == coords.y;
		} else {
			return false;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
