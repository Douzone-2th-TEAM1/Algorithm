import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[8];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        float MAX = 0, team1, team2, temp;
        int t11, t12, t21, t22;

        for (t11 = 0; t11 < input.length - 1; t11++) {
            for (t12 = t11 + 1; t12 < input.length; t12++) {
                team1 = (float) (input[t11] + input[t12]) / 2;

                for (t21 = 0; t21 < input.length - 1; t21++) {
                    for (t22 = t21 + 1; t21 < input.length; t22++) {
                        if ((t21 != t11) && (t21 != t12) && (t22 != t11) && (t22 != t12)) {
                            team2 = (float) (input[t21] + input[t22]) / 2;
                            temp = Math.abs(team1 - team2);
                            temp /= 10.0;
                            temp = 1 - temp;
                            MAX = (temp > MAX) ? temp : MAX;
                        }
                    }
                }
            }
        }
        System.out.println(MAX);
    }
}
