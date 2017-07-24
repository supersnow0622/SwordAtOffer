package chapter8;

import java.util.ArrayList;

/**
 * @Description:������63�������������ĵ�k�����
 * ��Ŀ������һ�Ŷ��������������ҳ����еĵ�k����Ľ�㡣
 * @author:����ѩ
 * @time:2017��1��5������2:59:00
 */
public class KthNodeInBST {
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	TreeNode KthNode(TreeNode pRoot, int k)
    {
	   if(k <= 0 || pRoot == null)
		   return null;
	   findKthNode(pRoot);
	   if(list.size() < k)
		   return null;
       return list.get(k-1);	   
    }
	public void findKthNode(TreeNode pRoot){
		if(pRoot.left != null)
			findKthNode(pRoot.left);
		list.add(pRoot);
		if(pRoot.right != null)
			findKthNode(pRoot.right);
	}
	public static void main(String args[]){
		TreeNode node5 = new TreeNode(5);
		TreeNode node3 = new TreeNode(3);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		
		node5.left = node3;
		node5.right = node7;
		node3.left = node2;
		node3.right = node4;
		node7.left = node6;
		node7.right = node8;
		KthNodeInBST k = new KthNodeInBST();
		TreeNode node = k.KthNode(node5,0);
	}
}
