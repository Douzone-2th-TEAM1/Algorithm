import java.util.*;

public class Main {
    static int N;
    static int M;

    static char[][] room;
    static boolean[][] check;

    static int result = 0;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {

        int r = 0;
        int c = 0;

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            for (int k = 0; k < M; k++) {
                room[i][k] = input.charAt(k);
                if (room[i][k] == 'I') {
                    r = i;
                    c = k;
                }
            }
        }

        DFS(r, c);

        if (result == 0)
            System.out.println("TT");
        else
            System.out.println(result);

        sc.close();
    }

    public static void DFS(int r, int c) {
        check[r][c] = true;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, -1 };
        if (room[r][c] == 'P')
            result++;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny]) {
                if (room[nx][ny] != 'X')
                    DFS(nx, ny);
            }
        }
    }
}
