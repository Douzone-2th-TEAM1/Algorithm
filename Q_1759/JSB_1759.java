package JSB;

import java.io.*;
import java.util.*;

public class JSB_1759 {

	static int L, C;
	static String[] alphas;
	static int[] combs;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alphas = br.readLine().split(" "); // 입력
        
		Arrays.sort(alphas); // 정렬

		combs = new int[L];
		comb(0, 0);
		System.out.println(sb);
	}

	static void comb(int cnt, int start) {
		if (cnt == L) {
			if (isPW(combs)) {
				for (int i = 0; i < combs.length; i++) {
					sb.append(alphas[combs[i]]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			combs[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static boolean isPW(int[] comb) {
		int v = 0, c = 0;
		for (int i = 0; i < comb.length; i++) {
			if (alphas[comb[i]].equals("a") || alphas[comb[i]].equals("e") || alphas[comb[i]].equals("i")
					|| alphas[comb[i]].equals("o") || alphas[comb[i]].equals("u")) {
				v++;
			} else {
				c++;
			}
			if (v > 1 && c > 2) // 자음 2개, 모음 1개 이상일 때만
				return true;
		}

		if (v < 1 || c < 2)
			return false;
		return true;
	}
}