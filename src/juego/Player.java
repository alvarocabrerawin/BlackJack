package juego;

import java.util.List;


public class Player {
 

    List<Card> apuesta; // lista apuesta

    
    public Player (List<Card> apuesta){
        this.apuesta = apuesta;
    }

    public List<Card> getApuesta(){
        return this.apuesta;
    }

    
    public void addApuesta(Card nueva){
        this.apuesta.add(nueva); // añade nueva
    }

    public boolean Winner(Player Crupier, BlackJack blackJack) {
        
        // declaramos apuesta crupier y apuesta player
        
        int ApuestaCrupier = blackJack.sumaApuesta(Crupier.getApuesta());
        int ApuestaPlayer = blackJack.sumaApuesta(this.apuesta);
        
        if(ApuestaCrupier > blackJack.getMaxSum() || blackJack.isBlackJack(this.getApuesta())){
            return true; // devolvera verdadero
        }

        if(ApuestaPlayer > blackJack.getMaxSum() || blackJack.isBlackJack(Crupier.getApuesta())){
            return false; // devolvera falso
        }
        
        

        return ApuestaPlayer > ApuestaCrupier;
    }
}
