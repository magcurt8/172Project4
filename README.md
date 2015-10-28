# CSC172
Short Description:
Program that reads files written in infix form line by line and breaks each line into characters that can be evaluated. After the characters are examined to see if they are operators or operands, the necessary methods are called to evaluate. The lines are converted to postfix form and then evaluated. The evaluated lines are then written to a new text file that is created. The test class has a toPostfix method that converts the strings to postfix by evaluating if a character is an operator, if it is a unary operator, and if it is a binary operator, to add to an array list of strings. The method examines each character for the necessary actions, such as an open parenthesis, which will push all values, and a closed parenthesis which will enqueue unless there is an open parenthesis in the stack. (refer to comments in code for specific line by line explanation of each aspect of the method.) postFixEval method uses the applyOperator method to evaluate and returns the stack values. the isOperator(char and string) method checks to see if each character is an operator or not, and returns true if so, false if otherwise. applyOperator performs the operator functions necessary based on the operator found. applyOperatorBoolean evaluates for not function and returns boolean responses. operatorPrecedence evaluates for each operator and returns its level of precedence. Other classes, such as MyQueue and Stack, etc. are close to the same (with some adjustments to avoid null pointers) as previous labs.

EXTRA CREDIT:
Program works for exponents and modular arithmetic.

Expected source output
2.0
6.2
6.2
0.0
4.2
-4.2
12.0
16.0
-8.0
9.0
1.0
0.0
0.0
1.0
1.0
1.0
0.0
1.0
0.0
1.0
0.0
1.0
0.0
0.0
1.0
0.0
5.0
0.0
0.0
1.0
