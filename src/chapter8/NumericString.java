package chapter8;

/**
 * @Description:面试题54：表示数值的字符串
 * 题目:请实现一个函数用来判断字符串是表示数值（包含整数和小数）。例如，字符串"+100","5e2","-123","3.1416"及"-1E-16"
 * 都表示数值，但"12e","1a3.14","1.2.3","+-5","12e+5.4"都不是
 * @author:王丽雪
 * @time:2017年1月16日上午11:19:15
 */
public class NumericString {
	int index = 0;
    public boolean isNumeric(char[] str) {
    	int len = str.length;
	     if(str == null || str.length == 0)
	    	 return false;
	     if(str[index] == '+' || str[index] == '-')
	    	 index++;
	     if(index == len)
	    	 return false;
	     boolean isNumric = true;
	     scanDigits(str);
	     if(index != len){
	    	 if(str[index] == '.'){
	    		 index++;
	    		 scanDigits(str);
	    		 if(index != len){
		    		 if(str[index] == 'e' ||str[index] == 'E')
		    			 isNumric = isExponential(str);
	    		 }
	    	 }
	    	 else if(str[index] == 'e' || str[index] == 'E')
	    		 isNumric = isExponential(str);
	    	 else 
	    		 isNumric = false;
	     }
	     return isNumric && (index == len);
    }
    public void scanDigits(char[] str){
    	int len = str.length;
    	while(index != len && str[index] >= '0' && str[index] <= '9'){
    		index++;
    	}
    }
    public boolean isExponential(char[] str){
    	int len = str.length;
    	if(str[index] != 'e' && str[index] != 'E')
    		return false;
    	index++;
    	if(index != len && (str[index] == '+' || str[index] == '-'))
    		index++;
    	if(index == len)
    		return false;
    	scanDigits(str);
    	return (index == len);
    }
    public static void main(String args[]){
    	NumericString n = new NumericString();
    	String str = "12e";
    	System.out.println(n.isNumeric(str.toCharArray()));
    }
    
}
