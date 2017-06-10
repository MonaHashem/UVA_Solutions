
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class AnEasyTask_UVA11068 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true)
		{
			int a1 = sc.nextInt();
			int b1 = sc.nextInt();
			int c1 = sc.nextInt();
			int a2 = sc.nextInt();
			int b2 = sc.nextInt();
			int c2 = sc.nextInt();
			
			if(a1 == 0 && a2 == 0 && b1 == 0 && b2 == 0 && c1 == 0 && c2 == 0)
				break;
			Line l1 = new Line(a1,b1,c1);
			Line l2 = new Line(a2,b2,c2);
			
			if(l1.same(l2) || l1.parallel(l2))
				out.println("No fixed point exists.");
			else {
				Point inter = l1.intersect(l2);
				double x = Math.round(inter.x*100)/100.0;
				double y = Math.round(inter.y*100)/100.0;
		
				out.printf("The fixed point is at %.2f %.2f.\n", x , y);
			}
		}
		
		
		out.flush();
		out.close();
	}

	
	static class Point{

		double x,y;
		
		public Point(double a, double b){ x = a; y = b; }
		
	}
	
	static class Line {
		
		static final double EPS = 1e-9;
		
		double a,b,c;
		
		public Line (int x, int y, int z)
		{
			if(Math.abs(y) < EPS)
			{
				a = 1;
				b = 0;
				c = -z * 1.0 / x;
			}
			else
			{
				a = x * 1.0 / y;
				b = 1;
				c = -z * 1.0 / y;
			}
		}
		
		boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
		
		boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
		
		public Point intersect(Line l)
		{
			if (parallel(l))
				return null;
			
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			
			if(Math.abs(b) < EPS)
				 y = -l.a * x - l.c;
			else
				y = -a * x - c;
			
			return new Point(x, y);
		}
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
