import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class IsStackPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //序列为空或序列的长度不相等，则不是栈的弹出序列
        if(pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;//压入栈的下标
        int j = 0;//弹出栈的下标
        for(; i < pushA.length; i++) {
            //将元素入栈
            stack.push(pushA[i]);
            //判断当前栈顶元素是否是在此时出栈
            while(!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        //栈不空，代表此出栈顺序错误
        if(stack.empty()) {
            return true;
        }
        return false;
    }
}
