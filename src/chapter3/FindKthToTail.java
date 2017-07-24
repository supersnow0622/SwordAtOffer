package chapter3;

/**
 * @Description:面试题15：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点
 * @author:王丽雪
 * @time:2016年12月26日下午9:19:28
 */
public class FindKthToTail {
	//遍历两次链表
	public ListNode findKthToTail1(ListNode head,int k) {
		ListNode list = head;
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		int n = count - k;
		if(count < k)
			return null;
		count = 0 ;
		while(list != null && count < n){
			count++;
			list = list.next;
		}
		System.out.println(list.val);
		return list;
    }
	//遍历一次链表
	public ListNode findKthToTail(ListNode head,int k) {
		if(head == null || k == 0)
			return null;
		int p1 = 0;
		ListNode node1 = head;
		ListNode node2 = head;
		while(p1 != k - 1){
			node1 = node1.next;
			if(node1 == null)
				return null;
			p1++;
		}
		while(node1.next != null){
			node1 = node1.next;
			node2 = node2.next;
		}
		return node2;
	}
	
	public static void main(String args[]){
		FindKthToTail f = new FindKthToTail();
		
		ListNode node7 = new ListNode(7);
		node7.next = null;
		ListNode node6 = new ListNode(6);
		node6.next = node7;
		ListNode node5 = new ListNode(5);
		node5.next = node6;
		ListNode node4 = new ListNode(4);
		node4.next = node5;
		ListNode node3 = new ListNode(3);
		node3.next = node4;
		ListNode node2 = new ListNode(2);
		node2.next = node3;
		ListNode head = new ListNode(1);
		head.next = node2;
		
		
		f.findKthToTail(head, 3);
	}
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}