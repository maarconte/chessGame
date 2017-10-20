import java.util.List;
import java.util.ArrayList;

public class Fou extends Piece {
    public static Fou BLANC = new Fou(Couleur.BLANC);
    public static Fou NOIR = new Fou(Couleur.NOIR);

    public Fou(Couleur couleur) {
        super(couleur);
    }

    @Override
    List<Coordonnees> movesValid(Coordonnees origin) {
        final ArrayList<Coordonnees> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            // On ne verifie pas la case d'origine
            if (i != origin.getX()) {
                // Calcule de la diagonale
                int delta = i - origin.getX();
                // Si les coordonnées testées sont dans l'échiquier
                if (isInside(i, origin.getY() + delta)) {
                    checkPosition(i, origin.getY() + delta, result);
                } 
                if (isInside(i, origin.getY() - delta)) {
                    checkPosition(i, origin.getY() - delta, result);
                }
            }
        }
        return result;
    }
}
