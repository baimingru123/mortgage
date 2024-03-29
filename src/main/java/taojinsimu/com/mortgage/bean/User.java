package taojinsimu.com.mortgage.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Generated;

@Data
@TableName("sf_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    private String salt;

    @TableField("token_id")
    private String tokenId;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
