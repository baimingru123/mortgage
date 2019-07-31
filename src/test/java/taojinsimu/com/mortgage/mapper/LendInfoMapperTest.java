package taojinsimu.com.mortgage.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import taojinsimu.com.mortgage.bean.LendInfo;
import taojinsimu.com.mortgage.condition.LendCondition;
import taojinsimu.com.mortgage.config.CommonConfig;
import taojinsimu.com.mortgage.dto.UserLendDto;
import taojinsimu.com.mortgage.enums.LendStatusEnum;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bmr
 * @time 2019-07-31 11:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LendInfoMapperTest {
    @Autowired
    private LendInfoMapper mapper;

    @Autowired
    private CommonConfig commonConfig;

    @Test
    public void getUserLendList() {
        LendCondition condition=new LendCondition();
        List statusList=new ArrayList();
        statusList.add(LendStatusEnum.IN_RELEASE.getCode());
        statusList.add(LendStatusEnum.PARTIAL_LENDING.getCode());
        condition.setLendStatusList(statusList);

        Page<UserLendDto> page = new Page<>(commonConfig.getPage(),commonConfig.getPageSize());
        List<UserLendDto> list=mapper.getUserLendList(condition,page);
        System.out.println(page.getTotal());
        for(UserLendDto dto:list){
            System.out.println(dto);
        }
    }
}