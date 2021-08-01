
package business.services;

import business.entity.User;
import dataAccess.abstracts.DataAccess;
import dataAccess.concretes.DataAccessFile;
import javax.swing.JOptionPane;

public class RegistrationService {
    
    public void registration(String name,String password){
        if(name != null && password != null){
             User newUser = new User(name,password);
             DataAccess dataAccess = new DataAccessFile();
             dataAccess.write(newUser);
             JOptionPane.showMessageDialog(null,"You signed up. Thanks :) ");
             }
             else {
             JOptionPane.showMessageDialog(null,"You are not signed up. Your name or password are not null. Please check!");    
             } 
    }
    
    
}
