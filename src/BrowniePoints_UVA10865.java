
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BrowniePoints_UVA10865 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				break;
			Point points [] = new Point [n];
			int mid = n/2 ;
			int x = 0;
			int y = 0;
			for(int i = 0; i < mid; i++)
				points [i] = new Point (sc.nextInt(),sc.nextInt());
			x = sc.nextInt();
			y = sc.nextInt();
			points[mid] = new Point(x,y);
			
			for(int i = mid + 1; i < n; i++)
				points [i] = new Point (sc.nextInt(), sc.nextInt());
			
			
			int ss = 0, so = 0;
			
			for (int i = 0; i < n; i++)
			{
				Point p = points[i];
				if((p.x > x && p.y > y) || (p.x < x && p.y < y))
					ss++;
				else
					if((p.x < x && p.y > y) || (p.x > x && p.y < y))
						so++;
			}
				
			out.println(ss + " " +so);
			
		}

		out.flush();
		out.close();
	}
	
	static class Point 
	{
		int x, y;
		
		public Point (int a,int b){ x = a; y = b; }
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
