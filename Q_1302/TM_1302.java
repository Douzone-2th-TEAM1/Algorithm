import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TM_1302 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> bestSeller = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      map.put(input, map.getOrDefault(input, 0) + 1);
    }

    int max = Collections.max(map.values());
    for (String key : map.keySet()) {
      if (map.get(key) == max) {
        bestSeller.add(key);
      }
    }

    Collections.sort(bestSeller);
    System.out.println(bestSeller.get(0));
  }
}