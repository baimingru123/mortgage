package taojinsimu.com.mortgage.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.enums.SelfExceptionType;
import taojinsimu.com.mortgage.exception.MortgagePageException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author bmr
 * @time 2019-01-21 17:03
 */
@Aspect
@Component
@Slf4j
public class LoginAuthAspect {


    @Pointcut("execution(public * taojinsimu.com.mortgage.controller.*.*(..))"+
            "&& !execution(public * taojinsimu.com.mortgage.controller.LoginController.*(..))"+
            "&& !execution(public * taojinsimu.com.mortgage.controller.IndexController.*(..))")
    public void verify(){ }

    @Before("verify()")
    public void doVerify(){

        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        System.out.println("拦截到请求:"+request.getRequestURI());
        HttpSession session=request.getSession();
        User loginUser=(User)session.getAttribute("user");


        //查询session中是否存在登录用户的信息
        if(loginUser==null){
            log.warn("【登录校验】session中不存在用户信息");
            throw new MortgagePageException(SelfExceptionType.NO_LOGIN_EXCEPTION);
        }


    }
}
