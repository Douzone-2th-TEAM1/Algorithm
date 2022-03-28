package BOJ_10809;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int cnt = 0;
        int[] asc = new int[26];
        for (int i = 0; i < 26; i++) {
            asc[i] = -1;
        }
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            int ch2 = (int) ch;
            int ch3 = ch2 - 97;
            if (asc[ch3] == -1) {
                asc[ch3] = cnt++;
            } else {
                cnt = cnt + 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(asc[i]);
            System.out.print(" ");
        }
        sc.close();
    }
}
