import java.util.*;
import java.io.*;

public class Main {
    static int num;
    static String line, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        line = br.readLine();
        char[][] array = new char[line.length()][num];
        int t = 0;

        for (int i = 0; i <= (line.length() / num); i++) {
            if (i % 2 == 0) {
                for (int k = 0; k < num; k++) {
                    array[i][k] = line.charAt(t++);
                }
            } else {
                for (int k = num - 1; k >= 0; k--) {
                    array[i][k] = line.charAt(t++);
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int k = 0; k <= (line.length() / num); k++) {
                System.out.print(array[k][i]);
            }
        }
    }
}
