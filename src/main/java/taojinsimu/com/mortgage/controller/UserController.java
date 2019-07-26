package taojinsimu.com.mortgage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import taojinsimu.com.mortgage.bean.LendInfo;
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
     * 跳转放款信息新增页面
     * @return
     */
    @GetMapping("/addLendInfo")
    public ModelAndView addLendInfo(){
        return new ModelAndView("user/lend_info_add");
    }

    /**
     * 发布放款信息
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/addLendInfo")
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
     * 跳转放款信息修改页面
     * @return
     */
    @GetMapping("/updateLendInfo")
    public ModelAndView updateLendInfo(int lendInfoId){
        if(lendInfoId==0){
            throw new MortgagePageException("id不能为空");
        }
        LendInfo lendInfo=lendInfoService.getById(lendInfoId);
        if(lendInfo==null){
            throw new MortgagePageException("放款信息不存在");
        }
        ModelAndView mv=new ModelAndView("user/lend_info_edit");
        mv.addObject("info",lendInfo);
        return mv;
    }

    /**
     * 修改放款信息
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateLendInfo")
    public ModelAndView updateLendInfo(@Valid LendInfoForm form, BindingResult bindingResult,HttpSession session){
        if(bindingResult.hasErrors()){
            log.info("【用户修改放款信息】参数不正确，LendInfoForm;{}",form);
            throw new MortgagePageException(bindingResult.getFieldError().getDefaultMessage());
        }

        lendInfoService.editInfo(form);


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

    /**
     * 获取个人发布的房屋抵押信息和放款信息
     */
    @GetMapping("/getLendHouseList")
    public ModelAndView getLendHouseList(){
        ModelAndView mv=new ModelAndView("user/my_publish");
        List list=userService.getLendHouseList();
        mv.addObject("list",list);
        return mv;
    }

}
