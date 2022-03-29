import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_1541 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), "+|-", true);
    boolean sign = true;
    int answer = 0;

    while (st.hasMoreTokens()) {
      String next = st.nextToken();
      if (next.equals("+")) {
        continue;
      }
      else if (next.equals("-")) {
        if(sign) {
          sign = !sign;
        }
        continue;
      }
      answer += Integer.parseInt(next) * (sign ? 1 : -1);
    }
    System.out.println(answer);
  }
}
