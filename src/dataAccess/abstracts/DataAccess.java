
package dataAccess.abstracts;
/*
DataAccess.java                       Author: Ufuk Lisan  ID: 21795394

It is DataAccess interface. It's purpose is polymorphism. Maybe you don't use files. You want to use a database.  
*/
import business.entity.User;

public interface DataAccess {
    
        public void write(User user);
	public void update(User user,int point);
	public int read(User user);
}
