package taojinsimu.com.mortgage.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import taojinsimu.com.mortgage.dto.UserHouseDto;
import taojinsimu.com.mortgage.service.HouseInfoService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bmr
 * @time 2019-07-31 14:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HouseInfoServiceImplTest {
    @Autowired
    private HouseInfoService service;

    @Test
    public void findUserHouseInfoList() {
        Page<UserHouseDto> page=new Page<>(1,3);
        List<UserHouseDto> list=service.findUserHouseInfoList(page);
        for (UserHouseDto dto:list){
            System.out.println(dto);
        }
    }
}