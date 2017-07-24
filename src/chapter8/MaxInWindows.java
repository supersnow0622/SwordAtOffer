package chapter8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class MaxInWindows {
	
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(num[0]);
        for(int i = 1; i < num.length; i++){
        	
        }
        return list;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
