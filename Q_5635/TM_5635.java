import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TM_5635 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    HashMap<Integer, String> map = new HashMap<>();
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int birthdate = Integer.parseInt(st.nextToken()) + (Integer.parseInt(st.nextToken()) * 100) + (Integer.parseInt(st.nextToken()) * 10000);
      map.put(birthdate, name);
    }

    int max = Collections.max(map.keySet());
    int min = Collections.min(map.keySet());

    System.out.println(map.get(max));
    System.out.println(map.get(min));
  }
}
