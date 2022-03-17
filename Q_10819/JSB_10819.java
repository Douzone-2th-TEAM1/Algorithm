import java.util.Scanner;
 
public class Main {
 
    static int num;
    static int[] arr, arr2;
    static boolean[] temp;
    static int output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        output = 0;
        num = sc.nextInt();
        arr = new int[num];
        arr2 = new int[num];
        temp = new boolean[num];
 
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
 
        recursive(0);
        System.out.println(output);
 
    }
 
    private static void recursive(int index) {
 
        if (index == num) {
            int sum = 0;
            for (int i = 0; i < num - 1; i++)
                sum += Math.abs(arr2[i] - arr2[i + 1]);
            output = Math.max(result, sum);
            return;
        }
 
        for (int i = 0; i < num; i++) {
            if (temp[i] == true)
                continue;
            temp[i] = true;
            arr2[index] = arr[i];
            recursive(index + 1);
            temp[i] = false;
        }
 
    }
}
