package taojinsimu.com.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import taojinsimu.com.mortgage.bean.User;

import javax.servlet.http.HttpSession;

/**
 * @author bmr
 * @time 2019-07-25 21:15
 */
public class BaseController {


    protected HttpSession session;

    protected User loginUser;


    public BaseController() {
    }

    public BaseController(HttpSession session) {
        this.session=session;
        User sessionUser=(User)session.getAttribute("user");
        if( sessionUser!= null){
            this.loginUser = sessionUser;
        }

        System.out.println(session);

    }
}
