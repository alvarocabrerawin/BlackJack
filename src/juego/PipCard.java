package juego;


public class PipCard extends Card{
    
    Integer value; // valor
    
    public PipCard(Integer value){
        super();
        this.value=value;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
    

