import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TM_2276 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      StringBuilder sb = new StringBuilder();
      int N = Integer.parseInt(br.readLine());
      int[] note1 = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        note1[j] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(note1);

      int M = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {

        int left = 0;
        int right = N - 1;
        int next = Integer.parseInt(st.nextToken());

        while (left <= right) {
          int mid = (left + right) / 2;

          if (note1[mid] == next) {
            sb.append("1\n");
            break;
          } else if (note1[mid] < next)
            left = mid + 1;
          else
            right = mid - 1;
        }
        if (left > right) {
          sb.append("0\n");
        }
      }

      System.out.print(sb);
    }
  }
}