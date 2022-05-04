package BOJ_1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        int[] arr = new int[n];

        if (n == 1) {
            long temp = Long.parseLong(st.nextToken());
            result = (long) Math.pow(temp, 2);
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            result = arr[0] * arr[n - 1];
        }
        System.out.println(result);
    }
}
