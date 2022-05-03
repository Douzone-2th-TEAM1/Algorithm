package BOJ_1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        long sum = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = n - 1; i >= 0; i--) {
            int tip = arr[i];
            int tmp = tip - (count - 1);
            if (tmp > 0) {
                sum += tmp;
            }
            count++;
        }
        System.out.println(sum);
    }
}
