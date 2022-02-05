package contextProblems;

import java.io.*;

public class ProblemG {
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String numbers = br.readLine();
		int antPosition = 1;
		int nextPosition;
		int total = 0;
		
		for(int i = 0; i < numbers.length(); i++)
		{
			nextPosition = Character.getNumericValue(numbers.charAt(i));
			total += Math.abs(antPosition - nextPosition);
			antPosition = nextPosition;
		}
		
		System.out.println(total);

		br.close();
	}
}
