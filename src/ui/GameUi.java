
package ui;

import business.entity.Die;
import business.entity.User;
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
import javax.swing.JTextField;

public class GameUi extends JFrame{
        
    private JLabel dice1Label,dice2Label,sumLabel;
    private JTextField dice1ResultField,dice2ResultField,sumResultField;
    private JButton rollButton;
    private Container container;
    private User user;
    private DataAccess dataAccess;
    
    public GameUi(User user){
        this.user = user;
        
        dataAccess = new DataAccessFile(); //polymorphism. Maybe you don't use files. You want to use a database. 
        
        dice1Label = new JLabel("Dice 1:");
        dice2Label = new JLabel("Dice 2:");
        sumLabel = new JLabel("Result:");
        
        dice1ResultField = new JTextField(1);
        dice2ResultField = new JTextField(1);
        sumResultField = new JTextField(2);
        dice1ResultField.setEditable(false);
        dice2ResultField.setEditable(false);
        sumResultField.setEditable(false);
        
        rollButton = new JButton("Roll the Dice");
        rollButton.setPreferredSize(new Dimension(200, 40));
        
        container = getContentPane();
        container.setLayout(new FlowLayout());
        
        container.add(dice1Label);
        container.add(dice1ResultField);
        container.add(dice2Label);
        container.add(dice2ResultField);
        container.add(rollButton);
        container.add(sumLabel);
        container.add(sumResultField);
        
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==rollButton){
                    int sum;
                                       
                    Die dice1 = new Die();
                    Die dice2 = new Die();
 
                    sum = dice1.getDice()+dice2.getDice();  

                    dice1ResultField.setText(""+dice1.getDice());
                    dice2ResultField.setText(""+dice2.getDice());
                    sumResultField.setText(""+sum);
                    
                    if(sum == 7 ){
                        user.setPoint(5); 
                        dataAccess.update(user, 5);
                        JOptionPane.showMessageDialog(null,"CONGRATULATIONS! " + user.getName() + " YOU WON!!!\n" + "Your last point: " + user.getPoint());        
                    }
                    else {
                        user.setPoint(-3); 
                        dataAccess.update(user, -3);
                        JOptionPane.showMessageDialog(null,"YOU Lose!\n"+ user.getName() + " Your last point: "+user.getPoint());
                    }
                }
            }
        });
    
    }
}
