package BOJ_5635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] temp = line.split(" ");
            if (temp[1].length() == 1) {
                temp[1] = "0" + temp[1];
            }
            if (temp[2].length() == 1) {
                temp[2] = "0" + temp[2];
            }
            int tmp = Integer.parseInt(temp[3] + temp[2] + temp[1]);
            map.put(tmp, temp[0]);
        }

        // Max Key
        Integer maxKey = Collections.max(map.keySet());
        // Min Key
        Integer minKey = Collections.min(map.keySet());

        System.out.println(map.get(maxKey));
        System.out.println(map.get(minKey));
    }
}
