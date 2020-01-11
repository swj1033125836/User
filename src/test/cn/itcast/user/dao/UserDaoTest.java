package cn.itcast.user.dao;

import cn.itcast.user.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testFindByUsername() {
        String username = "lisi";
        UserDao userDao = new UserDao();
        User user = userDao.findByUsername(username);
        System.out.println("username=" + user.getUsername());
        System.out.println("password=" + user.getPassword());
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("lisi1");
        user.setPassword("123");
        UserDao userDao = new UserDao();
        userDao.add(user);
    }
}

