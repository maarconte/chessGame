import java.util.List;
import java.util.ArrayList;

public class Tour extends Piece{
    public static Tour BLANC = new Tour(Couleur.BLANC);
	public static Tour NOIR = new Tour(Couleur.NOIR);

    public Tour(Couleur couleur){
        super(couleur);
    }

    @Override
	List<Coordonnees> movesValid(Coordonnees origin){
        final ArrayList<Coordonnees> result = new ArrayList<>();
        
        for(int i = 0; i < 8; i++) {
            if(i != origin.getY()){
                result.add(new Coordonnees(origin.getX(), i));
            }
            if(i != origin.getX()){
                result.add(new Coordonnees(i, origin.getY()));
            }
        }
		return result;
	}
}
