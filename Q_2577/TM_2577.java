import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TM_2577 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = 1;

    for (int i = 0; i < 3; i++) {
      num *= Integer.parseInt(br.readLine());
    }
    
    String str = Integer.toString(num);
    int[] count = new int[10];

    for (int i = 0; i < str.length(); i++) {
      count[Character.getNumericValue(str.charAt(i))]++;
    }

    for (int i = 0; i < count.length; i++) {
      System.out.println(count[i]);
    }
  }
}
