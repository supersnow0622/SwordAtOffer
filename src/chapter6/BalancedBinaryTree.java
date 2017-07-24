package chapter6;

/**
 * @Description:面试题39-2：判断一棵树是不是二叉平衡树
 * @author:王丽雪
 * @time:2017年1月4日下午3:20:45
 */
public class BalancedBinaryTree {

	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null)
			return true;
		int left = treeDepth1(root.left);
		int right = treeDepth1(root.right);
		int diff = left - right;
		if(diff > 1 || diff < -1)
			return false;
		return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
	public int treeDepth1(TreeNode root) {
		if(root == null)
	        return 0;
	    int left = treeDepth1(root.left) + 1;
	    int right = treeDepth1(root.right) + 1;
	        return left > right ? left : right;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node5.left = node7;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node1.left = node2;
		node1.right = node3;
		BalancedBinaryTree b = new BalancedBinaryTree();
		System.out.println(b.IsBalanced_Solution(node1));
	}

}
