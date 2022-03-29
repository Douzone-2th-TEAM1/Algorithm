package solution;

import java.util.Scanner;

public class JSB_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		for (int i = 97; i <= 122; i++) {
			for (int k = 0; k < input.length(); k++) {
				if (input.charAt(k) == i) {
					System.out.print(input.indexOf(i));
					break;
				}
				if (k == input.length() - 1) {
					System.out.print("-1");
				}
			}
			System.out.print(" ");
		}
		sc.close();
	}
}