import java.util.*;
import java.io.*;

public class Main {

    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int com, line;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        com = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[com + 1][com + 1];
        check = new boolean[com + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start) {
        check[start] = true;
        count++;

        for (int i = 0; i <= com; i++) {
            if (arr[start][i] == 1 && !check[i])
                dfs(i);
        }
    }
}
