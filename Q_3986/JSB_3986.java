import java.io.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			String pattern1 = "AA";
			String pattern2 = "BB";
            
			while(true) {
				if(!line.contains(pattern1)&& !line.contains(pattern2)) break;
				if(line.contains(pattern1)) {
					line = line.replaceAll(pattern1, "");
				}
				if(line.contains(pattern2)) {
					line = line.replaceAll(pattern2, "");
				}
			}
			if(line.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
