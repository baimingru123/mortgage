package taojinsimu.com.mortgage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.exception.MortgagePageException;
import taojinsimu.com.mortgage.form.HouseInfoForm;
import taojinsimu.com.mortgage.form.LendInfoForm;
import taojinsimu.com.mortgage.service.HouseInfoService;
import taojinsimu.com.mortgage.service.LendInfoService;
import taojinsimu.com.mortgage.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 8:24
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController{

    @Autowired
    private UserService userService;

    @Autowired
    private LendInfoService lendInfoService;

    @Autowired
    private HouseInfoService houseInfoService;

    /**
     * 发布放款信息
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/editLendInfo")
    public ModelAndView addLendInfo(@Valid LendInfoForm form, BindingResult bindingResult,HttpSession session){
        if(bindingResult.hasErrors()){
            log.info("【用户发布放款信息】参数不正确，LendInfoForm;{}",form);
            throw new MortgagePageException(bindingResult.getFieldError().getDefaultMessage());
        }

        lendInfoService.addInfo(form);

        ModelAndView mv=new ModelAndView("user/lend_info_list");
        User loginUser=(User)session.getAttribute("user");
        List lendList=lendInfoService.findUserLendInfoList(loginUser.getId());
        mv.addObject(lendList);
        return mv;
    }


    /**
     * 发布房产抵押信息
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/editHouseMortgageInfo")
    public ModelAndView addHouseMortgageInfo(@Valid HouseInfoForm form, BindingResult bindingResult,HttpSession session){
        if(bindingResult.hasErrors()){
            log.info("【用户发布房产抵押信息】参数不正确，HouseInfoForm;{}",form);
            throw new MortgagePageException(bindingResult.getFieldError().getDefaultMessage());
        }

        houseInfoService.addInfo(form);

        ModelAndView mv=new ModelAndView("user/house_mortgage_info_list");
        User loginUser=(User)session.getAttribute("user");
        List lendList=lendInfoService.findUserLendInfoList(loginUser.getId());
        mv.addObject(lendList);
        return mv;
    }


}
