package icpc.practice;

import java.util.*;

public class MismatchedSocks {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int totalSocks = sc.nextInt();
		int currentSock;
		HashMap<Integer, Integer> socks = new HashMap<Integer, Integer>();
		int totalMismatchedSocks = 0;
		
		for(int i = 0; i < totalSocks; i++)
		{
			currentSock = sc.nextInt();
			
			if(socks.get(currentSock) == null)
			{
				socks.put(currentSock, 1);
			}
			else if(socks.get(currentSock) == 1)
				socks.put(currentSock, 0); 
			else
				socks.put(currentSock, 1);
				
		}
		
		for(Map.Entry entry: socks.entrySet())
		{
			int key = (int)entry.getKey();
			int hasPair = ((int)entry.getValue());

			if(hasPair == 1)
				totalMismatchedSocks++;
		}
		
		System.out.println(totalMismatchedSocks);
	}

}
