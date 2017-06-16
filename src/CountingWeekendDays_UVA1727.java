
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CountingWeekendDays_UVA1727 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(bf.readLine());
		PrintWriter out= new PrintWriter(System.out);
		while(t-->0){
			StringTokenizer st= new StringTokenizer(bf.readLine());
			String m= st.nextToken();
			int totaldays=0;
			switch (m){
			case "JAN": totaldays= 31;break;
			case "FEB": totaldays= 28;break;
			case "MAR": totaldays= 31;break;
			case "APR": totaldays=30;break;
			case "MAY": totaldays=31;break;
			case "JUN": totaldays=30;break;
			case "JUL": totaldays=31;break;
			case "AUG": totaldays=31;break;
			case "SEP": totaldays=30;break;
			case "OCT": totaldays=31;break;
			case "NOV": totaldays=30;break;
			case "DEC": totaldays=31;break;
			}
			String day= st.nextToken();
			int d= 0;
			switch(day){
			case "SAT": d=6;break;
			case "SUN": d=0;break;
			case "MON": d=1;break;
			case "TUE": d=2;break;
			case "WED": d=3;break;
			case "THU": d=4;break;
			case "FRI": d=5;break;
			}
			int result= totaldays/7*2;
			if(totaldays%7!=0){
				int days= (totaldays%7+d);
				if(d<6){
				if(days==6)
					result++;
			
				else if(days>=7)
					result+=2;
				}
				else if(d==5 && totaldays%7>=2)
					result+=2;
				else if(d==5 && totaldays%7==1)
					result+=1;
				else if(d==6 && totaldays%7>=1)
					result+=1;
			}
			
			out.println(result);
		}
		out.flush();
		out.close();
	}

}
