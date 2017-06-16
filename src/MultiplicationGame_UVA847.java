
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MultiplicationGame_UVA847 { 
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out= new PrintWriter(System.out);
		String s= bf.readLine();
		
		while(s!=null && !s.equals("")){
			long n= Long.parseLong(s);
			long start=1;
			boolean win=false;
			while(start<n){
				if(!win)
					start*=9;
				else start*=2;
				win= !win;
			}
			if(win)
				out.println("Stan wins.");
			else 
				out.println("Ollie wins.");
			s= bf.readLine();
		}
		
		out.flush();
		out.close();
		
	}

}
