package dvd.main.dao;

import dvd.main.BeansConfig;
import dvd.main.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Created by anya on 07.09.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = BeansConfig.class)
public class CommonDaoImplTest {

    @Autowired
    @Qualifier("userDao")
    private CommonDao<User> userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void Test() {
        User user = new User();
        user.setLogin("anya");
        user.setPassword("pass");
        userDao.add(user);
    }
}