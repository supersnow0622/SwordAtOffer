package chapter2;
/**
 * @Description:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二位数组和一个整数，判断数组中是否含有该整数
 * @author:王丽雪
 * @time:2016年12月19日下午8:10:54
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
