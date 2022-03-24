import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static int N, M, key;
    static int l, h, m;
    static int[] all;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        
        all = new int[N];
        
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            all[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(all);

        M = Integer.parseInt(br.readLine());
      
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            key = Integer.parseInt(st.nextToken());
            sb.append(upperBoundBin(all, key) - lowerBoundBin(all, key)).append(" ");
        }
        System.out.println(sb);
    }

    static int lowerBoundBin(int[] arr, int key) {

        l=0;
        h=arr.length;

        while (l<h) {
            m = (l+h)/2;

            if(key<=arr[m]) { // 하한 경계값
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    static int upperBoundBin(int[] arr, int key) {

        l=0;
        h=arr.length;

        while (l<h) {
            m = (l+h)/2;

            if(key<arr[m]) { // 상한 경계값
                h = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
