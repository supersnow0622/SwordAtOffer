package chapter4;

/**五星
 * @Description:面试题27：二叉搜索树和双向链表
 * 题目：输入一颗二叉搜索树，将该二叉搜索树转化成一个排序的双向链表，要求不能创建任何新的结点，只能调整树中结点指针的指向。比如：
 * 			 10
 * 			 / \
 * 			6   14     转化为双向链表 4-->6-->8-->10-->12-->14-->16
 *         / \  / \           4<--6<--8<--10<--12<--14<--16
 *        4  8 12 16
 * @author:王丽雪
 * @time:2016年12月29日上午11:49:46
 */
public class ConvertBinarySearchTree {
	static TreeNode last = null;
	public TreeNode convertBinarySearchTree(TreeNode pRootOfTree) {
		if(pRootOfTree == null)
			return null;
		last = null;
		ConvertTree(pRootOfTree);
		
		TreeNode head = last;
		while(head != null && head.left != null)
			head = head.left;
        return head;
    }
	
	public void ConvertTree(TreeNode root){
		if(root == null)
			return ;
		TreeNode cur = root;
		
		if(cur.left != null)
			ConvertTree(cur.left);
		
		cur.left = last;
		if(last != null)
			last.right = cur;
		last = cur;
		
		if(cur.right != null)
			ConvertTree(cur.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertBinarySearchTree c = new ConvertBinarySearchTree();
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		node6.left = node4;
		node6.right = node8;
		TreeNode node12 = new TreeNode(12);
		TreeNode node16 = new TreeNode(16);
		TreeNode node14 = new TreeNode(14);
		node14.left = node12;
		node14.right = node16;
		TreeNode root = new TreeNode(10);
		root.left = node6;
		root.right = node14;
		
		
		TreeNode node = c.convertBinarySearchTree(root);
		while(node != null){
			System.out.print(node.val);
			node = node.right;
		}
	}

}
