package chapter3;

/**
 * @Description:输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是按照递增排序的。
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年6月29日上午9:14:43
 */
public class MergeSortedLists {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null)
			return list2;
		else if(list2 == null)
			return list1;
		
		ListNode mergeHead = null;
		if(list1.val < list2.val){
			mergeHead = list1;
			mergeHead.next = Merge(list1.next,list2);
		}else{
			mergeHead = list2;
			mergeHead.next = Merge(list1,list2.next);
		}
		return mergeHead;
    }
	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
}
