import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TM_2309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dwarfs = new int[9];
    int height = -100;

    for (int i = 0; i < dwarfs.length; i++) {
      dwarfs[i] = Integer.parseInt(br.readLine());
      height += dwarfs[i];
    }
    Arrays.sort(dwarfs);

    int a = 0;
    int b = 0;
    for (int i = 0; i < dwarfs.length - 1; i++) {
      for (int j = i + 1; j < dwarfs.length; j++) {
        if (dwarfs[i] + dwarfs[j] == height) {
          a = dwarfs[i];
          b = dwarfs[j];
          break;
        }
      }
    }

    for (int dwarf : dwarfs) {
      if (dwarf != a && dwarf != b)
        System.out.println(dwarf);
    }
  }
}