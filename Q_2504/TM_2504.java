import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    String input = br.readLine();
    int answer = 0;
    int temp = 1;

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == '(') {
        temp *= 2;
        stack.push(ch);
      } else if (ch == '[') {
        temp *= 3;
        stack.push(ch);
      } else {
        if (stack.isEmpty()) {
          System.out.println(0);
          return;
        }
        char before = input.charAt(i - 1);
        if (ch == ')' && stack.peek() == '(') {
          if (before == '(') {
            answer += temp;
          }
          temp /= 2;
          stack.pop();
        } else if (ch == ']' && stack.peek() == '[') {
          if (before == '[') {
            answer += temp;
          }
          temp /= 3;
          stack.pop();
        }
      }
      // System.out.println("ch : " + ch + " answer : " + answer + " temp : " + temp);
    }

    System.out.println(stack.isEmpty() ? answer : 0);
  }
}
