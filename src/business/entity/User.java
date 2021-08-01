
package business.entity;

public class User {
    
    private String name;
    private String password;
    private int point;

    public User() {
        this.name="";
        this.password="";
        this.point=0;                
    }
    public User(String name,String password){
        this.name=name;
        this.password=password;
        this.point=0;
    }
     public User(String name,String password,int point){
        this.name=name;
        this.password=password;
        this.point=point;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        if(this.point + point > 0)
        this.point = this.point + point;
        else 
            this.point = 0; // If the player loses the score, it cannot be lower than 0.
    }   
    public void setDefaultPoint(int point){
        this.point = point;
    }

    
}
