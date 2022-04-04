import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String input = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < T; i++) {
            input = br.readLine();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }

        int size = 0;
        for (String key : map.keySet()) {
            if (size < map.get(key)) {
                size = map.get(key);
                result = key;
            } else if (size == map.get(key)) {
                if (result.compareTo(key) > 0) {
                    result = key;
                }
            }
        }
        System.out.println(result);
    }
}
