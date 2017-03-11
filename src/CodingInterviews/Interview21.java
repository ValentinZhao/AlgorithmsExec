package CodingInterviews;

import java.util.Stack;

/**
 * 包含min函数的栈
 * @author zhaoziliang
 *
 */
public class Interview21 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public Interview21(){
		stackData = new Stack<>();
		stackMin = new Stack<>();
	}
	
	public void push(int num){
		if(stackMin.isEmpty()){
			stackMin.push(num);
		} else if(num <= getMin()){
			stackMin.push(num);
		}
		stackData.push(num);
	}
	
	public int pop(){
		if(stackData.isEmpty()){
			throw new RuntimeException("Your data stack is empty!");
		}
		int value = stackData.pop();
		if(value == getMin()){
			stackMin.pop();
		}
		return value;
	}

	private int getMin() {
		if(stackMin.isEmpty()){
			throw new RuntimeException("You min stack is Empty!");
		}
		return stackMin.peek();
	}
}
