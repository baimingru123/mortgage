package taojinsimu.com.mortgage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.dto.UserLendDto;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User getByUserName(String userName);

    User getByUserNamePassword(User user);

    List<UserLendDto> getLendList(int userId);
}
