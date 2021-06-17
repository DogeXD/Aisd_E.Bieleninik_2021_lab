package Zad2;

public class Main {
    public static void main(String [] args){
        DynamicStack<Integer>s = new DynamicStack<>(3);

        s.push(2);
        s.push(3);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()){
           System.out.println(s.pop());
        }

    }
}
