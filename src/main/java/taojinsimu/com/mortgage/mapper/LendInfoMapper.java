package taojinsimu.com.mortgage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import taojinsimu.com.mortgage.bean.LendInfo;
import taojinsimu.com.mortgage.condition.LendCondition;
import taojinsimu.com.mortgage.dto.UserLendDto;

import java.util.List;

public interface LendInfoMapper extends BaseMapper<LendInfo> {

    List<LendInfo> getByUserId(int userId);

    /**
     * 关联用户、放贷信息表  查询列表
     * @return
     */
    List<UserLendDto> getUserLendList(LendCondition condition);

    /**
     * 关联用户、放贷信息表  查询列表   分页
     */
    List<UserLendDto> getUserLendList(@Param("condition") LendCondition condition, Page<UserLendDto> page);
}
