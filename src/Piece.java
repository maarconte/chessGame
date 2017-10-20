import java.util.List;

enum Couleur {
	NOIR, BLANC
};

public abstract class Piece {
	private final Couleur couleur;

	protected Piece(Couleur couleur) {
		this.couleur = couleur;
	}

	// Verifier si les coordonées sont dans l'échiquier
	protected boolean isInside(int x, int y) {
		return ((x >= 0 && x < 8) && (y >= 0 && y < 8));
	}

	protected void checkPosition(int x, int y, List<Coordonnees> result) {
		Coordonnees coords = new Coordonnees(x,y);
		if (isInside(x, y)) {
			result.add(coords);
		}
	}

	// Nombre de coups possibles
	abstract List<Coordonnees> movesValid(Coordonnees origin);

	protected Couleur getCouleur() {
		return couleur;
	}
}
