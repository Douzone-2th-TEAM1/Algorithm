import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int count = Integer.parseInt(input[1]);
        boolean result = true;
        int MAX = 200_001;

        for (int i = 0; i < count; i++) {
            int c = Integer.parseInt(sc.nextLine());
            String[] strs = sc.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(strs[j]) > MAX)
                    result = false;
                MAX = Integer.parseInt(strs[j]);
            }
        }
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
