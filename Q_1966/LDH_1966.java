package BOJ_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(new int[] { j, Integer.parseInt(st.nextToken()) });
            }

            while (true) {
                int now[] = queue.remove();
                boolean flag = true;

                for (int q[] : queue) {
                    if (q[1] > now[1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                    if (now[0] == M)
                        break;
                } else {
                    queue.add(now);
                }
            }
            System.out.println(cnt);
        }
    }
}
