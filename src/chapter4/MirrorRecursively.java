package chapter4;


/**
 * @Description:面试题19：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，输出它的镜像，如下所示
 *            8                  8
 *           / \                / \
 *          6   10             10  6
 *         / \  / \           / \  / \
 *        5   7 9  11        11  9 7  5
 * @author:王丽雪
 * @time:2016年12月27日下午7:39:59
 */
public class MirrorRecursively {
	public static void Mirror(TreeNode root) {
		if(root == null)
			return;
        if(root.left != null || root.right != null){
        	TreeNode temp = root.left;
        	root.left = root.right;
        	root.right = temp;
        	if(root.left != null)
        		Mirror(root.left);
        	if(root.right != null)
        		Mirror(root.right);
        }
    }
	public static void main(String args[]){
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		node7.left = node5;
		TreeNode node9 = new TreeNode(9);
		node9.left = node7;
		TreeNode node11 = new TreeNode(11);
		node11.left = node9;
		TreeNode node6 = new TreeNode(6);
		node6.left = node11;
		//node6.right = node7;
		TreeNode node10 = new TreeNode(10);
		node10.left = node6;
		//node10.right = node11;
		
//		TreeNode node8 = new TreeNode(8);
//		node8.left = node6;
//		node8.right = node10;
		
		Mirror(null);
	}
	
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;

    }
}