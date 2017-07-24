package chapter5;

import java.util.ArrayList;

/**
 * @Description:面试题30：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2016年12月29日下午7:39:32
 */
public class KLeastNumbers {
	//基于快速排序的思路
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k == 0 || input.length == 0 || k > input.length ){
			return list;
		}
		int start = 0; 
        int end = input.length - 1;
        int index = this.Partition(input, start, end);
        while(index != k - 1){
        	if(index > k -1){
        		index = this.Partition(input, start, index - 1);
        	}else{
        		index = this.Partition(input, index + 1, end);
        	}
        }
        for(int i = 0; i < k; i++)
        	list.add(input[i]);
        return list;
    }
	public int Partition(int [] input,int start,int end){
		
		int target = input[start];
		int l = start,h = end;
		while(l < h){
			while(input[h] > target && l < h){
				h--;
			}
			input[l] = input[h];
			while(input[l] < target && l < h){
				l++;
			}
			input[h] = input[l];
		}
		input[h] = target;
		return h;
	}
	
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(input == null || k == 0 || input.length == 0 || k > input.length ){
			return list;
		}
		for(int i = 0; i < k ; i++)
			list.add(input[i]);
		for(int i = k; i < input.length; i++){
			int max = this.getMax(list);
			if(input[i] < list.get(max))
				list.set(max, input[i]);
		}
		return list;
	}
	
	public int getMax(ArrayList<Integer> list){
		int max = list.get(0);
		int j = 0;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > max){
				max = list.get(i);
				j = i;
			}
		}
		return j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KLeastNumbers k = new KLeastNumbers();
		ArrayList<Integer> list = k.GetLeastNumbers_Solution2(new int[]{4,5,1,6,2,7,3,8},1);
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

}
