package contextProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class ReconstructSum {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int totalNumbers = sc.nextInt();
		int total = 0;
		boolean foundNumber = false;
		int currentNumber = 0;
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		
		
		for(int i = 0; i < totalNumbers; i++)
		{
			listOfNumbers.add(sc.nextInt());
		}
		
		for(int value: listOfNumbers)
		{
			total += value;
		}
		
		for(int i = 0; i < listOfNumbers.size(); i++)
		{
			currentNumber = listOfNumbers.get(i);
			if(currentNumber == total - currentNumber)
			{
				foundNumber = true;
				break;
			}
		}
		
		if(foundNumber)
		{
			System.out.println(currentNumber);
		}
		else
			System.out.println("BAD");
		
		sc.close();
	}

}