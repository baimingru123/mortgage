package taojinsimu.com.mortgage.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import taojinsimu.com.mortgage.condition.HouseCondition;
import taojinsimu.com.mortgage.dto.UserHouseDto;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bmr
 * @time 2019-07-31 14:25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseMortgageInfoMapperTest {
    @Autowired
    private HouseMortgageInfoMapper mapper;

    @Test
    public void getUserHouseList() {
        HouseCondition condition=new HouseCondition();
        condition.setHouseStatus(1);

        Page<UserHouseDto> page=new Page<>(1,2);
        List<UserHouseDto> list=mapper.getUserHouseList(condition,page);
        for (UserHouseDto dto:list){
            System.out.println(dto);
        }
    }
}