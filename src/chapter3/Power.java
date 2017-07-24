package chapter3;

/**
 * @Description:面试题11：实现函数double Power(double base,int exponent),求base的exponent次方。
 * 不得使用库函数，不需要考虑大数问题
 * @author:王丽雪
 * @time:2016年12月26日下午6:43:10
 */
public class Power {
	public static double power(double base,int exponent){
		int ex = exponent;
		if(exponent < 0){
			ex = -exponent;
		}
		double result = powerWithUnsignedExponent(base, ex);
		if(exponent < 0){
			return 1/result;
		}
		return result;
	}
	public static double powerWithUnsignedExponent(double base,int exponent){
		if(exponent == 0)
			return 1;
		if(exponent == 1)
			return base;
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *= base;
		}
		return result;
	}
	public static void main(String args[]){
		System.out.println(power(2,-3));
	}
}
