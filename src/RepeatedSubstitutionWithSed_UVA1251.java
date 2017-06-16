

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class RepeatedSubstitutionWithSed_UVA1251 {

	static int n, len;
	static Pair pairs[];
	static String target;
	static TreeMap<String, Integer> memo;
	
	
	static int dp(String s)
	{
		int slen = s.length();
		if(s.equals(target))
			return 0;
		if(slen > len)
			return -1;
		
		if(memo.containsKey(s))
			return memo.get(s);
		
		StringBuilder sb = new StringBuilder("");
		int result = 100000000;
		for(int i = 0; i < n; i++)
		{
			int pairlen = pairs[i].f.length();
			sb = new StringBuilder("");
			int c = 0;
			int changed = 0;
			
			while(c  < slen)
			{
				if(c + pairlen <= slen && s.substring(c, c+pairlen).equals(pairs[i].f))
				{
					sb.append(pairs[i].sec);
					c+= pairlen;
					changed++;
				}
				else
				{
					sb.append(s.charAt(c++));
				}
				
			}
			if(changed!=0)
			{
				int temp = dp(sb.toString());
				if(temp!=-1)
					result = Math.min(result, temp + 1);
			}
			
		}
		
		if(result == 100000000)
			result = -1;
		memo.put(s, result);
		return result;
			
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String s = bf.readLine();
			n = Integer.parseInt(s);
			if(n == 0)
				break;
			pairs = new Pair [n];
			for(int i = 0; i < n; i++){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				pairs[i] = new Pair(st.nextToken(),st.nextToken());
			}
			String start = bf.readLine();
			target = bf.readLine();
			len = target.length();
			memo = new TreeMap<String, Integer>();
			out.println(dp(start));
		}
		
		out.flush();
		out.close();
	}
	
	
	static class Pair
	{
		String f,sec;
		
		public Pair(String a, String b){ f = a; sec = b; }
	}
}
