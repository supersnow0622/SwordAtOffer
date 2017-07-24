package chapter2;

public class Fibonacci {
	public static int Fibonacci(int n) {
		int[] array = new int[10000];
		array[1] = 1;
		array[2] = 2;
		for(int i = 3; i <= n; i++){
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];
    }
	public static void main(){
		
	}
}
