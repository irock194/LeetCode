package kattis;

import java.util.Scanner;

//https://open.kattis.com/contests/c596t4/problems/oddecho

public class OddEcho {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		while(sc.hasNext()) {
			if(count % 2 == 1) {
				System.out.println(sc.nextLine());
			}
			else {
				sc.nextLine();
			}
			count++;
		}
		
		sc.close();
		return;
	}
}
