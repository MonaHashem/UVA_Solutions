import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ClosestSums_UVA10487 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = 0;
		while (true) {

			t++;
			int n = sc.nextInt();
			if (n == 0)
				break;
			int num[] = new int[n];
			for (int i = 0; i < n; i++)
				num[i] = sc.nextInt();

			int m = sc.nextInt();
			out.printf("Case %d:\n", t);
			while (m-- > 0) {

				int s = sc.nextInt();
				int result = num[0] + num[1];
				int min = Math.abs(s - result);
				
				
				for (int i = 0; i < n; i++)
					for (int j = i+1; j < n; j++) {
						
						int sum  = num[i] + num[j];
						int abs = Math.abs(sum - s);
						if (abs < min) {
							min = abs;
							result = sum;
						}

					}

				out.printf("Closest sum to %d is %d.\n", s, result);
			}

		}

		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
