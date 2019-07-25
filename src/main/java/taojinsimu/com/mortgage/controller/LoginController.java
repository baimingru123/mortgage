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
public class LoginController{

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

       userService.Register(form);
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

        User userLogin=userService.Login(form);

        session.setAttribute("user",userLogin);

        ModelAndView mv=new ModelAndView("index");
        mv.addObject("user",userLogin);
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
