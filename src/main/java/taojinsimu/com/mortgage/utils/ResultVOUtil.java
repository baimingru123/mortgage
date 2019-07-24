package taojinsimu.com.mortgage.utils;


import taojinsimu.com.mortgage.enums.ResultEnum;
import taojinsimu.com.mortgage.vo.ResultVO;

/**
 * @author bmr
 * @time 2019-01-11 16:15
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }


    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(int code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO returnEnums(ResultEnum enums){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(enums.getCode());
        resultVO.setMsg(enums.getMsg());
        return resultVO;
    }


}
