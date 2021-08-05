package dataAccess.concretes;
/*
DataAccessFile.java                       Author: Ufuk Lisan  ID: 21795394

It is DataAccessFile class. It's purpose is doing file operations.  
*/
import business.entity.User;
import dataAccess.abstracts.DataAccess;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class DataAccessFile implements DataAccess{
    private String userNameInput ;
    private String passwordInput ;

    @Override
    public void write(User user) {
       if(!user.getName().isEmpty() && !(user.getPassword().isEmpty())) {
                    try(FileWriter fWriter = new FileWriter("player.txt", true);
                            BufferedWriter bWriter = new BufferedWriter(fWriter);
                            PrintWriter out = new PrintWriter(bWriter))
                        {
                        String passwordInput = new String(user.getPassword());
                            out.println(user.getName()+"_"+passwordInput+"_"+user.getPoint());
                        } catch (IOException e1) {
                        }
                }
    }

    @Override
    public void update(User user, int point) {
      
                 File inputFile = new File("player.txt");
                 boolean name,password;
                 
                  userNameInput = user.getName();
                  passwordInput = new String(user.getPassword());
                 
                 try {
                        Scanner in = new Scanner(inputFile);
                        while (in.hasNextLine())
                        {
                          String s = in.nextLine();
                          String[] sArray = s.split("_");
                          name=userNameInput.equals(sArray[0]);
                          password=passwordInput.equals(sArray[1]);
                          
                          if(password==true && name==true) {
                              user.setPoint(point);
                              write(user);
                          }
                        }
                 }catch (FileNotFoundException e1) {
                        JOptionPane.showMessageDialog(null,"User Database Not Found", "Error",JOptionPane.ERROR_MESSAGE);
                    }
    }

    @Override
    public int read(User user) {
     File inputFile = new File("player.txt");
                 boolean name,password,temp;
                 int a=0;
                 
                  userNameInput = user.getName();
                  passwordInput = new String(user.getPassword());
                 
                  
                 try {
                        Scanner in = new Scanner(inputFile);
                        while (in.hasNextLine())
                        {
                          String s = in.nextLine();
                          String[] sArray = s.split("_");
                          name=userNameInput.equals(sArray[0]);
                          password=passwordInput.equals(sArray[1]);
                          
                          if(password==true&&name==true) {
                              temp=true;
                          }
                          else
                              temp=false;
                          if (temp==true)
                          {
                            JOptionPane.showMessageDialog(null,"Login Successful", "Success",JOptionPane.INFORMATION_MESSAGE);
                            a++;
                            break;
                          }
                        }
                        if(a==0) {
                                JOptionPane.showMessageDialog(null,"Invalid Username / Password Combo", "Error",JOptionPane.ERROR_MESSAGE);

                        }
                        in.close();
                       

                    } catch (FileNotFoundException e1) {
                        JOptionPane.showMessageDialog(null,"User Database Not Found", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                 return a;
    }
    
    
    
}
