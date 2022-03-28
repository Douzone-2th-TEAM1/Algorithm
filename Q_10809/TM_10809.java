import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TM_10809 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();

    char[] alphabet = {
        'a', 'b', 'c', 'd',
        'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l',
        'm', 'n', 'o', 'p',
        'q', 'r', 's', 't',
        'u', 'v', 'w', 'x',
        'y', 'z'
    };

    for (int i = 0; i < alphabet.length; i++) {
      sb.append(str.indexOf(alphabet[i])).append(" ");
    }
    System.out.println(sb);
  }
}
