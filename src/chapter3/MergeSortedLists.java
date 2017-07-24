package chapter3;

/**
 * @Description:����������������������ϲ�����������ʹ�������еĽڵ���Ȼ�ǰ��յ�������ġ�
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��6��29������9:14:43
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
