package taojinsimu.com.mortgage.exception;

import lombok.Getter;

@Getter
public class MortgagePageException extends RuntimeException {


    public MortgagePageException( String msg){
        super(msg);
    }
}
