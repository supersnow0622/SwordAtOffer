package chapter3;

/**
 * @Description:������11��ʵ�ֺ���double Power(double base,int exponent),��base��exponent�η���
 * ����ʹ�ÿ⺯��������Ҫ���Ǵ�������
 * @author:����ѩ
 * @time:2016��12��26������6:43:10
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
