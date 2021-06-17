package Zad4;


import Zad1.EmptyQueueException;
import Zad1.FullQueueException;
import Zad3.Stos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public  class RPN
{
    private String postfix;
    private String inFix;


    private static int Prec(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public void read(File file){
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                this.inFix = myReader.nextLine();
                this.inFix = this.inFix.replace(" ","");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public  void  infixToPostfix() throws EmptyQueueException, FullQueueException {
        String exp = this.inFix;
        StringBuilder result = new StringBuilder();
        Stos<Character> stack = new Stos<>(100);

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result.append(c);

            else if (c == '(')
                stack.push(c);

            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.top() != '(')
                    result.append(stack.pop());

                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.top())){

                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            if(stack.top() == '(')
                postfix =  "Invalid Expression";
            result.append(stack.pop());
        }
     postfix= result.toString();
    }

    public  int evaluatePostfix() throws EmptyQueueException, FullQueueException {
        String exp = this.postfix;
        Stos<Integer> stack=new Stos<>(100);
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);

            if(Character.isDigit(c))
                stack.push(c - '0');

            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+' -> stack.push(val2 + val1);
                    case '-' -> stack.push(val2 - val1);
                    case '/' -> stack.push(val2 / val1);
                    case '*' -> stack.push(val2 * val1);
                }
            }
        }
        return stack.pop();
    }

    public void printExp(){
        System.out.println(this.inFix+ " "+this.postfix);
    }


} 