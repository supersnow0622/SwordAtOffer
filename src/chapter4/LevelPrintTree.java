package chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Description:������23���������´�ӡ������
 * ��Ŀ���������´�ӡ����������ÿ����㣬ͬһ��Ľ�㰴�մ����ҵ�˳���ӡ����������ͼ4.5�еĶ�������
 * �����δ�ӡ��8,6,10,5,7,9,11
 * @author:����ѩ
 * @time:2016��12��28������4:15:14
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
