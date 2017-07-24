package chapter5;

import java.util.HashMap;

/**
 * @Description:面试题35：第一次只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符
 * @author：王丽雪
 * @time:2016年12月30日下午8:27:33
 */
public class FirstNotRepeatingChar {
	public int firstNotRepeatingChar(String str) {
		if(str == null || str.equals(""))
			return -1;
		int character[] = new int[52];
		for(int i = 0 ;i < str.length(); i++){
			char ch = str.charAt(i);
			if(Character.isUpperCase(ch))
				character[ch - 'A']++;
			else
				character[ch - 71]++;
		}
		char c[] = new char[52];
		int count = 0;
		for(int i = 0 ; i < character.length; i++){
			if(character[i] == 1){
				if(i < 26)
					c[count++] = (char) (i + 'A');
				else
					c[count++] = (char) (i + 71);
			}
		}
		int min = 1000000;
		for(int i = 0; i < count; i++){
			char ch = c[i];
			int index = str.indexOf(ch);
			if(min > index)
				min = index;
		}
        return min;
    }
	public int firstNotRepeatingChar1(String str){
		if(str == null || str.equals(""))
			return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0;i < str.length(); i++){
			char ch = str.charAt(i);
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}else{
				map.put(ch, -1);
			}
		}
		int min = str.length()-1;
		boolean flag = false;
		for(Character ch:map.keySet()){
			if(map.get(ch) != -1){
				min = Math.min(str.indexOf(ch),min);
				flag = true;
			}
		}
		if(!flag)
			return -1;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstNotRepeatingChar f = new FirstNotRepeatingChar();
		System.out.println(f.firstNotRepeatingChar1("aa"));
	}

}
