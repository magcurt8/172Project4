# CSC172
Partner: Elias Davis, Scott Onestak, Yukako Ito

Short Description:
CodeBreaker class contains the algorithm to generate a random array list based on the user’s input variables. The next method makes a next guess based on the user’s response to the first guess (eliminating guesses that are no longer possible). Update list updates the number of possibilities and their values based on the user input. Input evaluates the user input to then either realize the guess is right or know that it is wrong and then update the list accordingly. The guess method makes the guesses and then prints them out. Choice class generates the options available based on variables input by user. Then removes choices based on user response. Test method contains main and restart game methods, one to run the original game and another to run a restart game in order to start over. 

Directions for running code:
Code can be run in Eclipse
Code can be run in Terminal
cd Desktop 
javac Test.java
javac Choice.java
javac CodeBreaker.java
java Test

DISCLAIMER:
CODE ONLY WORKS FOR PEGS/COLORS UP TO 6. CAN GENERATE FIRST GUESS FOR 7, BUT WILL TAKE TOO LONG TO GUESS A SECOND TIME. MAY WORK ON DESKTOP COMPUTERS FASTER (RAN ONLY ON A MACBOOK, MAY NOT HAVE ENOUGH MEMORY TO RUN 7X7 AND 8X8).

Source Output
SOURCE OUTPUT:

Enter amount of pegs: 
6
Enter amount of variables: 
6
Enter Variable: 
r
Enter Variable: 
g
Enter Variable: 
y
Enter Variable: 
b
Enter Variable: 
v
Enter Variable: 
o
------- GUESS --------
{oooooo}
Enter Amount Correct Position and Variable: 
2
Enter Amount Correct Variable: 
0
------- GUESS --------
{oovvvv}
Enter Amount Correct Position and Variable: 
2
Enter Amount Correct Variable: 
0
------- GUESS --------
{oobbbb}
Enter Amount Correct Position and Variable: 
3
Enter Amount Correct Variable: 
0
------- GUESS --------
{oobyyy}
Enter Amount Correct Position and Variable: 
4
Enter Amount Correct Variable: 
0
------- GUESS --------
{oobygg}
Enter Amount Correct Position and Variable: 
3
Enter Amount Correct Variable: 
2
------- GUESS --------
{oobgyr}
Enter Amount Correct Position and Variable: 
6
Enter Amount Correct Variable: 
0
BEAT YOU!
Would you like to play again?(yes, or no)
yes
Enter amount of pegs: 
…
Would you like to play again?(yes,or no)
no
Too bad, you sore loser...

