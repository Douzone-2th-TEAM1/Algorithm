package BOJ_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr;
    static boolean[] visited;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0)
                break;

            arr = new int[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            dfs(0,0);
            sb.append("\n");

        } while (N != 0);

        System.out.println(sb);
        br.close();
    }

    static void dfs(int start, int depth) {
        if (depth == 6) { // depth가 6에 달했을 때
            for (int i=0; i<N; i++) {
                if(visited[i]) // 방문 체크 되어 있지 않을 시
                sb.append(arr[i]+" "); // 해당 순번의 값을 sb에 추가
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++) {
            visited[i] = true; // 방문 처리
            dfs(i+1,depth+1); // 재귀
            visited[i] = false; //  return문 이후 방문 처리 해제
        }
    }
}
