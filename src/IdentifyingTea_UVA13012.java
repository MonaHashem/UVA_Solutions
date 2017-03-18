
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class IdentifyingTea_UVA13012 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String s= bf.readLine();
		PrintWriter out= new PrintWriter(System.out);
		
		while(s!=null && !s.equals("")){
			int result=0;
			int corr= Integer.parseInt(s);
			StringTokenizer st= new StringTokenizer(bf.readLine());
			for(int i=0; i<5; i++)
				if(Integer.parseInt(st.nextToken())==corr)
					result++;
			out.println(result);
			s= bf.readLine();
		}
		
		out.flush();
		out.close();
	}

}
