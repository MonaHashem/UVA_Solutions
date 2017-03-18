
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class DAsInDaedalus_UVA13007 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String s= bf.readLine();
		PrintWriter out= new PrintWriter(System.out);
		int cards[]= {1, 10, 100, 1000, 10000};
		
		while(s!=null && !s.equals("")){
			StringTokenizer st= new StringTokenizer(s);
			int n= Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			int result=0;
			for(int i=0; i<m; i++){
				st= new StringTokenizer(bf.readLine());
				int b= Integer.parseInt(st.nextToken());
				int sum=Integer.parseInt(st.nextToken());
				int d= sum;
				for(int j=1; j<n; j++)
					sum+=Integer.parseInt(st.nextToken());
				int points= sum<=b? d:0;
				int max=0;
				sum-=d;
				for(int j=0; j<5; j++){
					int x= cards[j];
					if(x==d)
						continue;
					max=Math.max(max, sum+x<=b?x-points:0);
					
				}
				result+=max;
			}
			out.println(result);
			s=bf.readLine();
			
		}
		
		out.flush();
		out.close();
	}

}
