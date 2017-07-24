package chapter3;

/**
 * @Description:������ 18�������ӽṹ
 * ��Ŀ���������Ŷ�����A��B���ж�B�ǲ���A���ӽṹ����������B����A�����ӽṹ
 * 			8                8
 *		   / \              / \
 *		  8	  7            9   2
 *       / \
 *      9   2
 *         / \     
 *        4   7
 * @author:����ѩ
 * @time:2016��12��27������7:12:38
 */
public class HasSubtree {
	 public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		 boolean result = false;
		 if(root1 != null && root2 != null){
			 if(root1.val == root2.val)
				 result = DoesTree1HaveTree2(root1,root2);
			 if(!result)
				 result = DoesTree1HaveTree2(root1.left,root2);
			 if(!result)
				 result = DoesTree1HaveTree2(root1.right,root2);
		 }
		return result;
	}
	 
	 public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
		 if(root1 == null && root2 == null)
			 return true;
		 else if(root1 == null)
			 return false;
		 else if(root2 == null)
			 return true;
		 if(root1.val == root2.val)
			 return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
		 return false;
	 }
	 class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	 }
}
