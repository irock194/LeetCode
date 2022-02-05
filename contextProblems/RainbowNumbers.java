package contextProblems;

import java.util.*;

public class RainbowNumbers {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int lowerBound = sc.nextInt();
		int upperBound = sc.nextInt();
		
		String currentNumber = String.valueOf(upperBound);
		boolean foundRainbow = false;
		boolean badNumber = false;
		
		if(upperBound < 100)
		{
			System.out.println(upperBound);
		}
		else
		{
			while(!foundRainbow && upperBound != lowerBound)
			{
				for(int i = 0; i < currentNumber.length() - 2; i++)
				{
					if(currentNumber.charAt(i) == currentNumber.charAt(i + 2))
					{
						badNumber = true;
					}
				}
				
				if(badNumber)
				{
					upperBound--;
					currentNumber = String.valueOf(upperBound);
				}
				else
				{
					foundRainbow = true;
				}
			}
			
			System.out.println(currentNumber);
		}
		
		
		 sc.close();
		
	}

}
