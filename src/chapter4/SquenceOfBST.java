package chapter4;


/**五星
 * @Description:面试题24：二叉搜索书的后序遍历序列
 * 题目:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同
 * @author:王丽雪
 * @time:2016年12月28日下午4:17:34
 */
public class SquenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null || sequence.length == 0)
			return false;
		int end = sequence.length - 1;
        return this.verify(sequence, 0, end);       
    }
	public boolean verify(int [] sequence,int start,int end){
		int root = sequence[end];
		int i = start;
		while(i < end){
			if(sequence[i] < root)
				i++;
			else if(sequence[i] > root)
				break;
		}
		if(i == end)
			return true;
		int mid = i - 1;
		while(i < end){
			if(sequence[i] > root)
				i++;
			else if(sequence[i] < root)
				return false;
		}
		if(mid < 0)
			return verify(sequence,start,end - 1);
		return verify(sequence,start,mid) && verify(sequence,mid + 1,end - 1);
	}
	
	public static void main(String args[]){
		SquenceOfBST s = new SquenceOfBST();
		int[] sequence = new int[]{5,7,6,9,11,10,8};
		System.out.println(s.VerifySquenceOfBST(sequence));
	}
}
