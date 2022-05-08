package BOJ_21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] campus;
    static boolean[][] visited;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int result = 0; // 만나는 사람 수

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        visited = new boolean[n][m];

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = tmp.charAt(j);
                if (campus[i][j] == 'I') {
                    a = i;
                    b = j;
                }
            }
        }
        dfs(a, b);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (campus[x][y] == 'P')
            result++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                if (campus[nx][ny] != 'X') {
                    dfs(nx, ny);
                }
            }
        }
    }
}
