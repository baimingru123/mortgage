package taojinsimu.com.mortgage.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import taojinsimu.com.mortgage.bean.LendInfo;
import taojinsimu.com.mortgage.dto.UserLendDto;
import taojinsimu.com.mortgage.form.LendInfoForm;

import java.util.List;

/**
 * @author bmr
 * @time 2019-07-25 19:40
 */
public interface LendInfoService extends IService<LendInfo> {

    /**
     * 添加出借款信息
     * @param form
     */
    void addInfo(LendInfoForm form);

    /**
     * 编辑出借款信息
     * @param form
     */
    void editInfo(LendInfoForm form);

    /**
     * 获取某用户下发布的出借款信息列表
     * @param userId
     * @return
     */
    List<LendInfo> findUserLendInfoList(int userId);


    /**
     * 获取所有用户发布的发布中状态的出借款信息列表
     * @return
     */
    List<UserLendDto> findUserLendInfoList();

    /**
     * 获取所有用户发布的发布中状态的出借款信息列表 分页
     * @return
     */
    List<UserLendDto> findUserLendInfoList(Page<UserLendDto> page);
}
