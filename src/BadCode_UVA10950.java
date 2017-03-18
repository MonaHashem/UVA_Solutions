
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class BadCode_UVA10950 {
	
	static class Char implements Comparable<Char>{
		char c;
		int x;
		public Char (char ch, int y){
			c= ch;
			x=y;
		}
		
		public int compareTo(Char y) {
			
			return this.c- y.c;
		}
		
		
	}
	
	
	static char [] ch;
	static int len;
	static Char[] chars;

	static PrintWriter out;
	static int count;
	
	static void result(int start,StringBuilder sb){
		
		if(count==100)
			return;
		
		if(start==len){
			out.print(sb+"\n");
			count++;
			return;
		}
		
		if(start>len)
			return;
		
		if(ch[start]=='0')
			start++;
		
		if(start==len)
			return;
		
		for(int i=0; i<chars.length; i++){
			int x= chars[i].x;
			StringBuilder temp= new StringBuilder (sb);
			if(x<10)
				if(ch[start]-'0'==x){
					result(start+1,temp.append(chars[i].c));
					if(count==100)
						return;
				}
			
			if(x>=10 && start<len-1)
				if(((ch[start]-'0')*10+(ch[start+1]-'0'))==x){
					
					result(start+2, temp.append(chars[i].c));
					if(count==100)
						return;
				}
		}
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc= new Scanner(System.in);
		out= new PrintWriter(System.out);
		
		int c= sc.nextInt();
		int cs=1;
		while(c!=0){
			count=0;
			 chars= new Char [c];
			for(int i=0; i<c; i++){
				
				char charac= sc.next().charAt(0);
				int x= sc.nextInt();
				chars[i]= new Char(charac, x);
				
			}
			Arrays.sort(chars);
			
			
			ch= sc.nextLine().toCharArray();
			len= ch.length;
			out.printf("Case #%d\n",cs++);
			result(0,new StringBuilder(""));
			out.println();
			c= sc.nextInt();
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
