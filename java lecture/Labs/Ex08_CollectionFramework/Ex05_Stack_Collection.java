import java.util.Stack;

import kr.or.bit.Mystack;

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		/*	
		//LIFO
		//Collection Framework �����ϴ� Stack
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		//System.out.println(stack.pop()); //java.util.EmptyStackException
		*/
		
		Mystack my = new Mystack(3);
		System.out.println(my.isEmpty());
		my.push("A");
		my.push("B");
		System.out.println(my.toString());
		System.out.println(my.pop());
		System.out.println(my.toString());
		my.push(1);
		System.out.println(my.toString());
		my.push(2);
		System.out.println(my.toString());
//		my.push(3);
//		System.out.println(my.toString());
		
		/////////////////////////////////////
		//JAVA API �����ϴ� Stack Ŭ����
		
		
		
	}
}
