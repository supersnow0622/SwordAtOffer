package chapter2;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListReversingly {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		Stack<Integer> stack = new Stack<Integer>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
