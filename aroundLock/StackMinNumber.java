import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class StackMinNumber {
    Stack<Integer> stack = new Stack<>();//数据栈，存放所有数据
    Stack<Integer> minStack = new Stack<>();//辅助栈,存放当前数据栈中最小值
    public void push(int node) {
        stack.push(node);
        if(minStack.empty() || node < minStack.peek()) {
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
