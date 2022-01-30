package juego;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

// Test
public class BlackJackTest {
    
   // Empezamos test
    
    @Test
    public void con_j_ace(){
        List<Card> apuesta = new ArrayList<>();
        
        // en la lista apuesta añdiremos
        
        apuesta.add(new CardValue10());
       apuesta.add(new Ace());

        assert(new BlackJack().isBlackJack(apuesta));
    }

    @Test
    public void PipCard_Ace(){
        List<Card> apuesta = new ArrayList<>();
        
        // en la lista apuesta añadiremos
        
        apuesta.add(new PipCard(5));
        apuesta.add(new Ace());

        assert(!new BlackJack().isBlackJack(apuesta));
    }

    // caso 1
    
    @Test
    public void p1(){ // getWinners(...) -----> [Player1]
        
        // creando ArrayList
        
        List<Card> apuestaP1 = new ArrayList<>();
        List<Card> apuestaP2 = new ArrayList<>();
        List<Card> apuestaP3 = new ArrayList<>();
        List<Card> apuestaCrupier = new ArrayList<>();

         // en la apuesta de cada participante 
        apuestaP1.add(new CardValue10());
        apuestaP1.add(new Ace());

        apuestaP2.add(new PipCard(10));
        apuestaP2.add(new PipCard(5));
        apuestaP2.add(new PipCard(6));

        apuestaP3.add(new PipCard(3));
        apuestaP3.add(new PipCard(6));
        apuestaP3.add(new Ace());
        apuestaP3.add(new PipCard(3));
        apuestaP3.add(new Ace());
        apuestaP3.add(new CardValue10());

         // apuesta crupier
         
        apuestaCrupier.add(new PipCard(9));
        apuestaCrupier.add(new PipCard(7));

        // apuesta cada jugador
        
        Player p1 = new Player(apuestaP1);
        Player p2 = new Player(apuestaP2);
        Player p3 = new Player(apuestaP3);
        
        // apuesta crupier
 
        Player crupier = new Player(apuestaCrupier);

        List<Player> Ganador = new ArrayList<>();
       Ganador.add(p1); // añade
       
        //crea ArrayList
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new CardValue10());
        deck.add(new PipCard(2));

        BlackJack blackJack = new BlackJack();

        // lista de ganadores
        
        List<Player> listaGanador = blackJack.getWinners(p1,p2,p3,crupier,deck);

        assert(listaGanador.equals(Ganador));

    }

    // caso 2
    
    @Test
    public void p1_p3(){ // getWinners(...) -----> [Player1, Player3]
        
        
        // Creando ArrayList
        
        List<Card> apuestaP1 = new ArrayList<>();
        List<Card> apuestaP2= new ArrayList<>();
        List<Card> apuestaP3= new ArrayList<>();
        List<Card> apuestaCrupier = new ArrayList<>();

        // en la apuesta de cada pariticipante
        
        
        // jugador1
        apuestaP1.add(new PipCard(10));
        apuestaP1.add(new CardValue10());
        
        // jugador 2
        apuestaP2.add(new PipCard(10));
        apuestaP2.add(new PipCard(2));
        apuestaP2.add(new PipCard(6));
        
        //jugador 3
        apuestaP3.add(new PipCard(8));
        apuestaP3.add(new PipCard(8));
        apuestaP3.add(new PipCard(5));

        // En la apuesta Crupier
        
        apuestaCrupier.add(new PipCard(5));
        apuestaCrupier.add(new PipCard(10));
        
        // Cada jugador
        
        Player p1 = new Player(apuestaP1);
        Player p2 = new Player(apuestaP2);
        Player p3 = new Player(apuestaP3);

        // corresponde al crupier
        
        Player crupier = new Player(apuestaCrupier);

        List<Player>Ganador = new ArrayList<>();
        Ganador.add(p1); // añadimos
        Ganador.add(p3); // añadimos

        List<Card> deck = new ArrayList<>();  
        
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new CardValue10());
        deck.add(new PipCard(2));

        //blackjack 
        BlackJack blackJack = new BlackJack();
        
        // recoge Ganadores
        List<Player> listaGanador = blackJack.getWinners(p1,p2,p3,crupier,deck);

        assert(listaGanador.equals(Ganador));

    }

    

}