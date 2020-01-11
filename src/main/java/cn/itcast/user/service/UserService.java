package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserService {

    public void regist(User user) throws UserException {
        UserDao userDao = new UserDao();
        User _user = userDao.findByUsername(user.getUsername());
        if (_user != null){
            throw new UserException("用户" + _user.getUsername() + "已经被注册！");
        }
        userDao.add(user);
    }

    public User login(User user) throws UserException {
        UserDao userDao = new UserDao();
        User _user = userDao.findByUsername(user.getUsername());

        if (_user == null) {
            throw new UserException("用户" + user.getUsername() + "不存在");
        } else if ( !_user.getPassword().equals(user.getPassword())) {
            throw new UserException("密码错误");
        }
        return _user;
    }

}
