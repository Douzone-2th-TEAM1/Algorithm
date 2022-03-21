import java.util.Scanner;

public class TM_1654 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long[] numbers;
    long min = 1, max = 0;

    int K = sc.nextInt();
    long N = sc.nextInt();

    numbers = new long[K];
    for (int i = 0; i < K; i++) {
      numbers[i] = sc.nextInt();
      if (max < numbers[i]) {
        max = numbers[i];
      }
    }

    while (min <= max) {
      long mid = (min + max) / 2;

      int count = 0;
      for (int i = 0; i < K; i++) {
        count += numbers[i] / mid;
      }

      if (count >= N) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    System.out.println(max);
  }
}
