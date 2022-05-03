import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        int temp = 1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = N - 1; i >= 0; i--) {
            int t = arr[i] - (temp - 1);
            if (t >= 0)
                result += t;
            temp++;
        }
        System.out.println(result);
        sc.close();
    }
}
