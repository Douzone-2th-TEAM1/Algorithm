import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;



public class CY_4358 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> dic = new HashMap<>();
    StringBuffer sb = new StringBuffer();
    int totalCount = 0;

    String input = br.readLine();
    while (true) {
      dic.put(input, dic.getOrDefault(input, 0) + 1);
      totalCount++;

      input = br.readLine();
      if (input == null || input.length() <= 0)
        break;
      
    }
    
    Object[] keys = dic.keySet().toArray();
    Arrays.sort(keys);

    for (Object key : keys) {
      int count = dic.get(key.toString());
      double answer = (double) (count * 100.0) / totalCount;

      sb.append(key + " " + String.format("%.4f", answer) + "\n");
    }
    System.out.println(sb);
  }
}
