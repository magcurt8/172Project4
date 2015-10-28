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
import java.util.Scanner;
import java.util.ArrayList;

public class Test 
{
	//main method
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter amount of pegs: ");
		int pegs = reader.nextInt();
		System.out.println("Enter amount of variables: ");
		int colors = reader.nextInt();
		
		ArrayList<String> colorList = new ArrayList<String>();
		
		for(int i=0; i<colors; i++){
			System.out.println("Enter Variable: ");
			colorList.add(reader.next());
		}
		
		CodeBreaker mastermind = new CodeBreaker(pegs, colors, colorList);
		
		while(!mastermind.correct){
			mastermind.makeNextGuess();
			
			System.out.println("Enter Amount Correct Position and Variable: ");
			int cpc = reader.nextInt();
			System.out.println("Enter Amount Correct Variable: ");
			int cc = reader.nextInt();
			mastermind.input(cpc, cc);
			
		}
		if(mastermind.correct)
		{
			System.out.println("BEAT YOU!");
			System.out.println("Would you like to play again? (yes, or no)");
			String answer=reader.next();
			if(answer.equalsIgnoreCase("yes"))
			{
			restartGame();
			}
			else
				System.out.println("Too bad, you sore loser...");
		}
		reader.close();
	}
	//method to restart game and reset all values
	public static void restartGame()
	{
		Scanner reader=new Scanner(System.in);
		System.out.println("Enter amount of pegs: ");
		int pegs = reader.nextInt();
		System.out.println("Enter amount of variables: ");
		int colors = reader.nextInt();
		
		ArrayList<String> colorList = new ArrayList<String>();
		
		for(int i=0; i<colors; i++){
			System.out.println("Enter Variable: ");
			colorList.add(reader.next());
		}
		
		CodeBreaker mastermind = new CodeBreaker(pegs, colors, colorList);
		
		while(!mastermind.correct){
			mastermind.makeNextGuess();
			
			System.out.println("Enter Amount Correct Position and Variable: ");
			int cpc = reader.nextInt();
			System.out.println("Enter Amount Correct Variable: ");
			int cc = reader.nextInt();
			mastermind.input(cpc, cc);
			
		}
		if(mastermind.correct)
		{
			System.out.println("BEAT YOUR ASS");
			System.out.println("Would you like to play again?");
		}
		reader.close();
	}

}
