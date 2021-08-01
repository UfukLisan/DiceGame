
package ui;

import business.entity.User;
import business.services.RegistrationService;
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

public class RegistrationUi extends JFrame{
    
    private JLabel nameLabel,passwordLabel,orLabel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton signUpBtn,orLoginButton;
    private Container container;
    public RegistrationUi() {

    nameLabel = new JLabel("User Name");
    passwordLabel = new JLabel("Password");
    orLabel = new JLabel("You can register or log in if you are already registered.");
    
    nameField = new JTextField(20);
    passwordField = new JPasswordField(10);
  
    signUpBtn = new JButton("Sign up");
    orLoginButton = new JButton("Or Log in");
    
    signUpBtn.setPreferredSize(new Dimension(200,30));
    orLoginButton.setPreferredSize(new Dimension(200,30));
    
    container=getContentPane();
    container.setLayout(new FlowLayout());
    
    passwordField.setEchoChar('*');
    
    container.add(nameLabel);
    container.add(nameField);
    container.add(passwordLabel);
    container.add(passwordField);
    container.add(signUpBtn);  
    container.add(orLabel);
    container.add(orLoginButton);
    
    signUpBtn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
         if(e.getSource()==signUpBtn){
             RegistrationService service = new RegistrationService();
             service.registration(nameField.getText(), passwordField.getText());
            }  
        }
    });
        orLoginButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         if(e.getSource()==orLoginButton){
            dispose();
            LoginUi loginUi = new LoginUi();
            loginUi.setTitle("Login Dice Game");
            loginUi.setSize(500,100);
            loginUi.setVisible(true);
            loginUi.setResizable(false);
            loginUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }  
        }
    });
    
    }
 
}
