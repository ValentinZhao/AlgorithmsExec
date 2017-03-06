package CodingInterviews;

import java.util.Stack;

/**
 * 利用两个栈实现队列
 */

public class Interview6 {
	
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public Interview6(){
		stackPush = new Stack<>();
		stackPop = new Stack<>();
	}
	
	public void add(int pushInt){
		stackPush.push(pushInt);
	}
	
	@SuppressWarnings("null")
	public int poll(){
		if(stackPop == null || stackPush == null){
			return (Integer) null;
		}
		if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	@SuppressWarnings("null")
	public int peek(){
		if(stackPop == null || stackPush == null){
			return (Integer) null;
		}
		if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}

}
