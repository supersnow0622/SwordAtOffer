package chapter8;

/**
 * @Description:面试题58：二叉树的下一个结点
 * 题目：给定一颗二叉树和其中一个结点，如何找出中序遍历顺序的下一个结点？树种的结点除了有两个分别指向左右子结点的指针以外，还有一个
 * 指向父结点的指针。
 * @author:王丽雪
 * @time:2017年1月16日下午3:56:59
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