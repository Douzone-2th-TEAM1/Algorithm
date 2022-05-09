import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Q_21736 {
  static int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
  static public String[][] map;
  static Point start;
  static boolean[][] visit;
  static int n;
  static int m;
  static int answer = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    n = info[0];
    m = info[1];
    map = new String[n][m];
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split("");
      for (int j = 0; j < m; j++) {
        if (input[j].equals("I")) {
          start = new Point(i, j);
        }
        map[i][j] = input[j];
      }
    }
    bfs(start.x, start.y);
    if (answer == 0) {
      System.out.println("TT");
    }
    else {
      System.out.println(answer);
    }
  }
  
  static public void bfs(int sx, int sy) {
    Queue<Point> q = new LinkedList<Point>();
    q.offer(new Point(sx, sy));

    while (!q.isEmpty()) {
      Point point = q.poll();
      
      for (int i = 0; i < 4; i++) {
        int nx = point.x + directions[i][0];
        int ny = point.y + directions[i][1];

        if (0 <= nx && 0 <= ny && nx < n && ny < m) {
          if(!visit[nx][ny]){
            if (map[nx][ny].equals("X") )
              continue;
            else if (map[nx][ny].equals("P")) {
              answer++;
            }
            visit[nx][ny] = true;
            q.offer(new Point(nx, ny));
          }
        }
      }
    }
  }
}
