import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
   static int[] ary;
   public static void main(String[] args) {
      BufferedReader br = null;
      StringTokenizer stz;
      try {
          br = new BufferedReader(new InputStreamReader(System.in));
          stz = new StringTokenizer(br.readLine());
          int testcase = Integer.parseInt(stz.nextToken());
          int value = Integer.parseInt(stz.nextToken());
          ary = new int[testcase];
          for (int i = 0; i < testcase; i++) {
            ary[i] = Integer.parseInt(br.readLine());
          }
          System.out.println(solution(value, ary.length - 1, 0));
      } catch (IOException ie) {
        ie.printStackTrace();
      }
  }

  public static int solution(int value, int i, int count) {
    int result;
    if (value <= 0 || i < 0)
      return count;
    
    if (ary[i] > value){
      result =  solution(value,i-=1, count);
    }
    else {
      count += value / ary[i];
      value = value % ary[i];
      result = solution( value, i-=1, count);
    }
    return result;

  }
}
