package chapter3;


/**
 * @Description:������16����ת����
 * ��Ŀ:����һ������������һ�������ͷ��㣬��ת�����������ת�������ͷ���
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2016��12��27������4:19:41
 */
public class ReverseList {
	//ͷ�巨���ռ临�Ӷ�O(n)
	public ListNode reverseList1(ListNode head) {
		if(head == null)
			return null;
		ListNode list = null;
		boolean isFirst = true;
		while(head!= null){
			if(isFirst){
				isFirst = false;
				list = new ListNode(head.val);
				list.next = null;
			}
			else{
				ListNode node = new ListNode(head.val);
				node.next = list;
				list = node;
			}
			head = head.next;
		}
		return list;
    }
	//���������ڵ�����ʱ���棬�ռ临�Ӷ�O(1)
	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy ,cur = head;
		while(cur != null && cur.next != null){
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		return dummy.next;
    }
	
	public static void main(String args[]){
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
		
		ReverseList rl = new ReverseList();
		ListNode node = rl.reverseList(head);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}