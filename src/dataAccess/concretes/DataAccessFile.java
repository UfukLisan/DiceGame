
package dataAccess.concretes;

import dataAccess.abstracts.DataAccess;
import business.entity.User;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class DataAccessFile implements DataAccess{
  
    private File file;
    private String filePath;
    
    public DataAccessFile(){
    this.filePath = "C:\\Users\\UFUK LİSAN\\Desktop\\DiceGame\\player.txt";
    file = new File (this.filePath);
    
    
    if(!file.exists()){  
        try {
         file.createNewFile();
        } catch (IOException ioe) {
         JOptionPane.showMessageDialog(null,"File not create. "+ioe.getMessage());
        } catch (Exception e){
         JOptionPane.showMessageDialog(null,"File not create. "+e.getMessage());            
        }
       }
       
    }
    
    @Override
    public void write(User user) {
       
        try {
        FileWriter fWriter = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        
        bWriter.write(user.getName()+user.getPassword()+user.getPoint());
        
        bWriter.close();
        } catch (IOException ioe) {
         JOptionPane.showMessageDialog(null,"Can not write. "+ioe.getMessage());   
        }catch (Exception e){
         JOptionPane.showMessageDialog(null,"Can not write. "+e.getMessage());            
        }
        
    }

    @Override
    public void update(User user,int point) {
        User tempUser;
       
        tempUser=read(user);
        tempUser.setPoint(point);
        
        user.setDefaultPoint(tempUser.getPoint());
    }

    @Override
    public User read(User user) {
        
        String line,myUserLine;
        User tempUser = new User();
        
        myUserLine = user.getName()+" "+user.getPassword()+" "+user.getPoint();
        try {
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        
        while((line=bReader.readLine())!= null){
            if(line.equals(myUserLine)){
            tempUser.setName(user.getName());
            tempUser.setPassword(user.getPassword());
            tempUser.setPoint(user.getPoint());
            }
        }
        bReader.close();
        } catch (IOException ioe) {
         JOptionPane.showMessageDialog(null,"Can not write. "+ioe.getMessage());   
        }catch (Exception e){
         JOptionPane.showMessageDialog(null,"Can not write. "+e.getMessage());            
        }
        return tempUser;
    }

}
