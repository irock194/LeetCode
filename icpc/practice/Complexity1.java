package icpc.practice;

import java.util.*;

public class Complexity1 {
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		HashMap<String, Integer> charBank = new HashMap<String, Integer>();
		String singleCharacter;
		int totalErases = 0;
		
		for(int i = 0; i < word.length(); i++)
		{
			singleCharacter = String.valueOf(word.charAt(i));
			if(charBank.get(singleCharacter) == null)
			{
				charBank.put(singleCharacter, 1);
			}
			else
				charBank.put(singleCharacter, charBank.get(singleCharacter) + 1);
		}
		
		for(Map.Entry value: charBank.entrySet())
		{
			String key = (String)value.getKey();
			int numberOfLetters = ((int)value.getValue());
			
			while(numberOfLetters > 1)
			{
				totalErases++;
				numberOfLetters--;
			}
		}
	}

}
