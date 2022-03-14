package BOJ_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static int[] arr;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];
        visited = new boolean[N+1];

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 슬롯 별 visited 체크 후 각 경우의 수 탐색
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {

                visited[i] = true;  // 방문처리

                arr[depth] = i + 1; // 값 조작 실행
                dfs(depth + 1); // 재귀

                visited[i] = false; // return문 이후 방문 처리 해제
            }
        }
    }
}
