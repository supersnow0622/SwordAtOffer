package chapter6;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description:面试题39：二叉树的深度
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年1月4日下午2:33:21
 */
public class TreeDepth {
	//递归求解
	public int treeDepth1(TreeNode root) {
        if(root == null)
        	return 0;
        int left = treeDepth1(root.left) + 1;
        int	right = treeDepth1(root.right) + 1;
        return left > right ? left : right;
    }
	//非递归层次遍历求解
	public static  int treeDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		int count = 0;
		int visitedNumber = 0;
		int enQueueNumber = 1;
		int lastLevelNumber = 1;
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			visitedNumber++;
			if(node.left != null){
				queue.add(node.left);
				enQueueNumber++;
			}
			if(node.right != null){
				queue.add(node.right);
				enQueueNumber++;
			}
			if(visitedNumber == lastLevelNumber){
				count++;
				lastLevelNumber = enQueueNumber;
			}
		}
		return count;
	}
	public static void main(String args[]){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		
		node4.left = node7;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node1.left = node2;
		node1.right = node3;
		
		System.out.println(treeDepth(node7));
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