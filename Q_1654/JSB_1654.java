package solution;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		long min = 1;
		long max = 0;

		Scanner in = new Scanner(System.in);

		int k = in.nextInt();
		int n = in.nextInt();

		int[] kLanArray = new int[k];

		for (int i = 0; i < k; i++) {
			kLanArray[i] = in.nextInt();
			max = Math.max(max, kLanArray[i]);
		}

		while (min <= max) {
			long lanLength = (min + max) / 2;
			long lanCount = 0;
			for (int i = 0; i < k; i++) {
				lanCount += kLanArray[i] / lanLength;
			}
			if (lanCount >= n)
				min = lanLength + 1;
			else
				max = lanLength - 1;
		}
		System.out.println(max);
	}
}
