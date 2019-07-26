package taojinsimu.com.mortgage.utils;

/**
 * @author bmr
 * @time 2019-07-26 8:36
 */
public class ConvertUtils {

    /**
     * 将姓名进行脱敏处理
     * 方式：只展示第一个字，后面用*代替
     * @return
     */
    public static String name2hidden(String str){

        if(str==null){
            return null;
        }

        str=str.trim();
        if(str.length()<=1 ){
            return str;
        }

        str=str.substring(0,1)+"**";
        return str;
    }

    public static void main(String[] args) {
        String a="张啊啊a";
        String s=name2hidden(a);
        System.out.println(s);
    }
}
