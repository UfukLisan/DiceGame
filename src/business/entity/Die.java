
package business.entity;
/*
Die.java                       Author: Ufuk Lisan  ID: 21795394

It is die class. Die will be an object. 
*/
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
