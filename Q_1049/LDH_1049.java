package BOJ_1049;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int Min = 10000;

        int[] ea = new int[M];
        int[] set = new int[M];
        for (int i = 0; i < M; i++) {
            set[i] = sc.nextInt();
            ea[i] = sc.nextInt();
        }
        Arrays.sort(ea);
        Arrays.sort(set);

        Min = Math.min(((N / 6) + 1) * set[0], N * ea[0]);
        Min = Math.min(Min, ((N / 6)) * set[0] + (N % 6) * ea[0]);

        System.out.println(Min);

        sc.close();
    }
}
