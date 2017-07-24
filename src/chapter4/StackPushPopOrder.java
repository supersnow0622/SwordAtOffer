package chapter4;

import java.util.Stack;

/**
 * @Description:面试题22：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不等。
 * 例如：序列1,2,3,4,5是某栈的压栈序列，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该
 * 压栈序列的弹出序列。
 * @author:王丽雪
 * @time:2016年12月28日下午4:11:20
 */
public class StackPushPopOrder {
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		int popCount = 0;
		int pushCount = 0;
		int length = pushA.length;
		Stack<Integer> stack = new Stack<Integer>();
		while(pushCount < length){	
			if(!stack.isEmpty() && stack.peek() == popA[popCount]){
				stack.pop();
				popCount++;
			}else{
				stack.push(pushA[pushCount++]);
			}
			if(pushCount == length){
				while(!stack.isEmpty() && popCount < length){
					if(stack.peek() == popA[popCount]){
						stack.pop();
						popCount++;
					}else{
						return false;
					}
				}
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
    }
	
	public static void main(String args[]){
		int [] pushA = new int[]{1};
		int [] popA = new int[]{2};
		System.out.println(IsPopOrder(pushA,popA));
	}
}
