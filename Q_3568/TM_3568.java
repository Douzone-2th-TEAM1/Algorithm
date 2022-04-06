import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TM_3568 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String varType;
    StringBuilder exType = new StringBuilder();
    StringBuilder varName = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " |,|;");
    varType = st.nextToken();

    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      for (char ch : token.toCharArray()) {
        if (ch == '&' || ch == '*') {
          exType.append(ch);
        } else if (ch == '[') {
          exType.append(']');
        } else if(ch == ']' ) {
          exType.append('[');
        }
        else {
          varName.append(ch);
        }
      }
      exType.reverse();

      System.out
          .println(
              varType + exType + " " + varName + ";");

      exType.setLength(0);
      varName.setLength(0);
    }
  }
}
