package chapter6;

import java.util.ArrayList;

/**����
 * @Description:������45��ԲȦ�����ʣ�µ�����
 * ��Ŀ��0,1,...,n-1��n�������ų�һ��ԲȦ��������0��ʼÿ�δ����ԲȦ��ɾ����m�����֡�������ԲȦ�����ʣ�µ����֡�
 * @author:����ѩ
 * @time:2017��1��13������10:18:41
 */
public class LastNumberInCircle {
	public static int LastRemaining_Solution(int n, int m) {
		if(n < 1 || m < 1)
			return -1;
		int last = 0;
		for(int i = 1; i <= n; i++){
			last = (last + m) % i;
			System.out.println(last+1);
		}
        return last;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastNumberInCircle.LastRemaining_Solution(7,2);
	}

}
