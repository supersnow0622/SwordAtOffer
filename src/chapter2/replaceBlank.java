package chapter2;


/**
 * @Description:请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * @author:王丽雪
 * @time:2017年7月20日下午3:28:50
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
