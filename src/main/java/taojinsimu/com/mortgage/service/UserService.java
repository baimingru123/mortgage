package taojinsimu.com.mortgage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.dto.UserLendHouseDto;
import taojinsimu.com.mortgage.form.LoginForm;

import java.util.List;

public interface UserService extends IService<User> {

    User checkUserNameExist(String userName);

    void Register(LoginForm form);
    
    User Login(LoginForm form);

    List<UserLendHouseDto> getLendHouseList();
}
