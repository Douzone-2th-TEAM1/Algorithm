import java.util.*;
import java.io.*;

public class Main {
    static int sum = 0, f1, f2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[9];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        int err = sum - 100;
        Arrays.sort(input);
        for (int i = 0; i < input.length - 1; i++) {
            for (int k = i + 1; k < input.length; k++) {
                if ((input[i] + input[k]) == err) {
                    f1 = i;
                    f2 = k;
                    break;
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            if ((i != f1) && (i != f2)) {
                System.out.println(input[i]);
            }
        }
    }
}
