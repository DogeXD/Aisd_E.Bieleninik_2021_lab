package Zad1;

import java.util.Arrays;

public class LinearHash {

    private class Element{
        private int key;
        private String val;


        public Element(int key , String val){
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public String getVal() {
            return val;
        }

    }


    private Element [] arr;
    private int [] arr2;

    public LinearHash(int size){
        arr  = new Element[size];
        for(int j=0;j<size;j++){
            arr[j]=null;
        }
    }

    private int hash(int key){
        int hash=0;
        while (key!=0){
            int digit = key%10;
            hash = hash^digit;
            key = key/10;
        }
        return hash;
    }

    private int H(int key){
        return  hash(key);
    }

    private int pLinear(int i ){
        return i;
    }

    public boolean put(int key,String value){
        int index = (H(key)+pLinear(0))%arr.length;
        int i=0;
        while (arr[index]!=null&& i<=arr.length){
            index = (H(key)+pLinear(i))%arr.length;
            i++;
        }
        if(i==arr.length){
            return false;
        }
        arr[index] = new Element(key,value);
        return true;
    }
    //do zad2
    int trafione=0;
    int chybione =0;

    public void wypiszStatystyki(){
        System.out.println("Dla 100 wyszukan w tablicy o rozmiarze 1000 liniowe");
        System.out.println("Trafione "+(float)trafione/100);
        System.out.println("Chybione "+(float)chybione/100);
        System.out.println("Suma "+(float)(chybione+trafione)/100);
    }
    public String get(int key){
        if(containsKey(key)){
            int index =(H(key)+pLinear(0))%arr.length;
            int i=0;
            while (arr[index].getKey()!=key){
                index = (H(key)+pLinear(i))%arr.length;
                i++;
                chybione++;
            }
            trafione++;
            return arr[index].getVal();
        }
        else {
            return null;
        }

    }

    public boolean containsKey(int key){
        for(Element element:arr){
            if(element!=null){
                if(element.key==key){
                    return true;
                }
            }
        }
        return false;
    }
    public int size(){
        return arr.length;
    }

    public void resize(){
        Element[] old = arr;
        int s  = size();
        arr = new Element[2*s];
        Arrays.fill(arr, null);
        for (Element element : old) {
            if(element!=null) {
                put(element.getKey(), element.getVal());
            }
        }
    }

    public void dump(){
       for(Element element:arr){
           if(element==null){
               System.out.println("null");
           }
           else {
               System.out.println(element.getVal());
           }
       }
    }

}
