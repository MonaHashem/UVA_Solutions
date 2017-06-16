

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MaximumProduct_UVA11059 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = 0;
		while(true)
		{
			t++;
			String s = bf.readLine();
			if(s == null || s.equals(""))
				break;
			int n = Integer.parseInt(s);
			int arr [] = new int [n];
			StringTokenizer st= new StringTokenizer(bf.readLine());
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			long result = 0;
			
			for(int i = 0; i < n; i++){
				long temp = arr[i];
				result = Math.max(result, temp);
				for(int j = i+1; j < n; j++)
				{
					temp *= arr[j];
					result = Math.max(result, temp);
				}
					
			}
			out.printf("Case #%d: The maximum product is %d.\n\n",t,result);
			if(bf.readLine() == null)
				break;
		}
		
		out.flush();
		out.close();
	}

}
