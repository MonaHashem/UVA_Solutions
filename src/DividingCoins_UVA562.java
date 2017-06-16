
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DividingCoins_UVA562 { 

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-- >0)
		{
			int n = sc.nextInt();
			if(n ==0){
				out.println(0);
				continue;
			}
			int [] coins = new int [n];
			int sum = 0;
			for(int i = 0; i < n; i++)
			{
				coins [i] = sc.nextInt();
				sum += coins[i];
			}
			int w = sum/2;
			boolean max [] = new boolean [w+1];
			max [0] = true;
			
			for(int i = 0; i < n; i++){	
				for (int j = w; j >= 0; j--){
					if(j + coins [i] < w + 1 && max[j])
						max [j + coins[i]] = true;
				
				}
			}
			
			int mx = 0;
			for(int i = 0; i < w + 1; i++)
				if(max[i])
					mx = i;
			out.println((w - mx)*2 + sum%2);
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
