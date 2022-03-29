import java.util.Scanner;

public class JSB_1541 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n[] = in.next().split("-");
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < n.length; i++) {
            int temp = 0;
            String cal[] = n[i].split("\\+");
            for (int j = 0; j < cal.length; j++) {
                temp += Integer.parseInt(cal[j]);
            }
            if (sum == Integer.MAX_VALUE)
                sum = temp;
            else
                sum -= temp;
        }
        System.out.println(sum);
        in.close();
    }
}
// 도저히 풀이법이 떠오르지 않아 구글을 참조하였습니다. ㅜㅜ