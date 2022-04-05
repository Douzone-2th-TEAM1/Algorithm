package BOJ_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bracket = br.readLine();

        int tmp = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < bracket.length(); i++) {
            switch (bracket.charAt(i)) {

                case '(':
                    stack.push('(');
                    tmp *= 2;
                    break;

                case '[':
                    stack.push('[');
                    tmp *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        break;
                    }

                    if (bracket.charAt(i - 1) == '(')
                        result += tmp;
                    stack.pop();
                    tmp /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        break;
                    }

                    if (bracket.charAt(i - 1) == '[')
                        result += tmp;
                    stack.pop();
                    tmp /= 3;
                    break;
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}
