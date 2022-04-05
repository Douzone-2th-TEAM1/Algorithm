import java.io.*;
import java.util.*;

public class Q_2504 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split("");
    Stack<String> stack = new Stack<>();
    int check = 0;

    for (int i = 0; i < input.length; i++) {
      if (input[i].equals("(") || input[i].equals("[")) { // 열린 괄호 => 스택에 추가
        stack.push(input[i]);
      } else { // 닫힌 괄호
        
        if (stack.isEmpty()) {
          System.out.println(0);
          return;
        }


        if (input[i].equals(")")) {
          if (stack.peek().equals("(")) { // 한쌍을 이룰 때
            stack.pop();
            stack.push("2");
          } else {
            check = stackInner(stack, "[", "(", 2);
          }
        }
        else {
          if (stack.peek().equals("[")) {

            stack.pop();
            stack.push("3");
          } else {
            check = stackInner(stack, "(", "[", 3);
          }
        }
      }
    }
    int answer = 0;
    while (!stack.isEmpty()) {
      if (stack.peek().equals("(") || stack.peek().equals("[") || stack.peek().equals("]")|| stack.peek().equals(")")) {
        System.out.println(0);
        return;
      } else {
        answer += Integer.parseInt(stack.pop());
      }
    }
    
    System.out.println(answer);
  }
  
  public static int stackInner(Stack<String> stack, String wrong, String correct, int value) {
    int result = 0;

    while (!stack.isEmpty()) {
      String top = stack.peek();

      if (top.equals(wrong)) { // 잘못된 괄호
        return -1;
      } else if (top.equals(correct)) {
        stack.pop();
        result *= value;
        stack.push(String.valueOf(result));
        break;
      } else {
        result += Integer.parseInt(stack.pop());
      }
    }
    return result;
  }
}
