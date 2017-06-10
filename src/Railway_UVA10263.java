

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Railway_UVA10263 {

	static final double EPS = 1e-9;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String s = bf.readLine();
			if (s == null || s.equals(""))
				break;
			Point m = new Point(Double.parseDouble(s), Double.parseDouble(bf.readLine()));
			int n = Integer.parseInt(bf.readLine());
			Line[] lines = new Line[n];
			double minDist = 1e9;
			Point result = null;
			Point p = new Point(Double.parseDouble(bf.readLine()), Double.parseDouble(bf.readLine()));

			for (int i = 0; i < n; i++) 
			{
				Point q = new Point(Double.parseDouble(bf.readLine()), Double.parseDouble(bf.readLine()));
				lines[i] = new Line(p, q);
				Point closest = lines[i].closestPoint(m);
				double distp = m.dist(p);
				double distq = m.dist(q);
				double dist = Math.min(distp, distq);
				if (closest.between(p, q))
					dist = m.dist(closest);

				if (dist + EPS < minDist) 
				{
					minDist = dist;
					result = (closest.between(p, q) ? closest : (distp < distq) ? p : q);
				}
				p = q;
			}
			out.printf("%.4f\n%.4f\n", result.x, result.y);
		}
		out.flush();
		out.close();

	}

	static class Point {

		static final double EPS = 1e-9;

		double x, y;

		Point(double a, double b) {
			x = a;
			y = b;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
		}

		

		boolean between(Point p, Point q) {
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x) && y < Math.max(p.y, q.y) + EPS
					&& y + EPS > Math.min(p.y, q.y);
		}
	

	}

	static class Line {

		static final double INF = 1e9, EPS = 1e-9;

		double a, b, c;

		Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1;
				b = 0;
				c = -p.x;
			} else {
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}

		}

		Line(Point p, double m) {
			a = -m;
			b = 1;
			c = -(a * p.x + p.y);
		}

		boolean parallel(Line l) {
			return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS;
		}

		boolean same(Line l) {
			return parallel(l) && Math.abs(c - l.c) < EPS;
		}

		Point intersect(Line l) {
			if (parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if (Math.abs(b) < EPS)
				y = -l.a * x - l.c;
			else
				y = -a * x - c;

			return new Point(x, y);
		}

		Point closestPoint(Point p) {
			if (Math.abs(b) < EPS)
				return new Point(-c, p.y);
			if (Math.abs(a) < EPS)
				return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}

	}

	
}
