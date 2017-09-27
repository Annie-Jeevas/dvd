package dvd.main.services;

import dvd.main.dao.CommonDao;
import dvd.main.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anya on 14.09.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao")
    private CommonDao<User> userDao;

    @Transactional
    public List<User> getAllUsers(){
        return userDao.getAll();
    }

    @Transactional
    public void addUser(User user) {
        userDao.add(user);
    }

    @Transactional
    public void removeUser(Long userId) {
        userDao.delete(userId);
    }
}
