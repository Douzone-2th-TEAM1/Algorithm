import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_15649 {
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    int n, m;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visit = new boolean[n];
    perm("", n, m);
    
    System.out.println(sb);
  }

  public static void perm(String prefix, int n, int m) {
    if (m == 0) {
      sb.append(prefix).append('\n');
      return;
    }
    for (int i = 0; i < n; i++) {
      if (visit[i])
        continue;
      visit[i] = true;
      perm(prefix + (i + 1) + " ", n, m - 1);
      visit[i] = false;
    }
  }
}