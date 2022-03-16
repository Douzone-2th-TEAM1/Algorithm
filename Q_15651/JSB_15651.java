import java.io.*;

public class Main {
    static int n, m;
    static String[] array;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        array = new String[m];
        
        backtracking(0);
        bw.flush();
    }
    
    private static void backtracking(int cnt) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                bw.write(array[i] + " ");
            }
            bw.newLine();
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            array[cnt] = i + "";
            backtracking(cnt + 1);
        }
    }
  }