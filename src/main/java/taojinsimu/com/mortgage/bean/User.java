package taojinsimu.com.mortgage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

@Data
@TableName("sf_user")
public class User {
    @TableId
    @Generated
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
