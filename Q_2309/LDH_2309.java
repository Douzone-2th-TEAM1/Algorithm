package BOJ_2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        int error = sum - 100;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                } else if (arr[i] + arr[j] == error) {
                    arr[i] = 0;
                    arr[j] = 0;
                    break;
                }
            }
        }
        Arrays.sort(arr);

        for (int i = 2; i < 9; i++) {
            System.out.println(arr[i]);
        }

        in.close();
    }
}
