package taojinsimu.com.mortgage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import taojinsimu.com.mortgage.bean.HouseMortgageInfo;
import taojinsimu.com.mortgage.bean.LendInfo;
import taojinsimu.com.mortgage.dto.UserHouseDto;
import taojinsimu.com.mortgage.dto.UserLendDto;
import taojinsimu.com.mortgage.form.HouseInfoForm;

import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 21:01
 */
public interface HouseInfoService extends IService<HouseMortgageInfo> {

    /**
     * 上传房屋抵押信息
     * @param form
     */
    void addInfo(HouseInfoForm form);

    /**
     * 获取某用户下发布的房屋抵押信息列表
     * @param userId
     * @return
     */
    List<HouseMortgageInfo> findUserHouseInfoList(int userId);


    /**
     * 获取所有用户发布的发布中状态的房屋抵押信息列表
     * @return
     */
    List<UserHouseDto> findUserHouseInfoList();

    /**
     * 获取所有用户发布的发布中状态的房屋抵押信息列表 分页
     * @return
     */
    List<UserHouseDto> findUserHouseInfoList(Page<UserHouseDto> page);
}
