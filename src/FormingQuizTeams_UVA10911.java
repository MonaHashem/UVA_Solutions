
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class  FormingQuizTeams_UVA10911{
	
	static Pair dist[];
	static double memo[];
	static int len;
	
	public static double dp(int mask){
		if(mask==((1<<len)-1))
			return 0;
		if(memo[mask]!=-1)
			return memo[mask];
		
		double min= 100000000;
		for(int i=0; i<len; i++)
			if((mask&(1<<i))==0)
				for(int j=i+1; j<len; j++)
					if((mask&(1<<j))==0){
						int temp= mask | (1<<j);
						temp= temp|(1<<i);
						double d= dist[i].diff(dist[j])+dp(temp);
						min= Math.min(min,d);
					}
		return memo[mask]=min;
			
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		PrintWriter out= new PrintWriter(System.out);
		for(int c=1; n!=0; c++){
			dist= new Pair[n*2];
			memo= new double[1<<(n*2)];
			len= n*2;
			for(int i=0; i<n*2; i++){
				sc.next();
				dist[i]=new Pair(sc.nextInt(),sc.nextInt());
			}
			Arrays.fill(memo, -1);
			out.printf("Case %d: %.2f\n",c,dp(0));
			
			n= sc.nextInt();
		}
		out.flush();
		out.close();
	}
	
	static class Pair{
		int x; 
		int y;
		public Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
		double diff(Pair p){
			int dx= x-p.x;
			int dy= y-p.y;
			return Math.sqrt(dx*dx+dy*dy);
		}
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}

}
