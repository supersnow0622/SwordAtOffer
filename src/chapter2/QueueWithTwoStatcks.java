package chapter2;

import java.util.Stack;

/**
 * @Description:������ջʵ��һ������
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��7��20������4:02:44
 */
public class QueueWithTwoStatcks<T> {

	Stack<T> stack1 = new Stack<T>();
    Stack<T> stack2 = new Stack<T>();
    public void push(T t) {
		stack1.push(t);
	}
    public T pop(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty())
				stack2.add(stack1.pop());
		}
		if(!stack2.isEmpty())
			return stack2.pop();
		return null;
	}
	public static void main(String args[]){
		QueueWithTwoStatcks<String> queue = new QueueWithTwoStatcks<String>();
		queue.push("a");
		queue.push("b");
		queue.push("c");
		
		try {
			String head = queue.pop();
			System.out.println(head);
			
		    head = queue.pop();
			System.out.println(head);
			
			queue.push("d");
			
			head = queue.pop();
			System.out.println(head);
			
			queue.push("e");
			
			head = queue.pop();
			System.out.println(head);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
