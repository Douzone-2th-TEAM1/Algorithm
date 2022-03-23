import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
      int M = Integer.parseInt(br.readLine());
      int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      StringBuffer sb = new StringBuffer();

      for(int item : find){
        sb.append(upper_bound(item, array) - lower_bound(item, array) + " ");
      }
      System.out.println(sb);
    }
    
    public static int lower_bound( int k, int[] a ) { 
        int start = 0, end = a.length-1, mid; 
        while( start < end ) { 
            mid = (start+end)/2; 
            if( a[mid] >= k ) end = mid; 
            else start = mid+1; 
            
        } 
        return end; 
        
    } 
    public static int upper_bound( int k, int[] a ) {
        int start = 0, end = a.length-1, mid; 
        while( start < end ) { 
            mid = (start+end)/2; 
            if( a[mid] > k ) end = mid; 
            else start = mid+1; 
            
        } 
        if( a[end] == k ) end++;
        return end; 
        
    }
}
