package dvd.main.dao;

import dvd.main.BeansConfig;
import dvd.main.entities.User;
import org.junit.Assert;
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

import java.util.List;

/**
 * Created by anya on 07.09.2017.
 * TODO - переписать тесты
 * TODO - написать тесты для всех сущностей
 * TODO - написать скрипты добавления и очищения БД
 * TODO - в идеале создать тестовую БД и конфигурацию к ней
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = BeansConfig.class)
@Rollback(false)
@Transactional
public class CommonDaoImplTest {

    private User user;

    @Autowired
    @Qualifier("userDao")
    private CommonDao<User> userDao;

    @Before
    public void setUp(){
        user = new User();
        user.setLogin("anya");
        user.setPassword("pass");
    }

    @Test
    public void addTest() {
        userDao.add(user);
    }
    @Test
    public void getTest() {
        addTest();
        List<User> users = userDao.getAll();
        Assert.assertEquals(user, users.get(users.size()-1));
    }

}