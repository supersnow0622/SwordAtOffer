package chapter6;

/**����
 * @Description:������40��������ֻ����һ�ε�����
 * ��Ŀ��һ�����������������������֮�⣬���������ֶ����������Ρ����ҳ�������ֻ����һ�ε����֡�
 * Ҫ��ʱ�临�Ӷ���O(n),�ռ临�Ӷ���O(1)
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��1��9������7:53:52
 */
public class NumbersAppearOnce {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = array[0];
		for(int i = 1 ; i < array.length; i++){
        	a = a ^ array[i];
        }
		int index = findFirst1InNum(a);
		for(int i = 0; i < array.length; i++){
			if(isOneInPositionN(array[i], index) == 1)
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
    }
	//�ҳ�һ�����Ķ������е�һ��1��λ��
	public int findFirst1InNum(int num){
		int index = 0;
		while(num != 0){
			if(num % 2 != 0)
				return index;
			num /= 2;
			index++;
		}
		return -1;
	}
	//�ж�һ�����Ķ����Ƶ�NΪ�Ƿ�Ϊ1
	public int isOneInPositionN(int num,int n){
		num = num >> n;
		return (num & 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumbersAppearOnce n = new NumbersAppearOnce();
		int num1[] = new int[1];
		int num2[] = new int[1];
		int[] array = new int[]{2,4,3,6,3,2,5,5};
		n.FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + "  " + num2[0]);
	}

}
