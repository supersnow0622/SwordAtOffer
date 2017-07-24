package chapter4;

import java.util.ArrayList;


/**
 * @Description:������28���ַ���������
 * ��Ŀ������һ���ַ�������ӡ�����ַ������ַ����������С����磺�����ַ���abc�����ӡ�����ַ�a,b,c,�������г����������ַ���
 * abc��bac��bac��bca��cab��cba
 * @author:����ѩ
 * @time:2016��12��29������3:08:37
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
