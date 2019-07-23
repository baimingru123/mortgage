package taojinsimu.com.mortgage.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    ;

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
