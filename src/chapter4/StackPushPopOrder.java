package chapter4;

import java.util.Stack;

/**
 * @Description:������22��ջ��ѹ�롢��������
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־����ȡ�
 * ���磺����1,2,3,4,5��ĳջ��ѹջ���У�����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�
 * ѹջ���еĵ������С�
 * @author:����ѩ
 * @time:2016��12��28������4:11:20
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
