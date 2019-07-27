package taojinsimu.com.mortgage.enums;

import lombok.Getter;

/**
 * @author bmr
 * @time 2019-07-27 9:30
 */
@Getter
public enum SelfExceptionType {
    NO_LOGIN_EXCEPTION("/login/user_login","未登录异常，跳转到登录页面"),
    COMMON_EXCEPTION("/common/error","程序中通用异常，例如空指针等异常，跳转到错误信息提示页面")
    ;

    private String returnUrl;

    private String message;

    SelfExceptionType(String returnUrl, String message) {
        this.returnUrl = returnUrl;
        this.message = message;
    }
}
