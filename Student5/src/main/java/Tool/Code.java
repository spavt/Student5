package Tool;

import java.util.Random;

public class Code {//生成验证码
    public static String  code()
    {
        String  res="";
        char[] str=new char[]{'1','2','3','4','5','6','7','8','9','a','A','b','B','C','c','D','d','n','N','k','K'};
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int anint =random.nextInt(21);
            res+=str[anint];
        }
        return res;//返回验证码
    }

}
