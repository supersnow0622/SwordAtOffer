package chapter8;

/**
 * @Description:������58������������һ�����
 * ��Ŀ������һ�Ŷ�����������һ����㣬����ҳ��������˳�����һ����㣿���ֵĽ������������ֱ�ָ�������ӽ���ָ�����⣬����һ��
 * ָ�򸸽���ָ�롣
 * @author:����ѩ
 * @time:2017��1��16������3:56:59
 */
public class NextNodeInBinaryTrees {
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
        	TreeLinkNode node = pNode.right;
        	while(node.left != null){
        		node = node.left;
        	}
        	return node;
        }else {
        	TreeLinkNode parent = pNode.next;
        	if(parent != null && parent.left == pNode)
        		return parent;
        	else{
        		
        		TreeLinkNode cur = pNode;
        		while(parent!= null && parent.right == cur){
        			cur = parent;
        			parent = parent.next;
        		}
        		if(parent != null && parent.left == cur)
        			return parent;
        		return null;
        	}
        }	
    }
	public static void main(String args[]){
		TreeLinkNode node1 = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
//		TreeLinkNode node6 = new TreeLinkNode(6);
//		TreeLinkNode node7 = new TreeLinkNode(7);
//		TreeLinkNode node8 = new TreeLinkNode(8);
//		TreeLinkNode node9 = new TreeLinkNode(9);
		
		node5.left = node4;
		node4.left = node3;
		node3.left = node2;
		
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		NextNodeInBinaryTrees n = new NextNodeInBinaryTrees();
		System.out.println(n.GetNext(node5).val);
	}
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}