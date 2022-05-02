import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TM_1049 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] split = input.split(" ");
    int N = Integer.parseInt(split[0]);
    int M = Integer.parseInt(split[1]);

    int bundle = 1000;
    int each = 1000;

    for (int i = 0; i < M; i++) {
      input = br.readLine();
      split = input.split(" ");
      if (bundle > Integer.parseInt(split[0]))
        bundle = Integer.parseInt(split[0]);
      if (each > Integer.parseInt(split[1]))
        each = Integer.parseInt(split[1]);
    }

    int allBundle = ((N / 6) + 1) * bundle;
    int allEach = N * each;
    int mix = (N / 6) * bundle + (N % 6) * each;
    int min = Math.min(mix, Math.min(allBundle, allEach));
    System.out.println(min);
  }
}
