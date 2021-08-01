
package ui;

import business.entity.User;
import business.services.LoginService;
import dataAccess.abstracts.DataAccess;
import dataAccess.concretes.DataAccessFile;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUi extends JFrame{
   
    private JLabel nameLabel,passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private Container container;
    
    public LoginUi() {
    nameLabel = new JLabel("User Name");
    passwordLabel = new JLabel("Password");
  
    nameField = new JTextField(20);
    passwordField = new JPasswordField(10);
  
    loginBtn = new JButton("Log in");
    
    loginBtn.setPreferredSize(new Dimension(200,30));
    
    container = getContentPane();
    container.setLayout(new FlowLayout());
    
    passwordField.setEchoChar('*');
    container.add(nameLabel);
    container.add(nameField);
    container.add(passwordLabel);
    container.add(passwordField);
    container.add(loginBtn);
    
        
        loginBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==loginBtn){
             LoginService service = new LoginService();
             service.login(nameField.getText(), passwordField.getText());
             dispose();
            }
        }
    });

    }
    
             
            
           
    
}
