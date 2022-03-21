package BOJ_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // for(int i:arr) System.out.println(i);
        
        System.out.println(binarySearch(1, arr[K-1], N));
    }

    static long binarySearch(long min, long max, long N) {
        
        while (max >= min) {
            long mid = (max + min) / 2; // 이분 탐색

            long count = 0; // 랜선 갯수 초기화

            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid; // 지금 mid로 만들어지는 랜선은 총 몇개?
            }

            if (count >= N) { // 'N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다.'
                min = mid + 1;
            } else if (count < N) {
                max = mid - 1;
            }

        }
        return max;
    }
}
