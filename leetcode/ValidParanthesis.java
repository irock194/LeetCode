package leetcode;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParanthesis {

	//O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        char currentChar;
        for(int i = 0; i < s.length(); i++)
        {
            currentChar = s.charAt(i);
            if(currentChar == '(' || currentChar == '[' || currentChar == '{')
                stack.push(currentChar);
            else
            {
                if(stack.empty())
                    return false;
                
                if(currentChar == ')' && stack.peek() == '(')
                    stack.pop();
                else if(currentChar == ']' && stack.peek() == '[')
                    stack.pop();
                else if(currentChar == '}' && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }
        
        if(!stack.empty())
            return false;
        return true;
    }
}
