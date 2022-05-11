import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0]; int M = info[1];
        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<M; i++){
            int dummy = Integer.parseInt(br.readLine());
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(data);
        }

        for(int[] s: list){
            if(getResult(s) == false){
                System.out.print("No");
                System.exit(0);
            }
        }
        System.out.print("Yes");
    
    }

    public static boolean getResult(int[] stack){
        int t = stack[stack.length -1];
        boolean flag = true;
        for(int i=stack.length-2; i>=0; i--){
            if(t > stack[i]){
                flag = false;
                break;
            }else{
                t=stack[i];
            }
        }
        return flag;
    }
}
