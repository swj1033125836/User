package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserService {

    public void regist(User user) throws UserException {
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new UserException("用户名或密码未填写！");
        }
        UserDao userDao = new UserDao();
        User _user = userDao.findByUsername(user.getUsername());
        if (_user != null){
            throw new UserException("用户" + _user.getUsername() + "已经被注册！");
        }
        userDao.add(user);
    }
}
