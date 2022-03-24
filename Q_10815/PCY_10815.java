import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    
    int N = Integer.parseInt((br.readLine()));
    int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

    int K = Integer.parseInt((br.readLine()));
    int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    for (int i = 0; i < K; i++) {
      if (binarySearch(M[i], A, 0, N - 1))
        sb.append(1 + " ");
      else
        sb.append(0 + " ");
      }
    System.out.println(sb);
  }

  public static boolean binarySearch(int target, int[] array, int left, int right) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] > target) {
        right = mid - 1;
      } else if (array[mid] < target)
        left = mid + 1;
      else {
        return true;
      }
    }
      return false;
  }

}
