import java.io.*;
import java.util.Arrays;

public class App {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int K = input[0];
    int N = input[1];
    int[] LAN = new int[K];

    for (int i = 0; i < K; i++) {
      LAN[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(LAN);

    long left = 1;
    long right = LAN[K - 1];
    long mid = 0;

    while (left <= right) {
      long total = 0;
      mid = (left + right) / 2;
      
      for (int j = 0; j < K; j++) {
        total += LAN[j] / mid;
      }
      if (total < N)
          right = mid - 1;
        else
        
        left = mid + 1;
    }
    System.out.println(right);
  }
}
