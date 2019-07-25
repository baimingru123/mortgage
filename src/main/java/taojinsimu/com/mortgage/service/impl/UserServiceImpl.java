package taojinsimu.com.mortgage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.mapper.UserMapper;
import taojinsimu.com.mortgage.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUserNameExist(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Override
    public User Login(User user) {
        return userMapper.getByUserNamePassword(user);
    }
}
