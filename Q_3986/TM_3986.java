import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TM_3986 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int answer = 0;

    for (int i = 0; i < N; i++) {
      Stack<Character> stack = new Stack<>();
      String word = br.readLine();
      for (int j = 0; j < word.length(); j++) {
        char ch = word.charAt(j);
        if (stack.isEmpty()) {
          stack.push(ch);
        } else {
          if (stack.peek() == ch) {
            stack.pop();
          } else {
            stack.push(ch);
          }
        }
      }
      if (stack.isEmpty()) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
