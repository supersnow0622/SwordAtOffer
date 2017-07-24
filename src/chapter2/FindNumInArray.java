package chapter2;
/**
 * @Description:��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����λ�����һ���������ж��������Ƿ��и�����
 * @author:����ѩ
 * @time:2016��12��19������8:10:54
 */
public class FindNumInArray {
	public static boolean find(int data,int[][] array,int row,int col){
		int i = 0, j = col - 1; 
		while(j >= 0 && i < row){
			if(array[i][j] == data){
				return true;
			}else if(array[i][j] > data){
				j--;
			}else {
				i++;
			}
		}
		return false;
	}
	public static void main(String args[]){
		int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(find(1,array,4,4));
	}
}
