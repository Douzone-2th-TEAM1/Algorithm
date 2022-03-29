package BOJ_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");

        int ans = 5000000;
        for (int i = 0; i < arr.length; i++) {

            String[] sub = arr[i].split("\\+");

            int sum = 0;
            for (int j = 0; j < sub.length; j++) {
                sum += Integer.parseInt(sub[j]);
            }

            if (ans == 5000000) {
                ans = sum;
            } else {
                ans -= sum;
            }
        }
        System.out.println(ans);
    }
}
