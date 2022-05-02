import java.util.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int min_pp = sc.nextInt(); // 6개 패키지 최소 가격
        int min_up = sc.nextInt(); // 낱개 최소 가격
        int temp;
        for (int i = 1; i < M; i++) {
            temp = sc.nextInt();
            min_pp = (min_pp > temp) ? temp : min_pp;
            temp = sc.nextInt();
            min_up = (min_up > temp) ? temp : min_up;
        }
        min_pp = (min_pp > min_up * 6) ? min_up * 6 : min_pp;

        while (N >= 6) {
            N -= 6;
            result += min_pp;
        }
        if (N * min_up > min_pp)
            result += min_pp;
        else
            result += N * min_up;

        System.out.println(result);
        sc.close();
    }
}
