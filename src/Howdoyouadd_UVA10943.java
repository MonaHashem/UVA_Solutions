
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Howdoyouadd_UVA10943 
{
	static int [][] b;
	public static int dp(int n, int k)
	{
		if(k==0)
			if(n==0)
				return 1;
			else return 0;
		int sum=0;
		if(b[n][k]!=-1)
			return b[n][k];
		for (int i=0;i<=n;i++)
			sum+=dp(n-i,k-1);
		return b[n][k]=(sum%1000000);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		StringBuilder sb= new StringBuilder ("");
		int n= Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		b=new int [101][101];
		for(int i=0;i<=100;i++)
				Arrays.fill(b[i], -1);
		
		while(n!=0 || k!=0)
		{
			int ans=dp(n,k);
			sb.append(ans+ "\n");
			st= new StringTokenizer(bf.readLine());
			n= Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
		}
		
		System.out.print(sb);
		

	}

}
