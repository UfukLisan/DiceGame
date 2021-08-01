
package business.entity;


public class Die {
    
    private int dice;

    public Die() {
        this.dice = 1 + (int)(6 * Math.random());
    }
    public int getDice(){
        return this.dice;
    }
    public String toString(){
        return "Dice: "+this.dice;
    }
            
    
}
