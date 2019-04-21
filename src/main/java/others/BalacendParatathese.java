package others;

import java.util.Stack;

public class BalacendParatathese {

    /**
     * space complexity is O(n)
     * @param str
     * @return
     */
    public boolean isBalanced(String str) {
        int len = str.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<len;i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty() && stack.peek() != '(') return false;
                if(!stack.isEmpty()) stack.pop();
            }
        }
        return stack.size() == 0;
    }

    public boolean isBalanced2(String str) {
        int len = str.length();
        int count = 0;
        for(int i=0;i<len;i++) {
            if(str.charAt(i) == '(') count++;
            else {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(new BalacendParatathese().isBalanced("()()()(") == new BalacendParatathese().isBalanced2("()()()("));
        System.out.println(new BalacendParatathese().isBalanced(")()()(") == new BalacendParatathese().isBalanced2(")()()("));
        System.out.println(new BalacendParatathese().isBalanced("()()(())") == new BalacendParatathese().isBalanced2("()()(())"));
        System.out.println(new BalacendParatathese().isBalanced("()()())(") == new BalacendParatathese().isBalanced2("()()())("));
    }
}
