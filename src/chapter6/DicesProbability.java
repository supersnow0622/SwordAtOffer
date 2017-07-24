package chapter6;

/**����
 * @Description:������43:n�����ӵĵ���
 * ��Ŀ����n���������ڵ��ϣ����е����ӳ���һ��ĵ���֮��Ϊs������n����ӡ��s�����п��ܵ�ֵ���ֵĸ���
 * @author:����ѩ
 * @time:2017��1��13������10:10:53
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
