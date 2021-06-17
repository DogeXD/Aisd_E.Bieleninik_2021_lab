package Zad4;

import Zad1.EmptyQueueException;
import Zad1.FullQueueException;

import java.io.File;

public class Main {
    public static void main(String[] args) throws EmptyQueueException, FullQueueException {
        File file = new File("src/Zad4/exp");
        RPN rpn = new RPN();
        rpn.read(file);
        rpn.infixToPostfix();
        rpn.printExp();
        System.out.println(rpn.evaluatePostfix());
    }
}
