package BOJ_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[] arr;
    static int[] checked;
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        checked = new int[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);

        br.close();
    }

    public static void dfs(int depth, int length) {
        if (length == L) {
            StringBuilder sb = new StringBuilder();
            int vow = 0;
            int con = 0;

            for (int i = 0; i < L; i++) {
                if (checked[i] == 1) {
                    if (isVowel(arr[i])) {
                        vow++;
                    } else {
                        con++;
                    }

                    sb.append(arr[i]);
                }
            }

            if (vow >= 1 && con >= 2) {
                System.out.println(sb);
            }

        } else {
            for (int i = depth; i < C; i++) {
                checked[i] = 1;
                dfs(i + 1, length + 1);
                checked[i] = 0;
            }
        }
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

}
