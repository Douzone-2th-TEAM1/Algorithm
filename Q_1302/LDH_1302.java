package BOJ_1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int val = 0;
        String ans = "";
        for (String key : map.keySet()) {
            if (val == map.get(key)) {
                if (ans.compareTo(key) > 0) {
                    ans = key;
                }
            } else if (val < map.get(key)) {
                val = map.get(key);
                ans = key;
            }
        }
        System.out.println(ans);
    }
}
