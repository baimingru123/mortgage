package taojinsimu.com.mortgage.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import taojinsimu.com.mortgage.dto.UserLendDto;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bmr
 * @time 2019-07-25 20:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getLendList() {
        List<UserLendDto> list=userMapper.getLendList(2);
        for (UserLendDto dto:list){
            System.out.println(dto);
        }
    }
}