import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_11047 {
  public static int count;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int testcase = Integer.parseInt(st.nextToken());
    int value = Integer.parseInt(st.nextToken());
    arr = new int[testcase];
    for (int i = 0; i < testcase; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    solution(value, arr.length - 1);
    System.out.println(count);
  }

  public static void solution(int value, int i) {
    if(value <= 0 || i < 0) return;
    if(arr[i] <= value) {
      count += value / arr[i];
      value = value % arr[i];
    }
    solution(value, --i);
  }
}
