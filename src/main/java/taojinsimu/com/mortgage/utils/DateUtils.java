package taojinsimu.com.mortgage.utils;

import taojinsimu.com.mortgage.constant.DatePatternCons;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bmr
 * @time 2019-07-26 9:38
 */
public class DateUtils {



    /**
     * 获取当前时间
     */
    public static String getCurrentTime(){
        SimpleDateFormat sdf=new SimpleDateFormat(DatePatternCons.Y_M_D_HMS);
        return sdf.format(new Date());
    }
}
