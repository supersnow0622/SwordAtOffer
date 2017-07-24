package chapter8;

/**
 * @Description:������59���ԳƵĶ�����
 * ��Ŀ����ʵ��һ�������������ж�һ�ö������ǲ��ǶԳƵġ����һ�ö����������ľ���һ������ô�����ǶԳƵġ�
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��1��16������4:21:52
 */
public class SymmetricalBinaryTree {
	public boolean isSymmetrical(TreeNode pRoot)
    {
		if(pRoot == null || (pRoot.left == null && pRoot.right == null))
			return true;
		
		return isMirror(pRoot.left,pRoot.right);
    }
	public boolean isMirror(TreeNode pRoot1,TreeNode pRoot2){
		if(pRoot1 == null && pRoot2 == null)
			return true;
		if(pRoot1 == null || pRoot2 == null)
			return false;
		if(pRoot1.val != pRoot2.val)
			return false;
		return isMirror(pRoot1.left,pRoot2.right) && isMirror(pRoot1.right, pRoot2.left);
	}
	public static void main(String args[]){
		TreeNode node8 = new TreeNode(8);
		TreeNode node61 = new TreeNode(6);
		TreeNode node62 = new TreeNode(6);
		TreeNode node51 = new TreeNode(5);
		TreeNode node52 = new TreeNode(5);
		TreeNode node71 = new TreeNode(7);
		TreeNode node72 = new TreeNode(7);
		
		node8.left = node61;
		node8.right = node62;
		node61.left = node51;
		node61.right = node71;
		node62.left = node72;
		node62.right = node52;
		
		SymmetricalBinaryTree s = new SymmetricalBinaryTree();
		System.out.println(s.isSymmetrical(node8));
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