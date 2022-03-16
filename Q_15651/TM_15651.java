import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_15651 {
  public static void main(String[] args) throws IOException {
    int n, m;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    perm(n, m, "");
  }

  public static void perm(int n, int m, String prefix) {
    if (m == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = 0; i < n; i++) {
      perm(n, m - 1, prefix + (i + 1) + " ");
    }
  }
}