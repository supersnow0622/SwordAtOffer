package chapter7;


/**
 * @Description:���ַ���ת��Ϊ�������ַ���Ϊ0�������ĸ���0
 * @author:����ѩ
 * @time:2017��1��13������10:49:37
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
