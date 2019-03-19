/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert.infix.to.postfix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mohamed Saide
 */
public class ConvertInfixToPostfix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           InfixToPostfixNotation input;
        try{
            
            FileReader fr=new FileReader("Input.txt");
            BufferedReader br=new BufferedReader(fr);
            String line;
            while ((line=br.readLine()) !=null) { 
                System.out.println("infix Expression : " + line );
                input=new InfixToPostfixNotation(line);
                System.out.println("postfix Notation : " + input.TranslatExpretion());
                System.out.println("evaluate after Translat : " + input.evaluatePostfix(input.TranslatExpretion())); 
            }
        }
        catch(IOException e){
            System.out.println("error");
        }
        
        
        
    }
    
}
