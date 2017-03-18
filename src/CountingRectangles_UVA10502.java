
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CountingRectangles_UVA10502 {
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		PrintWriter out= new PrintWriter(System.out);
		
		int r= sc.nextInt();
		while(r!=0){
			int c= sc.nextInt();
			boolean grid[][]= new boolean [r][c];
			
			for(int i=0; i<r; i++){
				char ch[]= sc.nextLine().toCharArray();
				for(int j=0; j<c; j++)
					if(ch[j]=='1')
						grid[i][j]= true;
			}
			
			int hcomm[][]= new int [r][c];
			int vcomm[][]= new int [r][c];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++){
					
					
					if(j==0)
						hcomm[i][j]=grid[i][j]?1:0;
					else
						hcomm[i][j]= grid[i][j]?hcomm[i][j-1]+1:hcomm[i][j-1];
						
					if(i==0)
						vcomm[i][j]=hcomm[i][j];
					else
						vcomm[i][j]= vcomm[i-1][j]+hcomm[i][j];
				}
			
			int count=0;
			
			for(int i1=0; i1<r; i1++)
				for(int j1=0; j1<c;j1++){
					if(!grid[i1][j1])
						continue;
					for(int i2=i1; i2<r;i2++)
						for(int j2=j1; j2<c; j2++){
							
							int hdiff= j2-j1+1;
							int vdiff= i2-i1+1;
							
							int area= hdiff*vdiff;
							
							int available= vcomm[i2][j2];
							if(i1!=0)
								available-=vcomm[i1-1][j2];
							if(j1!=0)
								available-=vcomm[i2][j1-1];
							if(i1!=0 && j1!=0)
								available+= vcomm[i1-1][j1-1];
							
							if(available==area){
								count++;
							}
						}
				}
					
					

			
			
			out.println(count);
			r= sc.nextInt();
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
