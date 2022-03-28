import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{
        int y, x, w;
        public Edge(int y, int x, int w){
            this.y=y;
            this.x=x;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o) {
            return w-o.w;
        }
    }
    static boolean[][] visit;
    static int[][] table;
    
    static int m, n;
    
    static Queue<Edge> Q = new PriorityQueue<>();
    
    static int[] Y = {-1, 1, 0, 0};
    static int[] X = {0, 0, -1, 1};

    static int output = 0;
    
    static void Dijkstra(){

        while(!Q.isEmpty()){
        
            Edge edge = Q.poll();
            
            int y = edge.y;
            int x = edge.x;
            int w = edge.w;

            for(int a=0; a<4; a++) {
                int ny = y + Y[a];
                int nx = x + X[a];

                if ((ny >= 0 && ny < n) && (nx >= 0 && nx < m) && !visit[ny][nx]){
                    visit[ny][nx] = true;
                    if(table[ny][nx] > w)
                        Q.add(new Edge(ny, nx, table[ny][nx]));
                    else if(table[ny][nx] <= w){
                        output += w - table[ny][nx];
                        Q.add(new Edge(ny, nx, w));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        table = new int[n][m];
        visit = new boolean[n][m];

         for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    visit[i][j] = true;
                    Q.add(new Edge(i, j, table[i][j]));
                }
            }
        }

         Dijkstra();
         System.out.println(output);
    }
}