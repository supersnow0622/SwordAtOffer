package chapter4;


/**����
 * @Description:������24������������ĺ����������
 * ��Ŀ:����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����������򷵻�true�����򷵻�false��
 * �������������������������ֶ�������ͬ
 * @author:����ѩ
 * @time:2016��12��28������4:17:34
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
