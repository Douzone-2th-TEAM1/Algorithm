import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class TM_4358 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> map = new HashMap<>();
    int total = 0;

    while (true) {
      String input = br.readLine();
      if (input == null | input == "") {
        break;
      }
      map.put(input, map.getOrDefault(input, 0) + 1);
      total++;
    }

    Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);

    for (Object key : keys) {
      double answer = map.get(key) * 100.0 / total;
      sb.append(key).append(" ").append(String.format("%.4f", answer)).append("\n");
    }

    System.out.println(sb);
  }
}
