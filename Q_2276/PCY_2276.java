import java.io.*;
import java.util.*;


public class Main {


  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] note1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
      int M = Integer.parseInt(br.readLine());
      int[] note2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      for (int i = 0; i < M; i++) {
        if (binarySerch(note2[i], 0, N - 1, note1)) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
      }

    }
    
    System.out.println(sb);
  }
  

  public static boolean binarySerch(int target, int left, int right, int[] array) {
    while (left <= right) {
      int mid = (left + right) / 2;

      if (array[mid] > target)
        right = mid - 1;
      else if (array[mid] < target)
        left = mid + 1;
      else {
        return true;
      }
    }
    return false;
  }
}
