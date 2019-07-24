package taojinsimu.com.mortgage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;

@Data
@TableName("sf_house_mortgage_info")
public class HouseMortgageInfo {
    @TableId
    @Generated
    private Integer id;

    /** 发布人id.**/
    @TableField("user_id")
    private Integer userId;

    /** 小区名**/
    @TableField("village_name")
    private BigDecimal villageName;

    /** 小区地址**/
    @TableField("village_address")
    private Integer villageAddress;

    /**小区照片**/
    @TableField("village_img_url")
    private Integer villageImgUrl;

    /**房屋内部照片**/
    @TableField("house_in_img_url")
    private BigDecimal houseInImgUrl;

    /**房产证照片**/
    @TableField("certificate_house_img_url")
    private BigDecimal certificateHouseImgUrl;

    /**抵押价格  单位：万元**/
    @TableField("mortgage_price")
    private BigDecimal mortgagePrice;

    /**联系方式  **/
    @TableField("contact_phone")
    private String contactPhone;

    /**状态  状态  1发布中  2已抵押 **/
    @TableField("status")
    private BigDecimal status;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
