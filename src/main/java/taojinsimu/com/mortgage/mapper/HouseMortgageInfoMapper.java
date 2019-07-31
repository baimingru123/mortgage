package taojinsimu.com.mortgage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import taojinsimu.com.mortgage.bean.HouseMortgageInfo;
import taojinsimu.com.mortgage.condition.HouseCondition;
import taojinsimu.com.mortgage.condition.LendCondition;
import taojinsimu.com.mortgage.dto.UserHouseDto;
import taojinsimu.com.mortgage.dto.UserLendDto;

import java.util.List;

public interface HouseMortgageInfoMapper extends BaseMapper<HouseMortgageInfo> {


    List<HouseMortgageInfo> getByUserId(int userId);

    /**
     * 关联用户、房屋抵押信息表  查询列表
     * @return
     */
    List<UserHouseDto> getUserHouseList(HouseCondition condition);

    /**
     * 关联用户、房屋抵押信息表  查询列表 分页
     * @return
     */
    List<UserHouseDto> getUserHouseList(@Param("condition") HouseCondition condition, Page<UserHouseDto> page);
}
