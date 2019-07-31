package taojinsimu.com.mortgage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taojinsimu.com.mortgage.bean.HouseMortgageInfo;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.condition.HouseCondition;
import taojinsimu.com.mortgage.condition.LendCondition;
import taojinsimu.com.mortgage.dto.UserHouseDto;
import taojinsimu.com.mortgage.enums.HouseStatusEnum;
import taojinsimu.com.mortgage.enums.LendStatusEnum;
import taojinsimu.com.mortgage.exception.MortgagePageException;
import taojinsimu.com.mortgage.form.HouseInfoForm;
import taojinsimu.com.mortgage.mapper.HouseMortgageInfoMapper;
import taojinsimu.com.mortgage.service.HouseInfoService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 21:02
 */
@Service
public class HouseInfoServiceImpl extends ServiceImpl<HouseMortgageInfoMapper,HouseMortgageInfo> implements HouseInfoService {
    @Autowired
    private HouseMortgageInfoMapper mapper;

    @Autowired
    private HttpSession session;

    @Override
    public void addInfo(HouseInfoForm form) {
        HouseMortgageInfo info=new HouseMortgageInfo();
        BeanUtils.copyProperties(form,info);

        User user=(User)session.getAttribute("user");

        info.setUserId(user.getId());
        boolean flag=this.save(info);

        if(!flag)
            throw new MortgagePageException("保存信息失败");
    }

    @Override
    public List<HouseMortgageInfo> findUserHouseInfoList(int userId) {
        return mapper.getByUserId(userId);
    }

    @Override
    public List<UserHouseDto> findUserHouseInfoList() {
        //组装查询条件
        HouseCondition condition=new HouseCondition();
        condition.setHouseStatus(HouseStatusEnum.IN_RELEASE.getCode());
        return  mapper.getUserHouseList(condition);
    }

    @Override
    public List<UserHouseDto> findUserHouseInfoList(Page<UserHouseDto> page) {
        //组装查询条件
        HouseCondition condition=new HouseCondition();
        condition.setHouseStatus(HouseStatusEnum.IN_RELEASE.getCode());
        return  mapper.getUserHouseList(condition,page);
    }
}
