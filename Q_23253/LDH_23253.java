package BOJ_23253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int bundle = Integer.parseInt(nm[1]);

        boolean result = true;

        for (int i = 0; i < bundle; i++) {
            int k = Integer.parseInt(br.readLine());
            String[] b = br.readLine().split(" ");
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (Integer.parseInt(b[j]) > preVal) {
                    result = false;
                }
                tmp = Integer.parseInt(b[j]);
            }
        }

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
