import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TM_13702 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    long answer = 0;

    long[] mak = new long[N];
    for (int i = 0; i < N; i++) {
      mak[i] = Long.parseLong(br.readLine());
    }

    if(K == 1) {
      for (int i = 0; i < mak.length; i++) {
        answer += mak[i];
      }
    }
    else {
      Arrays.sort(mak);

      long min = 0;
      long max = mak[N - 1];
  
      while(min <= max) {
        long count = 0;
        long mid = (min + max) / 2;
        for (int i = 0; i < mak.length; i++) {
          if (mak[i] > 0) {
            count += mak[i] / mid;
          }
        }
  
        if (count < K) {
          max = mid - 1;
        }
        else {
          answer = mid;
          min = mid + 1;
        }
      }
    }

    System.out.println(answer);
  }
}
