package iamazon.stackqueues;

import java.util.Stack;

public class Infix2PostfixAndEvaluatePostfix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix(exp));
		String exp1="231*+9-"; 
        System.out.println("postfix evaluation: "+evaluatePostfix(exp1));
	}

	// A utility function to return precedence of a given operator
	// Higher returned value means higher precedence
	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	private static String infixToPostfix(String exp) {
		String result = "";
		char[] infixExp = exp.toCharArray();
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < infixExp.length; i++) {
			
			if (Character.isLetterOrDigit(infixExp[i]))
				result += infixExp[i];
			else if (infixExp[i] == '(')
				s.push(infixExp[i]);
			else if (infixExp[i] == ')') {

				while (!s.isEmpty() && s.peek() != '(') {
					result += s.pop();
				}

				if (!s.isEmpty() && s.peek() != '(')
					return "Invalid Expression"; // invalid expression
				else
					s.pop();

			} else // an operator is encountered
			{
				while (!s.isEmpty() && Prec(infixExp[i]) <= Prec(s.peek())) {
					if (s.peek() == '(')
						return "Invalid Expression";
					result += s.pop();
				}
				s.push(infixExp[i]);
			}
			

		}

		// pop all the operators from the stack
		while (!s.isEmpty()) {
			if (s.peek() == '(')
				return "Invalid Expression";
			result += s.pop();
		}

		return result;
	}
	
	// Method to evaluate value of a postfix expression 
    static int evaluatePostfix(String exp) 
    { 
        //create a stack 
        Stack<Integer> stack=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<exp.length();i++) 
        { 
            char c=exp.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    } 
    
}
