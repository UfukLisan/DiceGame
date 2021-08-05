
package dicegame;
/*
DiceGame.java                       Author: Ufuk Lisan  ID: 21795394

It is main class. Program starts here.
*/

import javax.swing.JFrame;
import ui.RegistrationUi;

public class DiceGame {

    public static void main(String[] args) {
      
    RegistrationUi gui = new RegistrationUi();
    
    gui.setTitle("Sign up Dice Game");
    gui.setSize(500,160);
    gui.setVisible(true);
    gui.setResizable(false);
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}
