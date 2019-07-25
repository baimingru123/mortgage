package taojinsimu.com.mortgage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import taojinsimu.com.mortgage.service.UserService;

/**
 * @author bmr
 * @time 2019-07-25 8:24
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


}
