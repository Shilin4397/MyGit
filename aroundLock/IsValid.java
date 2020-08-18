import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class IsValid {
    public static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(ch[0]);
        for (int i = 1; i < ch.length; i++) {
            if(!stack.empty() &&
                    ((ch[i] == ')' && stack.peek() == '(')
                    || (ch[i] == '}' && stack.peek() == '{')
                    || (ch[i] == ']' && stack.peek() == '['))) {
                stack.pop();
            }else if(ch[i] == '('
                    || ch[i] == '{'
                    || ch[i] == '['){
                stack.push(ch[i]);
            }else {
                return false;
            }
        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{}][}}{[))){}{}){(}]))})[({";
        boolean bool = isValid(s);
        System.out.println(bool);
    }
}
