package taojinsimu.com.mortgage.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import taojinsimu.com.mortgage.enums.SelfExceptionType;
import taojinsimu.com.mortgage.exception.MortgagePageException;

/**
 * 处理抛出的自定义的异常
 */
@ControllerAdvice
public class MortgageExceptionHandler {

    @ExceptionHandler(value = MortgagePageException.class)
    public ModelAndView handlerPageException(MortgagePageException e){
       String viewName=e.getExceptionType().getReturnUrl();
        ModelAndView mv=new ModelAndView(viewName);
        mv.addObject("message",e.getMessage());
        return mv;
    }
}
