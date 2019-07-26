package taojinsimu.com.mortgage.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;

@Data
@TableName("sf_house_mortgage_info")
public class HouseMortgageInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 发布人id.**/
    @TableField("user_id")
    private Integer userId;

    /** 小区名**/
    @TableField("village_name")
    private String villageName;

    /** 小区地址**/
    @TableField("village_address")
    private String villageAddress;

    /**小区照片**/
    @TableField("village_img_url")
    private String villageImgUrl;

    /**房屋内部照片**/
    @TableField("house_in_img_url")
    private String houseInImgUrl;

    /**房产证照片**/
    @TableField("certificate_house_img_url")
    private String certificateHouseImgUrl;

    /**抵押价格  单位：万元**/
    @TableField("mortgage_price")
    private BigDecimal mortgagePrice;

    /**联系人  **/
    @TableField("contact_name")
    private String contactName;

    /**联系方式  **/
    @TableField("contact_phone")
    private String contactPhone;

    /**状态  状态  1发布中  2已抵押 **/
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
