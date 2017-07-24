package chapter4;


/**
 * @Description:面试题26：复杂链表的复制
 * 题目：请实现函数RandomListNode Clone(RandomListNode pHead),复制一个复杂链表。在复杂链表中，每个结点除了有一个
 * next指针指向下一个结点外，还有一个random指向链表中的任意结点或者null。
 * @author:王丽雪
 * @time:2016年12月28日下午8:13:56
 */
public class CopyComplexList {
	public RandomListNode Clone(RandomListNode pHead){
		CloneNode(pHead);
		ConnectSiblingNodes(pHead);
		return ReconnectNodes(pHead);
    }
	//复制之后为A->A'->B->B'->C->C'->D->D'->E->E'
	public void CloneNode(RandomListNode pHead){
		RandomListNode pNode = pHead;
		while(pNode != null){
			RandomListNode node = new RandomListNode(pNode.label);
			node.next = pNode.next;
			pNode.next = node;
			pNode = node.next;
		}
	}
	//
	public void ConnectSiblingNodes(RandomListNode pHead){
		RandomListNode pNode = pHead;
		while(pNode != null){
			if(pNode.random != null)
				pNode.next.random = pNode.random.next;
			pNode = pNode.next.next;
		}
	}
	
	public RandomListNode ReconnectNodes(RandomListNode pHead) {
		RandomListNode newRandomList = null;
		RandomListNode head = null;
		boolean isFirst = true;
		while(pHead != null){
			if(isFirst){
				newRandomList = pHead.next;
				isFirst = false;
				head = newRandomList;
			}else{
				newRandomList.next = pHead.next;
				newRandomList = newRandomList.next;
			}
			pHead.next = pHead.next.next;
			pHead = pHead.next;
		}
		return head;
	}
	
	class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
}
