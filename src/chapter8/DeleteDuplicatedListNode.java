package chapter8;

/**
 * @Description:������57��ɾ���������ظ��Ľڵ�
 * ��Ŀ����һ������������У����ɾ���ظ��Ľ�㣿���磺
 * 1->2->3->3->4->4->5ɾ��֮����
 * 1->2->5
 * @author:����ѩ
 * @time:2017��1��16������2:06:58
 */
public class DeleteDuplicatedListNode {
	public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead == null || pHead.next == null)
			return pHead;
		ListNode pre = null;
		ListNode cur = pHead;
		ListNode next = cur.next;
		while(cur != null && next != null){
			if(cur.val != next.val){
				pre = cur;
				cur = next;
				next = cur.next;
			}
			else if(cur.val == next.val){                             
				while(next != null && cur.val == next.val){
					while(next != null && cur.val == next.val){
						next = next.next;
					}
					cur = next;
					if(cur != null)
						next = cur.next;
				}
				if(pre != null)
					pre.next = cur;
				else{
					pre = cur;
					pHead = pre;
				}
				
			}
		}
		if(pre == null)
			return null;
		return pHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteDuplicatedListNode d = new DeleteDuplicatedListNode();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node31 = new ListNode(3);
		ListNode node32 = new ListNode(3);
		ListNode node33 = new ListNode(3);
//		ListNode node42 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
//		ListNode node6 = new ListNode(8);
//		ListNode node7 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node31;
		node31.next = node32;
		node32.next = node33;
//		node33.next = node42;
//		node42.next = node5;
		
		
		ListNode node = d.deleteDuplication(node31);
	}

}
