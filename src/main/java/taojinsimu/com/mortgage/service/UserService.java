package taojinsimu.com.mortgage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import taojinsimu.com.mortgage.bean.User;

public interface UserService extends IService<User> {

    User checkUserNameExist(String userName);
    
    User Login(User user);
}
