import java.util.*;
import java.io.*;

public class Main {
    static int num1, num2, num3, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num1 = Integer.parseInt(br.readLine());
        num2 = Integer.parseInt(br.readLine());
        num3 = Integer.parseInt(br.readLine());
        result = num1 * num2 * num3;
        String str = Integer.toString(result);

        for (int i = 0; i <= 9; i++) {
            result = 0;
            for (int k = 0; k < str.length(); k++) {
                if (Character.getNumericValue(str.charAt(k)) == i)
                    result++;
            }
            System.out.println(result);
        }
    }
}
