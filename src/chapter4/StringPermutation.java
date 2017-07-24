package chapter4;

import java.util.ArrayList;


/**
 * @Description:面试题28：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如：输入字符串abc，则打印出由字符a,b,c,所能排列出来的所有字符串
 * abc、bac、bac、bca、cab、cba
 * @author:王丽雪
 * @time:2016年12月29日下午3:08:37
 */
public class StringPermutation {
	
	public ArrayList<String> Permutation(String str) {
	       ArrayList<String> list = new ArrayList<String>();
	       if(str.equals(""))
	    	   return list;
	       char[] newStr = new char[str.length()];
	       Boolean visited[] = new Boolean[str.length()];
	       for(int i = 0; i < str.length(); i++)
	    	   visited[i] = false;
	       PerStr(str,0,newStr,list,visited);
	       return list;
    }
	
	public void PerStr(String str,int index,char[] newStr,ArrayList<String> list,Boolean[] visited){
		int len = str.length() ;
		if(index == len){
			String addStr = String.valueOf(newStr);
			if(!list.contains(addStr))
				list.add(addStr);
		}
		for(int i = 0; i < len; i++){
			if(!visited[i]){
				visited[i] = true;
				newStr[index] = str.charAt(i);
			}else{
				continue;
			}
			PerStr(str,index+1,newStr,list,visited);
			visited[i] = false;
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPermutation s = new StringPermutation();
		ArrayList<String> list = s.Permutation("aa");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
