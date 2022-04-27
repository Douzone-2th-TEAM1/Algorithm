import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TM_1855 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    String input = br.readLine();
    char[][] matrix = new char[input.length() / K][K];

    int index = 0;
    boolean flag = true;
    int i = 0;
    int j = 0;
    for (int k = 0; k < input.length(); k++) {
      matrix[i][j] = input.charAt(index);
      index++;
      if(flag) {
        j++;
      }
      else {
        j--;
      }
      if(j >= K) {
        i++;
        j = K - 1;
        flag = false;
      }
      else if(j < 0) {
        i++;
        j = 0;
        flag = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < K; y++) {
      for (int x = 0; x < input.length() / K; x++) {
        sb.append(matrix[x][y]);
      }
    }
    System.out.println(sb);
  }
}
