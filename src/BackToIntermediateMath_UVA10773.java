
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class  BackToIntermediateMath_UVA10773{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(bf.readLine());
		PrintWriter out= new PrintWriter(System.out);
		
		for(int c=1; c<=t; c++){
			
			StringTokenizer st= new StringTokenizer (bf.readLine());
			double d= Double.parseDouble(st.nextToken());
			double v= Double.parseDouble(st.nextToken());
			double u= Double.parseDouble(st.nextToken());
			
			if (v >= u || u == 0 || v == 0) 
				out.printf("Case %d: can't determine\n",c);
			
			else{
			
				double sin = Math.sqrt(u * u - v * v);
				double t1 = d / sin;
				double t2 = d / u;
				if(t1-t2==0)
					out.printf("Case %d: can't determine\n",c);
				else
					out.printf("Case %d: %.3f\n",c,Math.abs(t1-t2));
				
			}
		}
		out.flush();
		out.close();
	}

}
