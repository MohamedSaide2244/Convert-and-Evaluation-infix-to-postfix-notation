/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.infix.to.postfix;

import java.util.Stack;

/**
 *
 * @author Mohamed Saide
 */
public class InfixToPostfixNotation {
     
    private String expretion;
    Stack<Character> stack=new Stack<Character>();
    Stack<Integer> evaluate=new Stack<Integer>();
    public InfixToPostfixNotation(String expretion)
    {
        this.expretion=expretion;
    }
    
    public String TranslatExpretion()
    {
        String result="";
        char checkCharacter;
        
        for(int i=0; i<expretion.length(); i++)
        {
            checkCharacter=expretion.charAt(i); 
            //if Bit is Leter or digit (operand)
            if(Character.isLetterOrDigit(checkCharacter))
            {
                result +=checkCharacter;
            }
            
            else if(checkCharacter=='(')
            {
                stack.push(checkCharacter);
            }
            
            else if(checkCharacter==')') 
            {
                while (!stack.isEmpty() && stack.peek() !='(') {                    
                    
                    result +=stack.pop();
                }
                
                if (!stack.isEmpty() && stack.peek() !='(')
                {
                    return "Invalid Exeption";
                }
                else
                {
                    stack.pop();
                }
            }
            //if next Bit is Operator 
            else
            {
                while (!stack.isEmpty()&& NumberPriority(checkCharacter)<=NumberPriority(stack.peek())) {
                      
                    result +=stack.pop();
                }
                stack.push(checkCharacter);
            }
        }
        
        while (!stack.isEmpty()) {            
            
            result +=stack.pop();
        }
    
        return result;
    }
    private int NumberPriority(char operator)
    {
        switch(operator)
        {
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
    
     public int evaluatePostfix(String result) 
    { 
        char character;
        
        for(int i=0; i<result.length(); i++)
        {
             character=result.charAt(i);
             
             if(Character.isDigit(character))
             {   
                 //subtracting Converting Character to integer
                 evaluate.push(character - '0');
             }
             else 
             {
                 int operand_1=evaluate.pop();
                 int operand_2=evaluate.pop();
                 
                 switch(character)
                 {
                     case '+':
                         evaluate.push(operand_2 + operand_1); 
                         break;
                         
                     case '-':
                         evaluate.push(operand_2 - operand_1);
                         break;
                         
                     case '*':
                          evaluate.push(operand_2 * operand_1);
                         break;
                         
                     case '/':
                         evaluate.push(operand_2 / operand_1);
                         break;
                         
                     case '^':
                         evaluate.push(operand_2 ^ operand_1);
                         break;
                 }
             }
        }
        return evaluate.pop();     
    } 
}
     