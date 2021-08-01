
package dicegame;

import javax.swing.JFrame;
import ui.RegistrationUi;
import business.entity.Die;

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
