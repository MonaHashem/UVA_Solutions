import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class IntegerSequenceFromAdditionOfTerms_UVA927 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out= new PrintWriter(System.out);
		
		int t= Integer.parseInt(bf.readLine());
		
		while(t-->0){
			
			StringTokenizer st= new StringTokenizer(bf.readLine());
			int len= Integer.parseInt(st.nextToken())+1;
			int [] coeff= new int [len];
			for(int i=0; i<len; i++)
				coeff[i]= Integer.parseInt(st.nextToken());
			int d= Integer.parseInt(bf.readLine());
			int k= Integer.parseInt(bf.readLine());
			
			int n=1;
			
			while(true){
				k-= d*n;
				if(k<=0)
					break;
				n++;
			}
			long result=0;
			long mult=1;
			for(int i=0; i<len; i++){
				result+= coeff[i]*mult;
				mult*=n;
			}
			out.println(result);
		}
		
		out.flush();
		out.close();
	}
	
	
}
