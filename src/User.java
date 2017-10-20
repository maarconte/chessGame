public class User {
    public boolean white;
    private String name;

    public User(String name, boolean white){
        this.name = name;
        this.white = white;
    }

    public String getName(){
        return this.name;
    }
    
    public boolean isMyPiece(User user, Piece piece) {
    		return ((user.white == true && piece.getCouleur() == Couleur.BLANC )||(user.white == false && piece.getCouleur() == Couleur.NOIR));   
    }
}