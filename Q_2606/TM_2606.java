import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TM_2606 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int C = Integer.parseInt(br.readLine());
    int P = Integer.parseInt(br.readLine());
    int[][] matrix = new int[C + 1][C + 1];
    boolean[] visited = new boolean[C + 1];

    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      matrix[x][y] = 1;
      matrix[y][x] = 1;
    }

    bfs(1, C, matrix, visited, 0);
  }

  public static void bfs(int start, int C, int[][] matrix, boolean[] visited, int count) {
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
      int x = queue.poll();
      for (int y = 1; y <= C; y++) {
        if (matrix[x][y] == 1 && !visited[y]) {
          queue.offer(y);
          visited[y] = true;
          count++;
        }
      }
    }
    System.out.println(count);
  }
}