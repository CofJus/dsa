package stack.brackets;

import java.util.Stack;

/**
 * @author Ji Rui
 * @date 2020/8/24 15:21
 */
public class BracketsMapping {
    public static void main(String[] args) {

        //测试用例
        String s = "{[[()]]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String target) {
        if (0 != (target.length() & 1)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : target.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }
}
