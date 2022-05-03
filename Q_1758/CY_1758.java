import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_1758 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long answer = 0;
    Integer [] line = new Integer[N];
    for (int i = 0; i < N; i++) {
      line[i] = sc.nextInt();
    }
    Arrays.sort(line, Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      int temp = line[i] - i;
      if (temp > 0)
        answer += temp;
      else
        break;
    }
    System.out.println(answer);
  }
}
