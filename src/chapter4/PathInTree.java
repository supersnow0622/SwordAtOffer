package chapter4;

import java.util.ArrayList;

/**
 * @Description:面试题25：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的结点形成一条路径
 * @author:王丽雪
 * @time:2016年12月28日下午6:59:18
 */
public class PathInTree {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        this.printPath(root, path, list,target);
        
        return list;
    }
	
	
	public void printPath(TreeNode root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> list,int target){
		if(root == null)
			return ;
		path.add(root.val);
		if(root.left == null && root.right == null){
			@SuppressWarnings("unchecked")
			ArrayList<Integer> p = (ArrayList<Integer>) path.clone();
			int sum = 0;
			for(int i = 0 ;i < p.size(); i++){
				sum += p.get(i);
			}
			if(sum == target)
				list.add(p);
		}else{
			printPath(root.left,path,list,target);
			printPath(root.right,path,list,target);
		}
		path.remove(Integer.valueOf(root.val));
	}
	public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        this.printPath1(root, path, list,target);
        
        return list;
    }
	
	
	public void printPath1(TreeNode root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> list,int target){
		if(root == null)
			return ;
		path.add(root.val);
		if(root.left == null && root.right == null){
			@SuppressWarnings("unchecked")
			ArrayList<Integer> p = (ArrayList<Integer>) path.clone();
			int sum = 0;
			for(int i = 0 ;i < p.size(); i++){
				sum += p.get(i);
			}
			if(sum == target)
				list.add(p);
		}else{
			printPath(root.left,path,list,target);
			printPath(root.right,path,list,target);
		}
		path.remove(Integer.valueOf(root.val));
	}
	
	public static void main(String args[]){
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		node5.left = node4;
		node5.right = node7;
		TreeNode node12 = new TreeNode(12);
		TreeNode node10 = new TreeNode(10);
		node10.left = node5;
		node10.right = node12;
		
		PathInTree pathInTree = new PathInTree();
		ArrayList<ArrayList<Integer>>  list = pathInTree.FindPath(null,0);
		for(ArrayList<Integer> path : list){
			for(Integer i : path){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
}
