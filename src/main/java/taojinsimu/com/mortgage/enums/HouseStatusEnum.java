package taojinsimu.com.mortgage.enums;

import lombok.Getter;

/**
 * @author bmr
 * @time 2019-07-25 22:02
 */
@Getter
public enum HouseStatusEnum {

    IN_RELEASE(1,"发布中"),
    ALREADY_MORTGAGED(2,"已抵押"),
    ;

    private Integer code;

    private String message;

    HouseStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
