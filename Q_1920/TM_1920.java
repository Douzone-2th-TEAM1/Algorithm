import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TM_1920 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    HashMap<String, Integer> map = new HashMap<>();

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      map.put(token, 1);
    }

    int K = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      sb.append(map.getOrDefault(token, 0)).append(" ");
    }

    System.out.println(sb);
  }
}
