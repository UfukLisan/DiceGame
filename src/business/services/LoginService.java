
package business.services;

import business.entity.User;
import dataAccess.abstracts.DataAccess;
import dataAccess.concretes.DataAccessFile;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.GameUi;
import ui.LoginUi;


public class LoginService{
    
    public void login(String name,String password){
        User tempUser = new User();
        User user = new User(name,password);
        DataAccess dataAccess = new DataAccessFile();
        tempUser = dataAccess.read(user);
           
            if(tempUser.getName()!= null){
               JOptionPane.showMessageDialog(null,"You logged in. Thanks :) ");
  
               GameUi gameUi = new GameUi(tempUser);
               gameUi.setTitle("Dice Game");
               gameUi.setSize(500,100);
               gameUi.setVisible(true);
               gameUi.setResizable(false);
               gameUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               }
               else {
                JOptionPane.showMessageDialog(null,"You are not logged in. Repeat Again :( ");   
               }
    }
    
    
}
