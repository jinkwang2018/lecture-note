package kr.or.bit;

import java.util.Arrays;

//내가 만드는 stack 자료 구조
public class Mystack {
	private Object[] stackarr;
	private int pos;
	private int maxsize;
	
	public Mystack(int maxsize) {
		this.maxsize = maxsize;
		stackarr = new Object[maxsize];
	}
	
	public boolean empty() { //스택 비어 있니?
		return false;
	}
	
	public void push(Object i) {
		//데이터 넣기
		stackarr[pos++] = i;
		
	}
	
	public Object pop() {
		Object obj = stackarr[--pos];
		stackarr[pos] = null;
		return obj;
	}
	
	public Boolean isEmpty() {
		return (pos == 0) ? true : false;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "[";
		for(int i = 0; i < stackarr.length; i++) {
			if(stackarr[i] != null) {
				str += stackarr[i];
				if((i < (maxsize - 1)) &&(stackarr[i+1] != null)) {
					str += ", ";
				}
			}
		}
		str += "]";
		
		return str;
	}
}
