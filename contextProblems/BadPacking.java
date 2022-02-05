package contextProblems;

import java.util.*;

public class BadPacking {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int totalItems = sc.nextInt();
		int totalWeight = sc.nextInt()
		int currentWeight = 0;
		int itemWeight;
		ArrayList<Integer> allWeights = new ArrayList<Integer>();
		
		for(int i = 0; i < totalItems; i++)
		{
			allWeights.add(sc.nextInt());
		}
		
		Collections.sort(allWeights);
		
		for(int i = allWeights.size() - 1; i > -1; i--)
		{
			itemWeight = allWeights.get(i);
			if(currentWeight + itemWeight <= totalWeight)
			{
				currentWeight += itemWeight;
			}
			else
				break;
		}
		
		System.out.println(currentWeight);
		
		sc.close();
		
	}

}
