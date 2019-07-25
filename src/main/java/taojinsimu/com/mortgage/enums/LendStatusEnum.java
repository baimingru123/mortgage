package taojinsimu.com.mortgage.enums;

import lombok.Getter;

/**
 * @author bmr
 * @time 2019-07-25 22:02
 */
@Getter
public enum LendStatusEnum {
//    1发布中  2部分出借  3全部出借
    IN_RELEASE(1,"发布中"),
    PARTIAL_LENDING(2,"部分出借"),
    ALL_LENDING(3,"全部出借")
    ;

    private Integer code;

    private String message;

    LendStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
