
package business.services;
/*
LoginService.java                       Author: Ufuk Lisan  ID: 21795394

It is LoginService class. It's purpose is login service.  
*/
import business.entity.User;
import dataAccess.abstracts.DataAccess;
import dataAccess.concretes.DataAccessFile;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.GameUi;

public class LoginService{
    
    public void login(String name,String password){
        User tempUser = new User();
        User user = new User(name,password);
        DataAccess dataAccess = new DataAccessFile();
        int a = dataAccess.read(user);
           
            if(a > 0){
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
