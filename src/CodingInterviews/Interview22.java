package CodingInterviews;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 
 * 将压入序列入栈，每次入栈比较栈顶元素与弹出序列首位的值
 * 如果一致，说明此时弹出序列的这个值是由我们这个栈顶元素弹出得到的
 * 所以把栈顶元素弹出，并把弹出序列比较指针向后推
 * 弹出之后继续比较栈顶元素与现在指针指向的值，如果还一致则重复上述操作
 * 如果不一致，就继续把压入序列入栈，将栈顶元素与弹出序列比较
 * 我们可知如果弹出序列确实是我们压入序列弹出得到的，则最后我们的压入序列会将所有元素弹出，即为空；反之亦然
 * @author zhaoziliang
 *
 */
public class Interview22 {
	public static boolean isPopOreder(int[] pushStack, int[] popStack){
		if(pushStack == null || popStack == null || pushStack.length != popStack.length){
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		for(int i = 0; i < pushStack.length; i++){
			stack.push(pushStack[i]);
			while(!stack.isEmpty() && stack.peek() == popStack[popIndex]){
				stack.pop();
				popIndex++;
			}
		}
		return stack.empty();
	}
}
