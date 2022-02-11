package kattis;

import java.util.*;

//https://open.kattis.com/contests/c596t4/problems/sort

public class NumberSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int biggestValue = sc.nextInt();
		int currentValue;
		int[][] table = new int[biggestValue + 1][2];
		LinkedHashMap<Integer, Integer> answer = new LinkedHashMap<Integer, Integer>();
		for(int i = 0; i < size; i++) {
			currentValue = sc.nextInt();
			answer.put(currentValue, answer.getOrDefault(currentValue, 0) + 1);	
		}
		int num;
		for(Map.Entry entry : answer.entrySet()) {
			num = (int)entry.getKey();
			for(int i = 0; i < (int)entry.getValue(); i++) {
				System.out.print(num + " ");
			}
		}
		
	}
}
