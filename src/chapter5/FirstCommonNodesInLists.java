package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:面试题37：两个链表的第一个公共结点
 * 例如：1->2->3->6->7
 *        4->5->6->7   第一个公共结点为6     
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年1月3日下午1:58:59
 */
public class FirstCommonNodesInLists {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 int count1 = 0;
		 int count2 = 0;
		 ListNode p1 = pHead1,p2 = pHead2;
		 while(p1 != null){
			 count1++;
			 p1 = p1.next;
		 }
		 while(p2 != null){
			 count2++;
			 p2 = p2.next;
		 }
		 if(count1 == 0 || count2 == 0)
			 return null;
		 if(count1 > count2){
			 count1 = count1 - count2;
			 count2 = 0;
			 int count = 0;
			 while(count != count1){
				 pHead1 = pHead1.next;
				 count++;
			 }
		 }else if(count1 < count2){
			 count2 = count2 - count1;
			 count1 = 0;
			 int count = 0;
			 while(count != count2){
				 pHead2 = pHead2.next;
				 count++;
			 }
		 }
		 while(pHead1 != pHead2){
			 pHead1 = pHead1.next;
			 pHead2 = pHead2.next;
		 }
		 return pHead1;
    }
	public static void main(String[] args) {
		ListNode node7 = new ListNode(7);
		ListNode node6 = new ListNode(6);
		node6.next = node7;
		ListNode node5 = new ListNode(5);
		node5.next = node6;
		ListNode node4 = new ListNode(4);
		node4.next = node5;
		ListNode node3 = new ListNode(3);
		node3.next = node6;
		ListNode node2 = new ListNode(2);
		node2.next = node3;
		ListNode node1 = new ListNode(1);
		node1.next = node2;
		FirstCommonNodesInLists f = new FirstCommonNodesInLists();
		ListNode ll = f.FindFirstCommonNode(node1, node4);
		System.out.println(ll.val);
	}
	
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}