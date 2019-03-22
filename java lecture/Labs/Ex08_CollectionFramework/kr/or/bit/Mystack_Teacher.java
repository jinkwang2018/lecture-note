package kr.or.bit;
//내가 만드는 stack 자료 구조
public class Mystack_Teacher {
	//추가 : 필요하다면 함수 추가 (예적적인 처리)
	//추가 : member field 추가 
	//LIFO 자료구료를 갖는 클래스 설계
	private int top; //값 이 변하죠 (이동)
	private int maxsize; //크기 고정
	private Object[] stackarr;	
	
	public Mystack_Teacher(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
		top = -1;
	}
	
	public boolean empty() { //스택 비어 있니
		return (top == -1);
	}
	
	public boolean full() { 
		return (top == maxsize -1); //배열의 마지막 방번호와 top 이 같으면
	}
	
	public void push(Object i) {
		//데이터 넣기
		if(full()) {
			System.out.println("스택이 가득참");
		}else {
			stackarr[++top] = i; //처음 top = -1; >> [0]방에 >> 
		}
	}
	
	public Object pop() {
		if(empty()) {
			System.out.println("스택이 비어있음");
			return null;
		}else {
			Object output = stackarr[top];
			top--;
			return output;
		}
	}
}
