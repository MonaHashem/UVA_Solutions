import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Stones_UVA12469 {
	
	
	static int memo[][];
	
	static int dp(int n, int prev){
		if(prev>n/2+1)
			prev= n/2+1;
		
		if(memo[n][prev]!=-1)
			return memo[n][prev];
		
		int max= Math.min(prev*2, n);
		
		for(int i=1; i<=max; i++)
			 if(dp(n-i,i)==0)
				 return memo[n][prev]=1;
			
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		
		int n= sc.nextInt();
		memo= new int [1001][502];
		
		for(int i=0; i<1000; i++)
			Arrays.fill(memo[i], -1);
		
		while(n!=0){
			int result=0;
			for(int i=1;i<n; i++)
				if(dp(n-i,i)==0)
					result=1;
			
			if(result==1)
				out.println("Alicia");
			else
				out.println("Roberto");
				
			n= sc.nextInt();
		}
		
		
		out.flush();
		out.close();
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
