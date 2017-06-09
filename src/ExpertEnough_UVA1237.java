import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class ExpertEnough_UVA1237 {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		
		int t= sc.nextInt();
		while(t-->0){
			int len= sc.nextInt();
			
			Maker maker[]= new Maker [len];
			for(int i=0; i<len; i++)
				maker[i]= new Maker(sc.next(), sc.nextInt(), sc.nextInt());
			
			int q=sc.nextInt();
			while(q-->0){
				int p= sc.nextInt();
				boolean f1= false;
				boolean f2= false;
				String man= "";
				for(int i=0; i<len; i++)
					if(p<= maker[i].high && p>= maker[i].low)
						if(f1){
							f2= true;
							break;
						}
						else {
							f1= true;
							man= maker[i].maker;
						}
				if(f2 | !f1)
					out.println("UNDETERMINED");
				else out.println(man);
			}
			
			if(t!=0)
				out.println();
		}
		
		
		out.flush();
		out.close();
	}
	
	
	static class Maker {
		String maker;
		int low,high;
		
		public Maker(String m,int l,int h){
			maker=m;
			low=l;
			high=h;
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
