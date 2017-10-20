import java.util.List;
import java.util.ArrayList;

public class Pion extends Piece{
	public static Pion BLANC = new Pion(Couleur.BLANC);
	public static Pion NOIR = new Pion(Couleur.NOIR);
	
	public Pion(Couleur couleur) {
		super(couleur);
	}
	
	@Override
	public List<Coordonnees> movesValid(Coordonnees origin){
		final ArrayList<Coordonnees> result = new ArrayList<>();
		int lastY= 0;
		int direction = 0;

		if(getCouleur() == Couleur.BLANC){
			lastY = 0;
			direction = -1;
		} else if (getCouleur() == Couleur.NOIR) {
			lastY = 7;
			direction = 1;
		}
		
		if(origin.getY() != lastY) {
			result.add(new Coordonnees(origin.getX(),origin.getY() + direction));
		}
		return result;
	}
}
