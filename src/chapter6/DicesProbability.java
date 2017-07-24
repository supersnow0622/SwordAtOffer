package chapter6;

/**五星
 * @Description:面试题43:n个骰子的点数
 * 题目：把n个骰子扔在地上，所有的骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率
 * @author:王丽雪
 * @time:2017年1月13日上午10:10:53
 */
public class DicesProbability {
	public void  PrintProbability(int number){
		if(number < 1)
			return;
		int array[][] = new int[2][6 * number];
		int flag = 0;
		for(int i = 1 ;i <= 6; i++){
			array[flag][i] = 1;
		}
		
		for(int k = 2; k <= number; k++){
			int i = 0;
			for(; i < k; i++)
				array[1-flag][i] = 0;
			for(; i <= 6 * k; i++){
				array[1-flag][i] = 0;
				for(int j = 1; j <= i && j <= 6; j++){
					array[1-flag][j] += array[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		double total = Math.pow(6, number);
		for(int i = number; i <= 6 * number; i++)
		{
			double ratio = (double)array[flag][i]/total;
			System.out.println(number +":"+ratio);
			
		}
	}
}
