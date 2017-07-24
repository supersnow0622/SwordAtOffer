package chapter8;

/**
 * @Description:面试题55：字符流中第一个不重复的字符
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
 * 当从该字符流中读出前6个字符"google"时，第一个只出现一次的字符是'l'。如果当前字符流没有存在出现一次的字符，返回#字符。
 * @author:王丽雪
 * @time:2017年1月16日上午11:22:50
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
