
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AntsShoppingMall_UVA12498 {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		
		int t= sc.nextInt();
		for(int cs=1; cs<=t; cs++){
			int r= sc.nextInt();
			int c= sc.nextInt();
			boolean grid[][]= new boolean [r][c];
			int min= r*c;
			for(int i=0; i<r; i++){
				char ch[]= sc.nextLine().toCharArray();
				if(min==-1)
					continue;
				int  full=0;
//				
				for(int j=0; j<c; j++){
					
					if(ch[j]=='1'){
						full++;
						grid[i][j]=true;
					}
				}
				if(full==c)
					min=-1;
					
					
				
					
				
			}
			
			if(min!=-1){
				for(int j=0; j<c; j++){
					int count=0;
					for(int i=0; i<r; i++){
						int countTemp=c;
						if(!grid[i][j])
							continue;
						for(int k=0; k<c; k++)
							if(!grid[i][k])
								countTemp= Math.min(countTemp, Math.abs(k-j));
						count+= countTemp;
						
						
						
					}
					min= Math.min(min, count);
				}
				
			}
			
			
			out.printf("Case %d: %d\n",cs,min);
			
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
