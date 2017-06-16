
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class Satellites_UVA10221 {

	
	static double arc(double rad, int r){ return r * rad; }
	static double chord(double rad, int r){ return 2 * r * Math.sin(rad/2); }
	static double toRad (double deg) { return deg * Math.PI / 180; }
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(true){
			String s = bf.readLine();
			if(s == null || s.equals(""))
				break;
			StringTokenizer st = new StringTokenizer (s);
			int r = Integer.parseInt(st.nextToken()) +6440;
			double angle = Integer.parseInt(st.nextToken());
			if(st.nextToken().charAt(0) == 'm')
				angle/=60;
			
			if(angle % 360 > 180)
				angle = 360 - angle%360;
			
			angle = toRad(angle);
			out.printf("%.6f %.6f\n", arc(angle,r), chord(angle,r));
			
		}
		
		
		
		out.flush();
		out.close();
	}
	
	

	
}
