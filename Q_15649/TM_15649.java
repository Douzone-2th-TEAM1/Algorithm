import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_15649 {
  public static void main(String[] args) throws IOException {
    int n, m;
    boolean[] visited;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n];

    perm(n, m, visited, "");
  }

  public static void perm(int n, int m, boolean[] visited, String prefix) {
    if (m == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = 0; i < n; i++) {
      if (visited[i])
        continue;
      visited[i] = true;
      perm(n, m - 1, visited, prefix + (i + 1) + " ");
      visited[i] = false;
    }
  }
}