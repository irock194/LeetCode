package contextProblems;

import java.util.*;

public class TriangularCollection {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int totalNumbers = sc.nextInt();
		int number1, number2, number3;
		int totalTriangles = 0;
		
		ArrayList<Integer> allNumbers = new ArrayList<Integer>();
		
		for(int i = 0; i < totalNumbers; i++)
		{
			allNumbers.add(sc.nextInt());
		}
		
		for(int i = 0; i < allNumbers.size() - 2; i++)
		{
			number1 = (int)Math.pow(allNumbers.get(i), 2);
			
			for(int j = i + 1; j < allNumbers.size() - 1; j++)
			{
				number2 = (int)Math.pow(allNumbers.get(j), 2);
				
				for(int k = j + 1; k < allNumbers.size(); k++)
				{
					number3 = (int)Math.pow(allNumbers.get(k), 2);
					
					System.out.println(number2 + number3 + " > " + number1);
					System.out.println(number1 + number3 + " > " + number2);
					System.out.println(number2 + number1 + " > " + number3);

					
					
					if(number1 < number2 + number3)
					{
						totalTriangles++;
					}
					else if(number2 < number1 + number3)
						totalTriangles++;
					else if(number3 < number1 + number2)
						totalTriangles++;
				}
			}
		}
		
		System.out.println(totalTriangles);
	}

}
