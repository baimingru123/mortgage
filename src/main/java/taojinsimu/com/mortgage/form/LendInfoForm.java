package taojinsimu.com.mortgage.form;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2019-07-25 19:55
 */
@Data
public class LendInfoForm {


    @NotNull(message = "出借金额不能为空")
    @DecimalMin(value = "0",message = "出借金额不能小于0")
    private BigDecimal lendAmount;


   @NotEmpty(message = "联系方式不能为空")
    private String contactPhone;
}
