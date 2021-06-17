package Zad1;

import java.util.Arrays;

public class DoubleHash {

    private class Element{
        private Integer key;
        private String val;


        public Element(int key , String val){
            this.key = key;
            this.val = val;
        }

        public Integer getKey() {
            return key;
        }

        public String getVal() {
            return val;
        }

    }


    private Element [] arr;
    private int [] arr2;

    public DoubleHash(int size){
        arr  = new Element[size];
        for(int j=0;j<size;j++){
            arr[j]=null;
        }
    }
    private int hash(Integer key){
        int hash=0;
        while (key!=0){
            int digit = key%10;
            hash = hash^digit;
            key = key/10;
        }
        return hash;
    }

    private int H(Integer key){
        return  hash(key);
    }

    private int hash2(Integer key){
        int hash=0;
        while (key!=0){
            int digit = key%10;
            hash = hash|digit;
            key = key/10;
        }
        return hash;
    }
    private int H2(Integer key){
        return  hash2(key);
    }

    private int pDouble(int i ){
        return i*H2(i);
    }

    public boolean put(int key,String value){
        int index = (H(key)+pDouble(0))%arr.length;
        int i=0;
        while (arr[index]!=null&& i<=arr.length){
            index = (H(key)+pDouble(i))%arr.length;
            i++;
        }
        if(i==arr.length){
            return false;
        }
        arr[index] = new Element(key,value);
        return true;
    }


    int trafione=0;
    int chybione =0;

    public void wypiszStatystyki(){
        System.out.println("Dla 100 wyszukan w tablicy o rozmiarze 1000 podwojne");
        System.out.println("Trafione "+(float)trafione/100);
        System.out.println("Chybione "+(float)chybione/100);
        System.out.println("Suma "+(float)(chybione+trafione)/100);
    }

    public String get(Integer key){
        if(containsKey(key)){
            int index =(H(key)+pDouble(0))%arr.length;
            int i=0;
            while (!arr[index].getKey().equals(key)){
                index = (H(key)+pDouble(i))%arr.length;
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

    public boolean containsKey(Integer key){
        for(Element element:arr){
            if(element!=null){
                if(element.key.equals(key)){
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
