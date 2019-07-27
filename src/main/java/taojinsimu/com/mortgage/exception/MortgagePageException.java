package taojinsimu.com.mortgage.exception;

import lombok.Getter;
import taojinsimu.com.mortgage.enums.SelfExceptionType;

@Getter
public class MortgagePageException extends RuntimeException {

    private SelfExceptionType exceptionType=SelfExceptionType.COMMON_EXCEPTION;

    public MortgagePageException( String msg){
        super(msg);
    }

    public MortgagePageException( SelfExceptionType type){
        this.exceptionType=type;
    }


}
