import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TM_2941 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();
    String regEx = "(c=|c-|dz=|d-|lj|nj|s=|z=|[a-z])";
    Pattern pattern = Pattern.compile(regEx);
    Matcher match = pattern.matcher(word);

    int count = 0;
    while (match.find()) {
      count++;
    }
    System.out.println(count);
  }
}
