package BOJ_3568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    static String arr[];
 
    public static void main(String[] args) throws IOException {
 
        arr = new String[120];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = st.countTokens();
        for (int i = 0; i < count; i++) {
 
            arr[i] = st.nextToken();
 
        }
        for (int i = 1; i < count; i++) {
 
            String str1 = "";
            String str2 = "";
            for (int j = 0; j < arr[i].length() - 1; j++) {
                if ((arr[i].charAt(j) >= 65 && arr[i].charAt(j) < 91)
                        || (arr[i].charAt(j) >= 97 && arr[i].charAt(j) < 123)) {
                    str1 += arr[i].charAt(j);
                } else if (arr[i].charAt(j) == '[') {
                    str2 = "[]" + str2;
                    j++;
                } else {
                    str2 = arr[i].charAt(j) + str2;
                }
 
            }
            System.out.println(arr[0] + str2 + " " + str1 + ";");
        }
 
    }
 
}
