import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class App {
  public static int N;
  public static int[] A;
  public static boolean[] visit;
  public static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    ArrayList<Integer> results = new ArrayList<>();
    visit = new boolean[N];
    dfs(0, results);
    System.out.println(answer);
  }
  
  public static void dfs(int depth, ArrayList<Integer> arr) {
    if (arr.size() >= N) {
      answer = Math.max(getSum(arr), answer);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        arr.add(A[i]);
        dfs(depth + 1, arr);
        arr.remove(arr.size() - 1);
        visit[i] = false;
      }
    }
  }

  public static int getSum(ArrayList<Integer> arr) {
    int temp = 0;
    for (int i = 0; i < N - 1; i++) {
      temp += Math.abs(arr.get(i) - arr.get(i + 1));
    }
      return temp;
    }
}
