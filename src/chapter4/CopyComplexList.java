package chapter4;


/**
 * @Description:������26����������ĸ���
 * ��Ŀ����ʵ�ֺ���RandomListNode Clone(RandomListNode pHead),����һ�����������ڸ��������У�ÿ����������һ��
 * nextָ��ָ����һ������⣬����һ��randomָ�������е����������null��
 * @author:����ѩ
 * @time:2016��12��28������8:13:56
 */
public class CopyComplexList {
	public RandomListNode Clone(RandomListNode pHead){
		CloneNode(pHead);
		ConnectSiblingNodes(pHead);
		return ReconnectNodes(pHead);
    }
	//����֮��ΪA->A'->B->B'->C->C'->D->D'->E->E'
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
