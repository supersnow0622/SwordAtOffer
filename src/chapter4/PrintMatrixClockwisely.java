package chapter4;

import java.util.ArrayList;


/**
 * @Description:面试题20：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序一次打印出每一个数字
 * @author:王丽雪
 * @time:2016年12月28日下午1:04:44
 */
public class PrintMatrixClockwisely {
	 public static  ArrayList<Integer> printMatrix(int [][] matrix) {
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 printN(matrix,1,list);
		 for(int i = 0; i < list.size();i++)
			 System.out.println(list.get(i));
		 return list;
	 }
	 
	 public static  void printN(int [][] matrix,int n,ArrayList<Integer> list){
		 int row = matrix.length;
		 int col = matrix[0].length;
		 
		 int startR = n - 1,endR = row - n;
		 int startC = n - 1,endC = col - n;
		 
		 if(startR == endR){
			 for(int j = startC; j <= endC; j++)
				 list.add(matrix[startR][j]);
			 return;
		 }
		 if(startC == endC){
			 for(int i = startR; i <= endR; i++)
				 list.add(matrix[i][startC]);
			 return;
		 }
			 
		 for(int j = startC; j <= endC; j++){
			 list.add(matrix[startR][j]);
		 }
		 for(int i = startR + 1; i <= endR; i++){
			 list.add(matrix[i][endC]);
		 }
		 for(int j = endC - 1; j >= startC; j--){
			 list.add(matrix[endR][j]);
		 }
		 for(int i = endR - 1; i > startR; i--){
			 list.add(matrix[i][startC]);
		 }
		 int circle = row < col ? row : col;
		 circle = (circle + 1) /2;
		 if(n+1 <= circle)
			 printN(matrix,n+1,list);
	 }
	 public static void main(String args[]){
		 int [][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},{26,27,28,29,30},};
		// int [][] matrix = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};
		// int [][] matrix = new int[][]{{1,2,3,4,5}};
		// int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		 printMatrix(matrix);
	 }
}
