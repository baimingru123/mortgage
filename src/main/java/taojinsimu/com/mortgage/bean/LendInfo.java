package taojinsimu.com.mortgage.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;

@Data
@TableName("sf_lend_info")
public class LendInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 发布人id.**/
    @TableField("user_id")
    private Integer userId;

    /** 出借金额  单位:万元**/
    @TableField("lend_total_amount")
    private BigDecimal lendTotalAmount;

    /** 出借周期**/
    @TableField("lend_cycle")
    private Integer lendCycle;

    /**出借周期单位  1天  2月  3年**/
    @TableField("lend_cycle_unit")
    private Integer lendCycleUnit;

    /**利率  单位：%**/
    @TableField("lend_rate")
    private BigDecimal lendRate;

    /**已出借金额  单位：万元**/
    @TableField("already_lend_amount")
    private BigDecimal alreadyLendAmount;

    /**未出借金额  单位：万元**/
    @TableField("no_lend_amount")
    private BigDecimal noLendAmount;

    /**已出借次数  **/
    @TableField("already_lend_count")
    private BigDecimal alreadyLendCount;

    /**总出借次数  **/
    @TableField("lend_total_count")
    private BigDecimal lendTotalCount;

    /**联系人  **/
    @TableField("contact_name")
    private String contactName;

    /**联系方式  **/
    @TableField("contact_phone")
    private String contactPhone;

    /**状态  1发布中  2部分出借  3全部出借 **/
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
