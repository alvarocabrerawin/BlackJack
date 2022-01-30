
package juego;

import java.util.ArrayList;
import java.util.List;
import juego.Ace;


public class BlackJack {
 private final Integer puntosMaximo;
 
 
    private final Integer CrupierMinimo;

    
    public BlackJack(){
        this.puntosMaximo=21; // si excede de 21 puntos pierde
        this.CrupierMinimo=17; // segun enunciado tenga 17 o mas
    }
    
    // cinco Parametros
    public List<Player> getWinners(Player p1, Player p2, Player p3, Player crupier, List<Card> deck){

        List<Player> lista = new ArrayList<Player>();

        while (this.sumaApuesta(crupier.getApuesta()) <= this.CrupierMinimo){
            Card nextFromDeck = deck.get(0);
            crupier.addApuesta(nextFromDeck);
            deck.remove(nextFromDeck);
        }

        if(!this.isBlackJack(crupier.getApuesta())){
            if(p1.Winner(crupier, this)){
                lista.add(p1);
            }
            if(p2.Winner(crupier, this)){
                lista.add(p2);
            }
            if(p3.Winner(crupier, this)){
                lista.add(p3);
            }
        }
        return lista;
    }

    public boolean isBlackJack(List<Card> apuesta){
        return sumaApuesta(apuesta)==this.getMaxSum() && apuesta.size()==2;
    }


    public int sumaApuesta(List<Card> apuesta){

        int suma=0;
        int numeroAce=0;
        int resta_Betw_Ace=0; // resta entre valor Ace

        for(Card i : apuesta){
            suma += i.getValue();
            if(i instanceof Ace) {
                numeroAce++; // se incrementa
                resta_Betw_Ace = i.getValue() - ((Ace) i).getOther();
            }
        }

        while((suma > this.puntosMaximo) && (numeroAce > 0)){
            suma -= resta_Betw_Ace;
            numeroAce--; // se decrementa
        }
        return suma;
    }

    public Integer getMaxSum(){
        return this.puntosMaximo;
    }

}
    


