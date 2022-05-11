import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class TM_23253 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    Stack<Integer> stack;
    StringTokenizer st;
    int[] top = new int[200010];

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = 0;

    for (int i = 1; i <= M; i++) {
      K = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      stack = new Stack<>();
      for (int j = 0; j < K; j++) {
        stack.push(Integer.parseInt(st.nextToken()));
      }
      map.put(i, stack);
      top[stack.peek()] = i;
    }

    boolean check = true;
    for (int i = 1; i <= N; i++) {
      if (top[i] == 0) {
        check = false;
        break;
      }
      stack = map.get(top[i]);
      stack.pop();
      if (!stack.isEmpty()) {
        top[stack.peek()] = top[i];
      }
    }
    System.out.println(check ? "Yes" : "No");
  }
}
