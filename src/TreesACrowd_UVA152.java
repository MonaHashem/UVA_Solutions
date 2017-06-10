

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreesACrowd_UVA152 {

	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Point> point = new ArrayList<Point>();
		while (true) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			double z = sc.nextDouble();
			if (x == 0 && y == 0 && z == 0)
				break;
			point.add(new Point(x, y, z));

		}
		int count[] = new int[10];

		for (int i = 0; i < point.size(); i++) {

			double minDist = 1e9;

			for (int j = 0; j < point.size(); j++) {
				if (i == j)
					continue;
				double dist = point.get(i).dist(point.get(j));
				minDist = Math.min(dist, minDist);
			}
			if (minDist + EPS < 1)
				count[0]++;

			else
				for (int k = 2; k < 11; k++)
					if (minDist + EPS < k) {
						count[k - 1]++;
						break;
					}

		}

		for (int i = 0; i < 10; i++)
			if (count[i] < 10)
				out.print("   " + count[i]);
			else if (count[i] < 100)
				out.print("  " + count[i]);
			else if (count[i] < 1000)
				out.print(" " + count[i]);
			else
				out.print(count[i]);
		out.println();

		out.flush();
		out.close();
	}

	static class Point {
		double x, y, z;

		public Point(double a, double b, double c) {
			x = a;
			y = b;
			z = c;
		}

		public double dist(Point p) {

			double dx = x - p.x;
			double dy = y - p.y;
			double dz = z - p.z;

			return Math.sqrt(dx * dx + dy * dy + dz * dz);
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
