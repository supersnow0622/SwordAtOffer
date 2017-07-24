package chapter8;

/**
 * @Description:面试题52：构建乘积数组
 * 题目:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i]*...*A[n-1]
 * 不能使用除法
 * @author:王丽雪
 * @time:2017年1月13日下午3:10:32
 */
public class ArrayConstruction {
	public static int[] multiply(int[] A) {
		if(A == null)
			return null;
		int len = A.length;
		int B[] = new int[len];
		if(len == 0)
			return B;
		int C[] = new int[len];
		int D[] = new int[len];
		C[0] = A[0];D[len-1] = A[len-1];
		for(int i = 1; i < len; i++)
			C[i] = C[i - 1] * A[i];
		for(int i = len - 2; i >= 0; i--)
			D[i] = D[i + 1] * A[i];
		
		B[0] = D[1];B[len - 1] = C[len - 2];
		for(int i = 1; i < len-1; i++)
			B[i] = C[i - 1] * D[i + 1];
		return B;
    }
	public static void main(String args[]){
		int B[] = ArrayConstruction.multiply(new int[]{1,2,3,4,5});
		for(int i = 0;i < B.length; i++)
			System.out.print(B[i] +" ");
			
	}
}
