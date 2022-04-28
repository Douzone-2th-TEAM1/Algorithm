import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] Array = new int[N];
        for (int i = 0; i < N; i++) {
            Array[i] = sc.nextInt();
        }
        while (K != 0) {
            if (Array[N - 1] <= K) {
                K -= Array[N - 1];
                result++;
            } else
                N--;
        }
        System.out.println(result);
        sc.close();
    }
}
