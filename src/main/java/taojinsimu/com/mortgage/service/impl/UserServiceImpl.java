package taojinsimu.com.mortgage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.dto.UserLendHouseDto;
import taojinsimu.com.mortgage.exception.MortgagePageException;
import taojinsimu.com.mortgage.form.LoginForm;
import taojinsimu.com.mortgage.mapper.UserMapper;
import taojinsimu.com.mortgage.service.UserService;
import taojinsimu.com.mortgage.utils.MD5Util;
import taojinsimu.com.mortgage.utils.SaltUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpSession session;

    @Override
    public User checkUserNameExist(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Override
    public void Register(LoginForm form) {

        String username=form.getUsername();
        User user=this.checkUserNameExist(username);
        if(user!=null){
            throw new MortgagePageException("用户名已存在");
        }

        //1.生成用户盐   2.对密码进行加密
        String salt=SaltUtil.getRandomSalt(8);
        String newPassWord=MD5Util.getMD5(form.getPassword()+salt);

        User userInsert=new User();
        userInsert.setSalt(salt);
        userInsert.setUserName(username);
        userInsert.setPassword(newPassWord);

        boolean insertFlag=this.save(userInsert);
        if(!insertFlag){
            throw new MortgagePageException("用户注册异常，请稍等");
        }
    }

    @Override
    public User Login(LoginForm form) {

        //获取用户盐
        String username=form.getUsername();
        User user=this.checkUserNameExist(username);

        if(user == null){
            throw new MortgagePageException("用户名不存在");
        }

        User userForm=new User();
        userForm.setUserName(username);
        userForm.setPassword(MD5Util.getMD5(form.getPassword()+user.getSalt()));
        User userLogin=userMapper.getByUserNamePassword(userForm);

        if(userLogin == null){
            throw new MortgagePageException("用户名密码不正确");
        }
        return userLogin;
    }

    @Override
    public List<UserLendHouseDto> getLendHouseList() {
        User user=(User)session.getAttribute("user");

        return userMapper.getLendHouseList(user.getId());
    }
}
