package BOJ_17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String string = br.readLine();
            sb.append(method(string, 0) + "\n");
        }
        System.out.println(sb);
    }

    static int method(String str, int count) {

        int l = 0;
        int r = str.length() - 1;
        int m = str.length() / 2;
        
        for (int i = 0; i < m; i++, l++, r--) {

            if (str.charAt(l) != str.charAt(r)) { // 투포인터가 가리키는 값이 서로 다르면
                if (count == 0) {                 // 한번은 봐줌
                    
                    String substr1;
                    substr1 = str.substring(0,l) + str.substring(l+1,str.length());
                    if (method(substr1, 1) == 2) {       // 근데 또 틀렸다?

                        String substr2;
                        substr2 = str.substring(0, r) + str.substring(r+1,str.length());
                        if (method(substr2, 1) == 2) {   // 얘도 틀렸으면 진짜 끝
                            return 2;   // 회문 X
                        } else {
                            return 1;   // substr2 유사 회문
                        }

                    } else {
                        return 1;       // substr1 유사 회문
                    }

                } else {                // 두번은 없다
                    count++;            // count = 2
                    break;              // 최하단 return count로
                }
            }
        }
        return count;
    }
}
