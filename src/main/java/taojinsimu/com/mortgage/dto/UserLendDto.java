package taojinsimu.com.mortgage.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2019-07-25 20:28
 */
@Data
public class UserLendDto {

    @TableField("user_id")
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("lend_amount")
    private BigDecimal lendAmount;

    @TableField("lend_status")
    private Integer lendStatus;

    @TableField("contact_name")
    private String contactName;

    @TableField("contact_phone")
    private String contactPhone;

    @TableField("lend_create_time")
    private String lendCreateTime;




}
