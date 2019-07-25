package taojinsimu.com.mortgage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.form.LoginForm;

public interface UserService extends IService<User> {

    User checkUserNameExist(String userName);

    void Register(LoginForm form);
    
    User Login(LoginForm form);
}
