
package ui;

import business.entity.User;
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
            JOptionPane.showMessageDialog(null,"You logged in. Thanks :) ");
            
            dispose();
            
            User ufuk = new User("ufuk","password");
            GameUi gameUi = new GameUi(ufuk);
            
            gameUi.setTitle("Dice Game");
            gameUi.setSize(500,100);
            gameUi.setVisible(true);
            gameUi.setResizable(false);
            gameUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    });

    }
    
             
            
           
    
}
