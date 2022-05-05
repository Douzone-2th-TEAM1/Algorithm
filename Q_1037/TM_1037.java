import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_1037 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    String nums = br.readLine();
    StringTokenizer st = new StringTokenizer(nums);

    int max = 2;
    int min = 1000000;
    for (int i = 0; i < K; i++) {
      int N = Integer.parseInt(st.nextToken());
      if (max < N)
        max = N;
      if (min > N)
        min = N;
    }
    System.out.println(max * min);
  }
}
