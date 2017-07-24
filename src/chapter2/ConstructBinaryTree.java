package chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:����ǰ����������й��������
 * @author:����ѩ
 * @time:2017��5��23������9:38:47
 */
public class ConstructBinaryTree {
	public static void levelOrder(BinaryTreeNode root){
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			System.out.print(node.value);
			if(node.left != null){
				queue.add(node.left);
				System.out.print(" ���ӣ�" + node.left.value);
			}else{
				System.out.print(" ���ӣ���  ");
			}
			if(node.right != null){
				queue.add(node.right);
				System.out.print("  �Һ��ӣ� " + node.right.value);
			}else{
				System.out.print("  �Һ��ӣ���");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int length = 7;
		int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
		int[] inOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
		try {
			ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
			TreeNode root = constructBinaryTree.reConstructBinaryTree(preOrder, inOrder);
			System.out.println();
//			levelOrder(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre == null || in == null || pre.length != in.length)
			return null;
        return Construct(pre,0,pre.length-1,in,0,in.length-1);
    }
	
	public TreeNode Construct(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd){
		TreeNode rootNode = new TreeNode(pre[preStart]);
		int mid = inStart;
		for(int i = inStart; i <= inEnd; i++){
			if(in[i] == pre[preStart]){
				mid = i;
				break;
			}
		}
		int leftlen = mid - inStart;
		int rightlen = inEnd - mid;
		if(leftlen > 0){
			rootNode.left = Construct(pre, preStart+1, preStart+leftlen, in, inStart, mid-1);
		}
		if(rightlen > 0){
			rootNode.right = Construct(pre, preStart+1+leftlen, preEnd, in, mid+1, inEnd);
		}
			
		return rootNode;
	}
	
	static class TreeNode{
		public int value;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val){
			this.value = val;
		}
	}
}
class BinaryTreeNode{
	public int value;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
}