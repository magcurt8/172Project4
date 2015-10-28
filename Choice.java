/*
 *Mastermind
 *Version 1.0
 *Copyright Margaret M. Curtis
 *CSC 172 Spring 2015
 *Project 1
 *Margaret M. Curtis
 *MW 2-3:15PM
 *Partners: Yukako Ito, Elias Davis, Scott Onestak
 *Last Revised: February 19, 2015
 */

public class Choice 
{
	public int code[];
	//constructor
	//runtime O(1)
	public Choice(int pegs)
	{
		this.code = new int[pegs];
	}
	//runtime: O(n^2)
	//generates choices that are the proper length based on number of pegs
	//evaluates if code matches another to then remove it from the options list
	public int[] match(int[] code2)
	{
		int[] temp = new int[2];
		temp[0] = 0;
		temp[1] = 0;
		
		boolean[] match1 = new boolean[code.length];
		boolean[] match2 = new boolean[code2.length];

		for(int i=0; i<code.length; i++)
		{
			for(int j=0; j<code2.length; j++)
			{
				if(code[i] == code2[j] && i==j)
				{
					if(match1[i] == false && match2[j] == false)
					{
						match1[i] = true;
						match2[j] = true;
						temp[0]++;
					}
				}
			}
			
		}
		for(int i=0; i<code.length; i++)
		{
			for(int j=0; j<code2.length; j++)
			{
				if(code[i] == code2[j] && i!=j)
				{
					if(match1[i] == false && match2[j] == false)
					{
						match1[i] = true;
						match2[j] = true;
						temp[1]++;
					}
				}
			}
			
		}
		return temp;
	}
}
	
