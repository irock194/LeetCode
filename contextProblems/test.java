package contextProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
	
	public static void main(String [] args)
	{  
		int area = 12;
		int [] answer = solution(area);
		
		for(int i = 0; i < answer.length; i++)
		{
			System.out.println(answer[i]);
		}
	}
	
	public static int[] solution(int area) {
        
        ArrayList<Integer> solutions = new ArrayList<Integer>();
		while(area != 0)
		{
		    int currentNumber = 1;
		    while(Math.pow(currentNumber, 2) <= area && Math.pow(currentNumber + 1, 2) <= area)
		    {
		         currentNumber++;
            }
        
            solutions.add((int)Math.pow(currentNumber, 2));
            area -= Math.pow(currentNumber, 2);
		}
		
		int[] answer = solutions.stream().mapToInt(Integer::intValue).toArray();
		
		return answer;
    }
}

