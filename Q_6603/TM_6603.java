import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_6603 {
  public static void main(String[] args) throws IOException {
    int k;
    int[] s;
    boolean[] visited;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      if (k == 0)
        break;

      s = new int[k];
      visited = new boolean[k];

      for (int i = 0; i < k; i++) {
        s[i] = Integer.parseInt(st.nextToken());
      }

      combination(s, 0, k, 6, visited, "");
      System.out.println();
    }
  }

  public static void combination(int[] s, int index, int n, int r, boolean[] visited, String prefix) {
    if (r == 0) {
      System.out.println(prefix);
      return;
    }
    for (int i = index; i < n; i++) {
      visited[i] = true;
      combination(s, i + 1, n, r - 1, visited, prefix + s[i] + " ");
      visited[i] = false;
    }
  }
}
