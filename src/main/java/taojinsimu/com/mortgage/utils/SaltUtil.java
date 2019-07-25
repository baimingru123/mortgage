package taojinsimu.com.mortgage.utils;

/**
 * 生成盐工具类
 */
public class SaltUtil {

    /**
     * 生成随机盐值
     * @param length 生成的盐长度  大于16位为16位
     * @return
     */
    public static String getRandomSalt(int length) {
        String model = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        if(length>=16){
            length=16;
        }
        StringBuffer salt = new StringBuffer();
        char[] m = model.toCharArray();
        for (int i = 0; i < length; i++) {
            char c = m[(int) (Math.random() * 36)];
// 保证六位随机数之间没有重复的
// if (randomcode.contains(String.valueOf©)) {
// i–;
// continue;
// }
            salt = salt.append(c);
        }
        return salt.toString();
    }



}
