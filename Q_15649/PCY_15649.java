import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App {
  
  public static int N, M;
  public static String[] array;
  public static StringBuffer sb;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuffer();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    array = new String[N];
    for (int i = 1; i <= N; i++)
      array[i - 1] = Integer.toString(i);

    for (int i = 0; i < N; i++) {
      ArrayList<String> answer = new ArrayList();
      answer.add(array[i]);
      dfs(i, answer);
    }
    
    System.out.println(sb);
  }
  
  public static void dfs(int depth, ArrayList<String> result) {
    if (result.size() >= M) {
      sb.append(String.join(" ", result) + "\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (result.contains(array[i]))
        continue;
      result.add(array[i]);
      dfs(i, result);
      result.remove(result.size() - 1);
    }

    }
}
