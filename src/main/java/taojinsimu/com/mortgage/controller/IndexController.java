package taojinsimu.com.mortgage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import taojinsimu.com.mortgage.service.HouseInfoService;
import taojinsimu.com.mortgage.service.LendInfoService;

import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 21:00
 */
@Controller
@RequestMapping({"/","/index"})
@Slf4j
public class IndexController  {

    @Autowired
    private LendInfoService lendInfoService;

    @Autowired
    private HouseInfoService houseInfoService;

    /**
     * 首页面
     * 获取所有用户发布的房屋抵押信息和放贷信息
     * @return
     */
    @GetMapping({"", "/index"})
    public ModelAndView index(){
        System.out.println("进入到主页了");
        ModelAndView mv=new ModelAndView("index");

        List userLendList=lendInfoService.findUserLendInfoList();
        List userHouseList=houseInfoService.findUserHouseInfoList();
        mv.addObject("userLendList",userLendList);
        mv.addObject("userHouseList",userHouseList);
        return mv;

    }
}
