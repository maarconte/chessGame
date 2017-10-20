import java.util.List;

public class Echiquier {
    // Création d'un tableau bidimentionel de 8x8
    public Piece echiquier[][] = new Piece[8][8];

    // Méthode constructeur
    public Echiquier() {
        init();
    }

    // Initialisation de l'échiquier
    public void init() {
        echiquier[0][0] = Tour.NOIR;
        echiquier[0][1] = Cavalier.NOIR;
        echiquier[0][2] = Fou.NOIR;
        echiquier[0][3] = Reine.NOIR;
        echiquier[0][4] = Roi.NOIR;
        echiquier[0][5] = Fou.NOIR;
        echiquier[0][6] = Cavalier.NOIR;
        echiquier[0][7] = Tour.NOIR;
        // Les cases vides
        for(int i = 2; i < 5; i++){
            for(int j =0; j < 8; j++){
                echiquier[i][j] = null;
            }
        }
        echiquier[7][0] = Tour.BLANC;
        echiquier[7][1] = Cavalier.BLANC;
        echiquier[7][2] = Fou.BLANC;
        echiquier[7][3] = Reine.BLANC;
        echiquier[7][4] = Roi.BLANC;
        echiquier[7][5] = Fou.BLANC;
        echiquier[7][6] = Cavalier.BLANC;
        echiquier[7][7] = Tour.BLANC;
        // Placer les pions
        for (int i = 0; i < 8; i++) {
            echiquier[1][i] = Pion.NOIR;
            echiquier[6][i] = Pion.BLANC;
        }
    }

    // Quelle type de piece est à cette position ?
    public Piece getPiece(Coordonnees coords) {
        return echiquier[coords.getY()][coords.getX()];
    }
    // Déplacer la pièce
    public boolean moveTo(Coordonnees origin, Coordonnees dest, User user) {
        final Piece pieceToMove = getPiece(origin);
        final Piece destination = getPiece(dest);
        
        // On ne peut pas déplacer une case vide
        if(pieceToMove == null){
        	System.out.println("On ne déplace pas une case vide !");
            return false;
        } if (destination != null && ((user.white == true && destination.getCouleur() == Couleur.BLANC) || (user.white == false && destination.getCouleur() == Couleur.NOIR))) {
        		System.out.println("On ne mange pas sa propre piece !");
        		return false;
        }
        
        // Les coups possibles de cette pièce
        List<Coordonnees> possibles = pieceToMove.movesValid(origin);
        //On parcours la liste de coups valide
        for (Coordonnees actual : possibles) {
            // Si la destination est egale à un coup possible
            if (actual.equals(dest)) {
            		if((user.white == true && pieceToMove.getCouleur() == Couleur.NOIR) || (user.white == false && pieceToMove.getCouleur() == Couleur.BLANC) ) {
            		break;	
            		}
                // Le deplacement est valide
                echiquier[dest.getY()][dest.getX()] = pieceToMove;
                echiquier[origin.getY()][origin.getX()] = null;
                // On change le joueur
                	user.white = !user.white;
                return true;
            }
        }
        return false;
    }
}
