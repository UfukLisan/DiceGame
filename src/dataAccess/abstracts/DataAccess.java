
package dataAccess.abstracts;

import business.entity.User;
import java.util.List;

public interface DataAccess {
    
        public void write(User user);
	public void update(User user,int point);
	public User read(User user);
}
