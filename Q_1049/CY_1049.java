import java.util.Arrays;
import java.util.Scanner;

public class Q_1049 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int Min = Integer.MAX_VALUE;

    int[] pack =  new int[M];
    int[] unit = new int[M];

    for (int i = 0; i < M; i++) {
      pack[i] = sc.nextInt(); // 패키지 가격
      unit[i] = sc.nextInt(); // 낱개 가격
    }

    Arrays.sort(unit);
    Arrays.sort(pack);

    //가장 싼 6개짜리 팩 구매 vs 가장 싼 낱개 구매 vs (가장싼 6개짜리 팩 + 낱개)
    Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);    
    Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);
    
    System.out.println(Min);
  }
}
