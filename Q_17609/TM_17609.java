import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TM_17609 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String string = br.readLine();
      int left = 0;
      int right = string.length() - 1;

      sb.append(isPseudoPalindrome(string, left, right)).append("\n");
    }
    System.out.print(sb);
  }

  public static boolean isPalindrome(String string, int left, int right) {
    while (left <= right) {
      if (string.charAt(left) == string.charAt(right)) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static int isPseudoPalindrome(String string, int left, int right) {
    while (left <= right) {
      if (string.charAt(left) == string.charAt(right)) {
        left++;
        right--;
      } else {
        if (isPalindrome(string, left, right - 1) || isPalindrome(string, left + 1, right)) {
          return 1;
        }
        return 2;
      }
    }
    return 0;
  }
}
