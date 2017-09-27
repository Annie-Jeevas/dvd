package dvd.main.services;

import dvd.main.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anya on 14.09.2017.
 */

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);

    public void removeUser(Long userId);
}
