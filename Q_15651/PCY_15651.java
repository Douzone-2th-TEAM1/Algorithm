import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
  public static int N, M;
  public static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    
    ArrayList<String> answer = new ArrayList<>();
    dfs(0, answer);
    System.out.println(sb);
  }
    
  public static void dfs(int depth, ArrayList<String> result){
    if (result.size() >= M) {
      sb.append(String.join(" ", result) + "\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      result.add(Integer.toString(i));
      dfs(i + 1, result);
      result.remove(result.size() - 1);
    }
  }
}
