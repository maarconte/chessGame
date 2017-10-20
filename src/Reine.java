import java.util.ArrayList;
import java.util.List;

public class Reine extends Piece {
    public static Reine BLANC = new Reine(Couleur.BLANC);
    public static Reine NOIR = new Reine(Couleur.NOIR);

    public Reine(Couleur couleur) {
        super(couleur);
    }

    @Override
    List<Coordonnees> movesValid(Coordonnees origin) {
        final ArrayList<Coordonnees> result = new ArrayList<>();

        for (int i = 0; i < 8; i++) // Boucle des déplacement du fou //
        {
            // On ne verifie pas la case d'origin
            if (i != origin.getX()) {
                int delta = i - origin.getX();

                if (isInside(i, origin.getY() + delta)) {
                    checkPosition(i, origin.getY() + delta, result);
                }
                if (isInside(i, origin.getY() - delta))

                {
                    checkPosition(i, origin.getY() - delta, result);
                }
            }
        }

        for (int i = 0; i < 8; i++) // Boucle des déplacement de la Tour //
        {
            if (i != origin.getY())

            {
                result.add(new Coordonnees(origin.getX(), i));
            }

            if (i != origin.getX())

            {
                result.add(new Coordonnees(i, origin.getY()));
            }
        }
        return result;
    }
}