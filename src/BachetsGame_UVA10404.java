import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BachetsGame_UVA10404 { // don't need second parameter in memo

	static int arr[];
	static int m;
	static int memo[][];


	static int dp(int n) {

		
		for (int i = 0; i <= n; i++) {
			for (int p = 0; p <= 1; p++)
				for (int j = 0; j < m; j++)
					if (i + arr[j] <= n)
						memo[i + arr[j]][1 - p] |= (1 - memo[i][p]);
		}
		

		
		return memo[n][0] == 1 ? 1 : 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s = bf.readLine();
		while (s != null && !s.equals("")) {
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[m];
			memo = new int[n + 1][2];

			for (int i = 0; i < m; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			if (dp(n) == 1)
				out.println("Stan wins");
			else
				out.println("Ollie wins");
			s = bf.readLine();
		}

		out.flush();
		out.close();
	}

}
