package taojinsimu.com.mortgage.utils;

import java.security.MessageDigest;

public class MD5Util {

    /**
     * 将字符串进行md5摘要
     * @return
     */
    public static String getMD5(String str){
        StringBuilder result=new StringBuilder();
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(str.getBytes("UTF8"));
            byte s[] = m.digest();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result.toString();

    }



}
