package BOJ_13702;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[] arr = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }

        long low = 0, high = max;

        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;

            for (long num : arr) {
                if (mid != 0) {
                    cnt += num / mid;
                } else {
                    cnt += num;
                }
            }

            if (cnt >= K)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println(high);

        sc.close();
    }
}
