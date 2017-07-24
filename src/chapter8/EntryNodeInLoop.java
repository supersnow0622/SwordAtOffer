package chapter8;

/**
 * @Description:链表中环的入口结点
 * 一个链表中包含环，如何找出环的入口结点？
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月29日上午9:16:56
 */
public class EntryNodeInLoop {
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		if(pHead == null || pHead.next == null || pHead.next.next == null){
			return null;
		}
        ListNode p1 = pHead;
        ListNode p2 = pHead.next.next;
        while(p1 != p2){
        	p1 = p1.next;
        	p2 = p2.next.next;
        }
        ListNode p = p1;
        p1 = p1.next;
        int count = 1;
        while(p != p1){
        	count++;
        	p1 = p1.next;
        }
        int index = 0;
        p1 = pHead;
        p2 = pHead;
        while(index != count){
        	p2 = p2.next;
        	index++;
        }
        while(p1 != p2){
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return p1;
    }
	public static void main(String args[]){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		node1.next = node2;
		node2.next = node1;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = node8;
//		node8.next = node9;
//		node9.next = node4;
		EntryNodeInLoop e = new EntryNodeInLoop();
		System.out.println(e.EntryNodeOfLoop(node1).val);
		
	}
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
