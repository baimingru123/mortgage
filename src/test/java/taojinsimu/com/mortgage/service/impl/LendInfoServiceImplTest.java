package taojinsimu.com.mortgage.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import taojinsimu.com.mortgage.dto.UserLendDto;
import taojinsimu.com.mortgage.service.LendInfoService;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bmr
 * @time 2019-07-25 22:11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LendInfoServiceImplTest {
    @Autowired
    private LendInfoService lendInfoService;

    @Test
    public void findUserLendInfoList() {
        List<UserLendDto> list=lendInfoService.findUserLendInfoList();
        for(UserLendDto dto:list){
            System.out.println(dto);
        }
    }
}