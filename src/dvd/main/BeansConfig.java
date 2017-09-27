package dvd.main;

import dvd.main.dao.CommonDao;
import dvd.main.dao.CommonDaoImpl;
import dvd.main.entities.Disk;
import dvd.main.entities.User;
import dvd.main.services.UserService;
import dvd.main.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by anya on 14.09.2017.
 */
@Configuration
public class BeansConfig {


    @Bean
    public CommonDao<Disk> diskDao() {
        return new CommonDaoImpl<Disk>(Disk.class);
    }
    @Bean
    public CommonDao<User> userDao() {
        return new CommonDaoImpl<User>(User.class);
    }
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(
                new String[]{"dvd.main"});
        emf.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter());
        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dvd");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
