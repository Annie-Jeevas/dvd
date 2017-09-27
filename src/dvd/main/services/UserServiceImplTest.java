package dvd.main.services;

import dvd.main.BeansConfig;
import dvd.main.dao.CommonDao;
import dvd.main.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by anya on 23.09.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = BeansConfig.class)
@Transactional
public class UserServiceImplTest {

    @Autowired
    @Qualifier("userDao")
    private CommonDao<User> userDao;

    @Test
    public void getAllUsersTest() throws Exception {
        System.out.print(userDao.getAll().get(0));
    }

}