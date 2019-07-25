package taojinsimu.com.mortgage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taojinsimu.com.mortgage.bean.LendInfo;
import taojinsimu.com.mortgage.bean.User;
import taojinsimu.com.mortgage.condition.LendCondition;
import taojinsimu.com.mortgage.dto.UserLendDto;
import taojinsimu.com.mortgage.enums.LendStatusEnum;
import taojinsimu.com.mortgage.exception.MortgagePageException;
import taojinsimu.com.mortgage.form.LendInfoForm;
import taojinsimu.com.mortgage.mapper.LendInfoMapper;
import taojinsimu.com.mortgage.service.LendInfoService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 19:41
 */
@Service
public class LendInfoServiceImpl extends ServiceImpl<LendInfoMapper,LendInfo> implements LendInfoService {

    @Autowired
    private LendInfoMapper mapper;

    @Autowired
    private HttpSession session;

    @Override
    public void addInfo(LendInfoForm form) {
        User user=(User)session.getAttribute("user");
        LendInfo info=new LendInfo();
        info.setLendTotalAmount(form.getLendAmount());
        info.setUserId(user.getId());
        info.setContactPhone(form.getContactPhone());

        boolean flag=this.save(info);
        if(!flag)
            throw new MortgagePageException("保存出借款信息失败");
    }

    @Override
    public List<LendInfo> findUserLendInfoList(int userId) {
        return mapper.getByUserId(userId);
    }

    @Override
    public List<UserLendDto> findUserLendInfoList() {
        //组装查询条件
        LendCondition condition=new LendCondition();
        List statusList=new ArrayList();
        statusList.add(LendStatusEnum.IN_RELEASE.getCode());
        statusList.add(LendStatusEnum.PARTIAL_LENDING.getCode());
        condition.setLendStatusList(statusList);

        return  mapper.getUserLendList(condition);
    }
}
