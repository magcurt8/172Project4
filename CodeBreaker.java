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
import java.util.ArrayList;
public class CodeBreaker 
{
	public int pegs, numColors;
	public ArrayList<String> colors;
	public boolean correct;
	public ArrayList<Choice> choiceList;
	public Choice guess;
	public int cpc, cc;
	//constructor
	//Runtime: O(n)
	public CodeBreaker(int pegs, int numColors, ArrayList<String> colors){
		this.pegs = pegs;
		this.numColors = numColors;
		this.colors = colors;
		correct = false;
		
		choiceList = new ArrayList<Choice>();
		
		for(int i=0; i<Math.pow(numColors, pegs); i++){
			choiceList.add(new Choice(pegs));
		}
		
		generateChoices(0);
	}
	//Runtime: O(ln(n^2))
	//algorithm that generates choices based on user input for number pegs, variables, and types of variables
	public void generateChoices(int column)
	{
		if(column >= pegs)
			return;
		int exp = pegs - column - 1;
		int repeats = (int) Math.round(Math.pow((double) numColors , (double) exp));
		int counter = 0;
		while(counter < Math.pow(numColors, pegs)){
			for(int i = 0; i < numColors; i++){
				for(int k = 0; k < repeats; k++){
					
					choiceList.get(counter).code[column] = i;
					counter++;
				}
			}
		}
		generateChoices(column + 1);
	}
	//random guess out of available options
	public void makeNextGuess()
	{
		if(choiceList.size() == 0)
			return;
		this.guess = choiceList.get(choiceList.size()-1);
		guessToOutput(guess);
		
	}
	
	//updates list to remove all impossible options based on user input
	public void updateList(){
		
		for(int i=0; i<choiceList.size(); i++){
			
			//MATCH
			if(!((guess.match(choiceList.get(i).code)[0] == cpc) && (guess.match(choiceList.get(i).code)[1] == cc))){
				//REMOVE
				choiceList.remove(i);
				i--;
			}
			
		}
		//used for debugging: System.out.println(choiceList.size());
		
	}
	//evaluates input to see if guess is true to then stop, if guess incorrect, then update list
//runtime O(1)
	public void input(int cpc, int cc){
		if(cpc == pegs){
			correct = true;
		}
		else{
			this.cpc = cpc;
			this.cc = cc;
			updateList();
		}
	}
	//guesses made are printed out to the console
	//runtime: O(n)
	public void guessToOutput(Choice choice){
		
		System.out.println("------- GUESS --------");
		System.out.print("{");
		for(int i=0; i<pegs; i++){
			//System.out.print(choice.code[i]);
			System.out.print(colors.get(guess.code[i])+",");
		}
		System.out.println("}");
		
	}
}
