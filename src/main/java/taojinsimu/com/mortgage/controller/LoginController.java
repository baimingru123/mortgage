package taojinsimu.com.mortgage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.exception.MortgagePageException;
import taojinsimu.com.mortgage.form.LoginForm;
import taojinsimu.com.mortgage.service.UserService;
import taojinsimu.com.mortgage.utils.MD5Util;
import taojinsimu.com.mortgage.utils.SaltUtil;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 登录类接口  控制层
 * 该层的接口不进行拦截
 */
@Controller
@RequestMapping("/user_login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册接口
     * @param form
     * @param bindResult
     * @return
     */
    @PostMapping("/register")
    public ModelAndView register(@Valid LoginForm form, BindingResult bindResult){

        if(bindResult.hasErrors()){
            log.info("【用户注册】参数不正确，loginForm;{}",form);
            throw new MortgagePageException(bindResult.getFieldError().getDefaultMessage());
        }

        String username=form.getUsername();
        User user=userService.checkUserNameExist(username);
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

        boolean insertFlag=userService.save(userInsert);
        if(!insertFlag){
            throw new MortgagePageException("用户注册异常，请稍等");
        }

        return new ModelAndView("user_login/login");
    }

    /**
     * 用户登录接口
     * @param form
     * @param bindResult
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm form, BindingResult bindResult,HttpSession session){
        if(bindResult.hasErrors()){
            log.info("【用户登录】参数不正确，loginForm;{}",form);
            throw new MortgagePageException(bindResult.getFieldError().getDefaultMessage());
        }

        //获取用户盐
        String username=form.getUsername();
        User user=userService.checkUserNameExist(username);

        if(user == null){
            throw new MortgagePageException("用户名不存在");
        }

        User userForm=new User();
        userForm.setUserName(username);
        userForm.setPassword(MD5Util.getMD5(form.getPassword()+user.getSalt()));
        User userLogin=userService.Login(userForm);

        if(userLogin == null){
            throw new MortgagePageException("用户名密码不正确");
        }

        session.setAttribute("user",userLogin);

        ModelAndView mv=new ModelAndView("index");
        mv.addObject("user",user);
        return mv;
    }


    /**
     * 用户登出接口
     * @return
     */
    @PostMapping("/logout")
    public ModelAndView logout(HttpSession session){

        //移除所有的session
        session.invalidate();
        return new ModelAndView("user_login/login");
    }



}
