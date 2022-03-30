import java.util.*;
import java.io.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String input = "";
        for (int i = 0; i < T; i++) {
            input = br.readLine();
            System.out.println(check(input));
        }
    }

    public static int check(String input) {
        int output = 0;
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                output++;
                if (output == 2)
                    break;
                if ((input.charAt(left) == input.charAt(right - 1))
                        || (input.charAt(left + 1) == input.charAt(right))) {
                    if (check(input.substring(left + 1, right + 1)) == 0) {
                        left++;
                    } else if (check(input.substring(left, right)) == 0) {
                        right--;
                    }
                } else {
                    output++;
                    break;
                }
            }
        }
        return (output);
    }
}
