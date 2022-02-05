package kattis;

//https://open.kattis.com/contests/mziyzd/problems/sretan

import java.util.*;

public class Stretan {

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int loopsOfSeven = num / 2;
		
		String answer = "";
		if(num % 2 == 1)
			answer += "4";
		
		for(int i = 0; i < loopsOfSeven; i++)
		{
			answer += "7";
		}
		
		System.out.print(answer);
	}
}
