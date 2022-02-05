package icpc.practice;

//https://open.kattis.com/contests/mm2pyi/problems/ladder

import java.util.*;

public class Ladder {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int degrees = sc.nextInt();
	
		
		System.out.println((int)Math.ceil(height / Math.sin(Math.toRadians(degrees))));
		
		sc.close();
	}

}
