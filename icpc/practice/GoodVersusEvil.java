package icpc.practice;

import java.util.Scanner;

public class GoodVersusEvil {

	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int totalBattles = sc.nextInt();
		int currentRace = 1;
		int numberOfUnits;
		
		for(int i = 1; i < totalBattles + 1; i++)
		{
			int GoodStrength = 0;
			int evilStrength = 0;
			
			currentRace = 1;
			
			while(currentRace < 7)
			{
				numberOfUnits = sc.nextInt();
				switch(currentRace)
				{
					case 1: GoodStrength += numberOfUnits * 1; break;
					case 2: GoodStrength += numberOfUnits * 2; break;
					case 3: GoodStrength += numberOfUnits * 3; break;
					case 4: GoodStrength += numberOfUnits * 3; break;
					case 5: GoodStrength += numberOfUnits * 4; break;
					case 6: GoodStrength += numberOfUnits * 10; break;
				}
				
				currentRace++;
			}
			
			currentRace = 1;
			
			while(currentRace < 8)
			{
				numberOfUnits = sc.nextInt();
				switch(currentRace)
				{
					case 1: evilStrength += numberOfUnits * 1; break;
					case 2: evilStrength += numberOfUnits * 2; break;
					case 3: evilStrength += numberOfUnits * 2; break;
					case 4: evilStrength += numberOfUnits * 2; break;
					case 5: evilStrength += numberOfUnits * 3; break;
					case 6: evilStrength += numberOfUnits * 5; break;
					case 7: evilStrength += numberOfUnits * 11; break;
				}
				
				currentRace++;
			}
			
			//System.out.println("Good: " + GoodStrength + " Evil: " + evilStrength);
			
			if(GoodStrength > evilStrength)
			{
				System.out.println("Battle " + i + ": Good truimphs over Evil");
			}
			else if(evilStrength > GoodStrength)
			{
				System.out.println("Battle " + i + ": Evil eradicates all trace of Good");
			}
			else
				System.out.println("Battle " + i + ": No victore on this battle field");
		}
	}
}
