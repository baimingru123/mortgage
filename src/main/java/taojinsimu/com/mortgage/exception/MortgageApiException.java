package taojinsimu.com.mortgage.exception;

import lombok.Getter;
import taojinsimu.com.mortgage.enums.ResultEnum;

@Getter
public class MortgageApiException extends RuntimeException {

    private Integer code;

    public MortgageApiException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public MortgageApiException(Integer code, String msg){
        super(msg);
        this.code=code;
    }
}
