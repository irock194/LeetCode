package icpc.practice;

import java.util.ArrayList;
import java.util.Scanner;

//https://open.kattis.com/contests/mm2pyi/problems/height


public class HeightOrdering {
	
	static class LinkedList
	{
		StudentNode start;
		
		LinkedList(StudentNode start)
		{
			this.start = start;
		}
		
		LinkedList()
		{}
		
		int InsertNewStudent(int height)
		{
			int totalSteps = 0;
			
			if(height > start.value)
			{
				start = new StudentNode(start, height);
				return 0;
			}
			
			StudentNode currentNode = start.next;
			StudentNode previousNode = start;
			totalSteps++;
			
			while(currentNode != null)
			{
				if(height > currentNode.value)
				{
					StudentNode newStudent = new StudentNode(currentNode, height);
					previousNode.next = newStudent;
					return totalSteps;
				}
				
				currentNode = currentNode.next;
				previousNode = previousNode.next;
				totalSteps++;
			}
			
			previousNode.next = new StudentNode(null, height);
			return totalSteps;
		}
		
	}
	
	static class StudentNode
	{
		StudentNode next;
		int value;
		
		StudentNode(StudentNode next, int value)
		{
			this.next = next;
			this.value = value;
		}
		
		StudentNode()
		{
			next = null;
			value = 0;
		}
	}
	
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int classes = sc.nextInt();
		int classNumber;
		int height;
		int totalSteps = 0;
		
		for(int i = 0; i < classes; i++)
		{
			classNumber = sc.nextInt();
			height = sc.nextInt();
			totalSteps = 0;

			LinkedList classList = new LinkedList(new StudentNode(null, height));
			
			for(int j = 0; j < 19; j++)
			{
				height = sc.nextInt();
				totalSteps += classList.InsertNewStudent(height);
			}
			
			System.out.println(classNumber + " " + totalSteps);
		}
		
		sc.close();
	}
}


