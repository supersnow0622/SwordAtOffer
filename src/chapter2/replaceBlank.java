package chapter2;


/**
 * @Description:��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author:����ѩ
 * @time:2017��7��20������3:28:50
 */
public class replaceBlank {
	public String replaceSpace(StringBuffer str) {
    	int count = 0;
    	char arr[] = str.toString().toCharArray();
    	for(int i = 0;i < str.length(); i++){
    		if(arr[i] == ' ')
    			count++;
    	}
    	char newArr[] = new char[str.length()+count*2];
    	int left = str.length() - 1, right = newArr.length - 1;
    	while(left >= 0){
    		while(left >= 0 && arr[left] != ' '){
    			newArr[right--] = arr[left--];
    		}
    		if(left >= 0 && arr[left--] == ' '){
    			newArr[right--] = '0';
    			newArr[right--] = '2';
    			newArr[right--] = '%';
    		}
    	}
    	return String.valueOf(newArr);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer(" We are happy. ");
		replaceBlank r = new replaceBlank();
		System.out.println(r.replaceSpace(str));
	}

}
