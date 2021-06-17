package Zad1;

public class Test {
    public static void main(String[] args){
        LinearHash linearHash = new LinearHash(10);
        linearHash.put(12,"Dzwiedzia");
        linearHash.put(155,"Ala");
        linearHash.put(12,"Koala");
        linearHash.dump();
        linearHash.resize();
        System.out.println("------------------");
        linearHash.dump();
        System.out.println("------------------");
        System.out.println(linearHash.get(155));
        System.out.println("------------------");
        System.out.println(linearHash.get(2));

        System.out.println("----------------------SQUARE--------------------");
        SquareHash squareHash = new SquareHash(10);
        squareHash.put(12,"Dzwiedzia");
        squareHash.put(155,"Ala");
        squareHash.put(12,"Koala");
        squareHash.dump();
        squareHash.resize();
        System.out.println("------------------");
        squareHash.dump();
        System.out.println("------------------");
        System.out.println(squareHash.get(155));
        System.out.println("------------------");
        System.out.println(squareHash.get(2));


        System.out.println("----------------------Double--------------------");
        DoubleHash doubleHash = new DoubleHash(10);

        doubleHash.put(12,"Dzwiedzia");
        doubleHash.put(155,"Ala");
        doubleHash.put(12,"Koala");
        doubleHash.dump();
        doubleHash.resize();
        System.out.println("------------------");
        doubleHash.dump();
        System.out.println("------------------");
        System.out.println(doubleHash.get(155));
        System.out.println("------------------");
        System.out.println(doubleHash.get(2));

    }


}
