import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TM_1966 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int N = Integer.valueOf(br.readLine());

    for (int i = 0; i < N; i++) {

      StringTokenizer st = new StringTokenizer(br.readLine());

      int length = Integer.parseInt(st.nextToken());
      int location = Integer.parseInt(st.nextToken());
      int[] properties = new int[length];

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < length; j++) {
        properties[j] = Integer.parseInt(st.nextToken());
      }

      sb.append(solution(properties, location)).append("\n");
    }

    System.out.println(sb);
  }

  public static int solution(int[] priorities, int location) {
    int answer = 1;
    Queue<Integer> queue = new LinkedList<>();

    for (int priority : priorities) {
      queue.add(priority);
    }

    while (!queue.isEmpty()) {
      int temp = queue.poll();
      boolean isShifted = false;

      for (int priority : queue) {
        if (temp < priority) {
          isShifted = true;
          break;
        }
      }

      if (isShifted)
        queue.offer(temp);
      else {
        if (location == 0)
          break;
        else
          answer++;
      }

      if (location > 0)
        location--;
      else
        location = queue.size() - 1;
    }
    return answer;
  }
}
