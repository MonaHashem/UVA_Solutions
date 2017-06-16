

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BackToHighSchoolPhysics_UVA10071
{
	public static void main (String [] args) throws NumberFormatException,  IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		String ns;
		int v,t;
		String [] s= new String [2];
		ns= bf.readLine();
		while(ns !=null)
		{

			s= ns.split(" ");
			v= Integer.parseInt(s[0]);
			t= Integer.parseInt(s[1]);
			System.out.println(2*v*t);
			ns= bf.readLine();

		}



	}


}