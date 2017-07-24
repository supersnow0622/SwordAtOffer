package chapter8;

/**
 * @Description:������55���ַ����е�һ�����ظ����ַ�
 * ��Ŀ����ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬���ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���'g'��
 * ���Ӹ��ַ����ж���ǰ6���ַ�"google"ʱ����һ��ֻ����һ�ε��ַ���'l'�������ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���
 * @author:����ѩ
 * @time:2017��1��16������11:22:50
 */
public class FirstCharacterInStream {
    int count[] = new int[256];
	int index = 1;
	public void Insert(char ch)
    {
        if(count[ch] == 0)
        	count[ch] = index++;
        else
        	count[ch] = -1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	char ch = '#';
    	int temp = Integer.MAX_VALUE;
    	for(int i = 0; i < 256; i++){
    		if(count[i] != -1 && count[i] != 0 && count[i] < temp){
    			temp = count[i];
    			ch = (char)i;
    		}
    	}
    	return ch;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstCharacterInStream f = new FirstCharacterInStream();
		String str = "BabyBaby";
		for(int i = 0; i < str.length(); i++){
			f.Insert(str.charAt(i));
			System.out.println(f.FirstAppearingOnce());
		}
	}

}
