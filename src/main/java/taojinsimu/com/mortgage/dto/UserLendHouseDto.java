package taojinsimu.com.mortgage.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2019-07-26 9:08
 */
@Data
public class UserLendHouseDto {
    @TableField("user_id")
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("lend_amount")
    private BigDecimal lendAmount;

    @TableField("lend_status")
    private Integer lendStatus;

    @TableField("lend_contact_name")
    private String lendContactName;

    @TableField("lend_contact_phone")
    private String lendContactPhone;

    @TableField("lend_create_time")
    private String lendCreateTime;

    @TableField("house_id")
    private Integer houseId;

    @TableField("village_name")
    private String villageName;

    @TableField("village_address")
    private String villageAddress;

    @TableField("certificate_house_img_url")
    private String certificateHouseImgUrl;

    @TableField("mortgage_price")
    private BigDecimal mortgagePrice;

    @TableField("house_status")
    private Integer houseStatus;

    @TableField("house_contact_name")
    private String houseContactName;

    @TableField("house_contact_phone")
    private String houseContactPhone;

    @TableField("house_create_time")
    private String houseCreateTime;
}
