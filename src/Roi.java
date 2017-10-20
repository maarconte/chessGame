import java.util.List;
import java.util.ArrayList;

public class Roi extends Piece{
    public static Roi BLANC = new Roi(Couleur.BLANC);
	public static Roi NOIR = new Roi(Couleur.NOIR);

    public Roi(Couleur couleur){
        super(couleur);
    }

    @Override
	List<Coordonnees> movesValid(Coordonnees origin){
        final ArrayList<Coordonnees> result = new ArrayList<>();
        checkPosition(origin.getX() -1, origin.getY() -1, result);
        checkPosition(origin.getX() -1, origin.getY()   , result);
        checkPosition(origin.getX() -1, origin.getY() +1, result);
        checkPosition(origin.getX()   , origin.getY() -1, result);
        checkPosition(origin.getX()   , origin.getY() +1, result);
        checkPosition(origin.getX() +1, origin.getY() -1, result);
        checkPosition(origin.getX() +1, origin.getY()   , result);
        checkPosition(origin.getX() +1, origin.getY() -1, result);
		return result;
    }
}
