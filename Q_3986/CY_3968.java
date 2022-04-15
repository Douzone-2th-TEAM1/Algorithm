import java.io.*;
import java.util.*;

public class Q_3986 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int result = 0;

    for (int i = 0; i < N; i++) {
      Stack<Character> stack = new Stack<>();
      String w = br.readLine();
      for (int j = 0; j < w.length(); j++) {
        char c = w.charAt(j);
        if (stack.isEmpty()) {
          stack.push(c);
        } else {
          if (stack.peek() == c) {
            stack.pop();
          } else {
            stack.push(c);
          }
        }
      }
      if (stack.isEmpty()) {
        result++;
      }
    }
    System.out.println(answer);
  }
}
