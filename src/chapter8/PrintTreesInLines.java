package chapter8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description:面试题61：按之字形顺序打印二叉树
 * 题目:请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再
 * 按照从左到右的顺序打印，其他行以此类推。
 * @author:王丽雪
 * @time:2017年1月17日上午9:32:47
 */
public class PrintTreesInLines {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		int cur = 0;
		int last = 0;
		int count = 0;
		if(pRoot != null){
	        queue.add(pRoot);	        
	        while(!queue.isEmpty()){
	        	last = queue.size();
	        	while(cur < last){
		        	TreeNode node = queue.poll();
		        	item.add(node.val);
		        	cur++;
		        	
		        	if(node.left != null)
		        		queue.add(node.left);
		        	
		        	if(node.right != null)
		        		queue.add(node.right);
	        	}
	        	if(count % 2 == 0)
	        		list.add(item);
	        	else{
	        		ArrayList<Integer> item1 = new ArrayList<Integer>();
	        		for(int i = item.size() - 1; i >= 0; i--)
	        			item1.add(item.get(i));
	        		list.add(item1);
	        	}
	        	count++;	
	        	cur = 0;
	        	item = new ArrayList<Integer>();
	        }
        }
		return list;
    }
	//从左到右打印二叉树的叶子节点
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    while(root != null || !stack.isEmpty()){
	       while(root != null){
	           stack.add(root);
	           root = root.left;
	           if(root != null && root.left == null && root.right == null)
	        	   list.add(root.val);
	       }
	           root = stack.pop();
	           root = root.right;
	           if(root != null && root.left == null && root.right == null)
	        	   list.add(root.val);
	       }
	    return list;
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
		TreeNode node8 = new TreeNode(8);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;
		PrintTreesInLines p = new PrintTreesInLines();
		ArrayList<Integer> list = p.preorderTraversal(node1);
		System.out.println(list);
		
//		TreeNode node8 = new TreeNode(8);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node10 = new TreeNode(10);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node7 = new TreeNode(7);
//		TreeNode node9 = new TreeNode(9);
//		TreeNode node11 = new TreeNode(11);
//		
//		node8.left = node6;
//		node8.right = node10;
//		node6.left = node5;
//		node6.right = node7;
//		node10.left = node9;
//		node10.right = node11;
//		PrintTreesInLines p = new PrintTreesInLines();
//		
//		ArrayList<ArrayList<Integer>> list = p.Print(node8);
//		for(int i = 0; i < list.size(); i++){
//			ArrayList<Integer> item = list.get(i);
//			for(int j = 0; j < item.size(); j++){
//				System.out.print(item.get(j) + " ");
//			}
//			System.out.println();
//		}
	}

}
