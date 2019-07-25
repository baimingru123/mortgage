package taojinsimu.com.mortgage.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2019-07-25 20:28
 */
@Data
public class UserHouseDto {

    @TableField("user_id")
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("house_info_id")
    private Integer houseInfoId;

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

    @TableField("contact_phone")
    private String contactPhone;

    @TableField("house_create_time")
    private String houseCreateTime;




}
