import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Creation de l'échiquier
        final Echiquier echiquier = new Echiquier();
        // User
        final User user = new User("Joueur",true);
        Coordonnees org;
        Piece pieceToMove;

        // Jeux
        while (true /* Tant qu'il n'y a pas echec */) {
            printBoard(echiquier);
            if (user.white == true) {
                System.out.println("Joueur 1");
            } else {
                System.out.println("Joueur 2");
            }

            do {
                System.out.println("Entre les coordonnees de la piece d'origine");
                String coords = scan.next();
                String[] strings = coords.split(",");
                org = new Coordonnees(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
                pieceToMove = echiquier.getPiece(org);
                // Es-ce que je manipule la bonne piece
                if (user.isMyPiece(user, pieceToMove) == false) {
                    System.out.println("Ce n'est pas ta piece !");
                }
            } while (user.isMyPiece(user, pieceToMove) == false);

            System.out.println("Entre les coordonnees de la destination");
            String coords1 = scan.next();
            String[] strings1 = coords1.split(",");
            Coordonnees dest = new Coordonnees(Integer.parseInt(strings1[0]), Integer.parseInt(strings1[1]));

            echiquier.moveTo(org, dest,user);
        }

    }

    public static void printBoard(Echiquier echiquier) {
        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.println("     --------------------");
        for (int y = 0; y < 8; y++) {
            String row = y + " | ";
            for (int x = 0; x < 8; x++) {
                final Piece piece = echiquier.getPiece(new Coordonnees(x, y));
                // On rempli les cases
                String rep = (piece == null) ? "♢" : asString(piece);
                // La ligne de cases
                row = row + " " + rep;
            }
            // On affiche chaque ligne
            System.out.println(row);
        }

    }

    // Méthode qui donne une lettre pour chaque pièce
    private static String asString(Piece piece) {
        String p;
        Couleur c = piece.getCouleur();

        if (c == Couleur.BLANC) {
            if (piece instanceof Pion) {
                p = "♙";
            } else if (piece instanceof Tour) {
                p = "♖";
            } else if (piece instanceof Cavalier) {
                p = "♘";
            } else if (piece instanceof Fou) {
                p = "♗";
            } else if (piece instanceof Reine) {
                p = "♕";
            } else if (piece instanceof Roi) {
                p = "♔";
            } else {
                return null;
            }
        } else {
            if (piece instanceof Pion) {
                p = "♟";
            } else if (piece instanceof Tour) {
                p = "♜";
            } else if (piece instanceof Cavalier) {
                p = "♞";
            } else if (piece instanceof Fou) {
                p = "♝";
            } else if (piece instanceof Reine) {
                p = "♛";
            } else if (piece instanceof Roi) {
                p = "♚";
            } else {
                return null;
            }
        }

        return p;
    }
}