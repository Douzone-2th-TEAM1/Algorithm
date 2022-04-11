import java.io.*;
import java.util.*;

public class Q_2606 {
  public static int computer;
  public static List<Integer>[] info;
  public static boolean[] visit;
  public static int result = 0;

  public static void dfs(int start){
    visit[start] = true;
    result++;
    for (int v : info[start]) {
      if (visit[v] == false) {
        dfs(v);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    computer = Integer.parseInt(br.readLine());
    int dgree = Integer.parseInt(br.readLine());
    info = new ArrayList[computer + 1];
    visit = new boolean[computer + 1];

    for (int i = 0; i < computer + 1; i++) {
      info[i] = new ArrayList<Integer>();
    }

    while (dgree-- > 0) {
      int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      info[tmp[0]].add(tmp[1]);
      info[tmp[1]].add(tmp[0]);
    }
    dfs(1);
    System.out.println(result-1);
  }

}
