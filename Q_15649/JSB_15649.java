package solution;

import java.util.*;

public class JSB_15649 {
	static int[] list;
	static int[] check;
	static int m, n;

	static void dfs(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println("");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (check[i] == 1)
				continue;
			check[i] = 1;
			list[cnt] = i;
			dfs(cnt + 1);
			check[i] = 0;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		check = new int[9];
		list = new int[9];

		dfs(0);

	}
}