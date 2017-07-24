package chapter6;

import java.util.ArrayList;

/**
 * @Description:������41����Ϊs����������,��Ϊs��������������
 * ��Ŀһ������һ����������������һ������s���������в�����������ʹ���ǵĺ�������s������ж�����ֵĺ�Ϊs���������һ�Լ��ɡ�
 * ��Ŀ��������һ������s����ӡ�����к�Ϊs�������������У����ٺ���������������������15�����
 * 1��2��3��4��5
 * 4��5��6
 * 7��8
 * @author:����ѩ
 * @time:2017��1��9������8:22:02
 */
public class TwoNumberWithSum {
	//��Ŀһ
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array == null || array.length == 0 || sum == 0)
			return list;
		int l = 0;
		int h = array.length - 1;
		int result = Integer.MAX_VALUE,x = array[l],y = array[h];
		while(l < h){
			if(array[l] + array[h] < sum)
				l++;
			else if(array[l] + array[h] > sum)
				h--;
			else{
				if(result > array[l] * array[h]){
					result = array[l] * array[h];
					x = array[l];
					y = array[h];
					
				}
				l++;
			}
		}
		if(x + y == sum){
			list.add(x);
			list.add(y);
		}
		return list;
    }

	//��Ŀ��
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int max = (1 + sum)/2;
		int l = 1;
		int h = 2;
		int curSum = l + h;
		while(l < h && h <= max ){
			if(curSum < sum){
				h++;
				curSum += h;
			}else if(curSum > sum){
				curSum -= l;
				l++;
			}else{
				ArrayList<Integer> item = new ArrayList<Integer>();
				for(int i = l; i <= h; i++)
					item.add(i);
				list.add(item);
				curSum -= l;
				l++;
			}
		}
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoNumberWithSum t = new TwoNumberWithSum();
//		ArrayList<ArrayList<Integer>> list = t.FindContinuousSequence(2);
//		for(int i = 0 ;i < list.size(); i++){
//			ArrayList<Integer> item = list.get(i);
//			for(int j = 0; j < item.size(); j++){
//				System.out.print(item.get(j) + " ");
//			}
//			System.out.println();
//		}
		ArrayList<Integer> list = t.FindNumbersWithSum(new int[]{}, 0);
		for(int j = 0; j < list.size(); j++){
			System.out.print(list.get(j) + " ");
		}
		
	}

}
