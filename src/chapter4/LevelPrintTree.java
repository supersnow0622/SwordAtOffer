package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Description:面试题23：从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。例如输入图4.5中的二叉树，
 * 则依次打印出8,6,10,5,7,9,11
 * @author:王丽雪
 * @time:2016年12月28日下午4:15:14
 */
public class LevelPrintTree {
	public static  ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root != null){
	        queue.add(root);
	        while(!queue.isEmpty()){
	        	TreeNode node = queue.poll();
	        	list.add(node.val);
	        	if(node.left != null)
	        		queue.add(node.left);
	        	if(node.right != null)
	        		queue.add(node.right);
	        }
        }
        return list;
    }

	public static void main(String args[]){
		ArrayList<Integer> list = PrintFromTopToBottom(null);
		System.out.println(list);
	}
}
