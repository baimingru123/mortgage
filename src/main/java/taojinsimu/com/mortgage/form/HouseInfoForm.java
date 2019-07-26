package taojinsimu.com.mortgage.form;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2019-07-25 21:04
 */
@Data
public class HouseInfoForm {

    /** 小区名**/
    private String villageName;

    /** 小区地址**/
    private String villageAddress;

    /**房产证照片**/
    @NotEmpty(message = "房产证照片必须上传")
    private String certificateHouseImgUrl;

    /**抵押价格  单位：万元**/
    @NotNull(message = "抵押价格不能为空")
    @DecimalMin(value = "0",message = "抵押金额不能小于0")
    private BigDecimal mortgagePrice;

    /**联系人  **/
    @NotEmpty(message = "联系人不能为空")
    private String contactName;

    /**联系方式  **/
    @NotEmpty(message = "联系方式不能为空")
    private String contactPhone;
}
