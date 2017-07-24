package chapter7;


/**
 * @Description:把字符串转换为整数，字符串为0或包含字母输出0
 * @author:王丽雪
 * @time:2017年1月13日上午10:49:37
 */
public class StringToInt {
	public static int StrToInt(String str) {
        if(str.equals("0") || str.equals(""))
        	return 0;
        int sum = 0;
        boolean isNegtive = false;
        for(int i = 0; i < str.length(); i++){
        	char ch = str.charAt(i);
        	if(ch > '0' && ch < '9'){
        		sum = sum * 10 + (ch - '0');
        	}else if(ch == '-'){
        		if(i == 0)
        			isNegtive = true;
        		else
        			return 0;
        	}else if(ch == '+'){
        		if(i == 0)
        			isNegtive = false;
        		else
        			return 0;
        	}else{
        		return 0;
        	}
        }
        if(isNegtive)
        	return -sum;
        return sum;
    }
	public static void main(String args[]){
		System.out.println(StringToInt.StrToInt(" "));
	}
}
