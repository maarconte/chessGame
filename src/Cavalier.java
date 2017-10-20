import java.util.ArrayList;
import java.util.List;

public class Cavalier extends Piece{
    public static Cavalier BLANC = new Cavalier(Couleur.BLANC);
	public static Cavalier NOIR = new Cavalier(Couleur.NOIR);

    public Cavalier(Couleur couleur){
        super(couleur);
    }
    
    @Override
	List<Coordonnees> movesValid(Coordonnees origin){
        final ArrayList<Coordonnees> result = new ArrayList<>();
        
        checkPosition(origin.getX() + 2, origin.getY() - 1, result);
		checkPosition(origin.getX() + 2, origin.getY() + 1, result);
		checkPosition(origin.getX() - 2, origin.getY() - 1, result);
		checkPosition(origin.getX() - 2, origin.getY() + 1, result);
		checkPosition(origin.getX() + 1, origin.getY() + 1, result);
		checkPosition(origin.getX() - 1, origin.getY() - 2, result);
		checkPosition(origin.getX() + 1, origin.getY() - 2, result);
		checkPosition(origin.getX() + 1, origin.getY() + 2, result);

		return result;
    }
}