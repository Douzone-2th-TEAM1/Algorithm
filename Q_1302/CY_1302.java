import java.io.*;
import java.util.*;


public class Q_1302 {
  public static HashMap<String, Integer> map;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    ArrayList<String> answers = new ArrayList<>();
    map = new HashMap<>();

    while (count-- > 0) {
      String input = br.readLine();
      map.put(input, map.getOrDefault(input, 0) + 1);
    }
    
    map.forEach((k, v) -> {
      if (v == Collections.max(map.values())) {
        answers.add(k);
      }
    });

    Collections.sort(answers);
    System.out.println(answers.get(0));
  }
}
