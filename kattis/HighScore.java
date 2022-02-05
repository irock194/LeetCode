package kattis;

//https://open.kattis.com/contests/mziyzd/problems/highscore

import java.util.*;
import java.math.*;

public class HighScore {

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int numOfCases = sc.nextInt();
		sc.nextLine();
		int currentValue;
		int previousValue = 'A';
		int total;
		String string;
		
		for(int i = 0; i < numOfCases; i++)
		{
			total = 0;
			string = sc.nextLine();
			//previousValue = string.charAt(0);
			for(int j = 0; j < string.length(); j++)
			{
				currentValue = (int)string.charAt(j);
				if(Math.abs(currentValue - previousValue) <= 13)
					total += Math.abs(currentValue - previousValue);
				else
					total += 26 - Math.abs(currentValue - previousValue);
			}
			
			total += string.length() - 1;
			
			System.out.println(total);
		}
	}
}
