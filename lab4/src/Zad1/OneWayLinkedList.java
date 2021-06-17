package Zad1;

import java.util.Iterator;

public class OneWayLinkedList<E> {
    private class Element{

        private E value;
        private Element next;

        Element(E data){
            this.value=data;}


        public void setValue(E value) {
            this.value = value;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public Element getNext() {
            return next;
        }

    }

    private class InnerIterator implements Iterator<E> {
        Element actElem;
        boolean started = false
        public InnerIterator() {
            actElem=head;
        }
        @Override
        public boolean hasNext() {
            if(started)
                return actElem!=head;
            else
                started = true;
                return true;
        }
        @Override
        public E next() {
            E value=actElem.getValue();
            actElem=actElem.getNext();
            return value;
        }
    }
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    Element head=null;
    public OneWayLinkedList(){}

    public void clear() {
        head=null;
    }

    public void wyswietl(){
        Iterator<E> it = iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


    public int size() {
        int pos=0;
        Element actElem=head;
        boolean started = false;
        while(actElem!=head||!started)
        {
            started = true;
            pos++;
            actElem=actElem.getNext();
        }
        return pos;
    }
    private Element get(int pos){
        Element actElem=head;
        boolean started  = false;
        while((pos>0 && actElem!=head)||!started){
            started = true;
            pos--;
            actElem=actElem.getNext();
        }
        return actElem;
    }
    public boolean addEnd(E e) {
        Element newElem=new Element(e);
        if(head==null){
            head=newElem;
            return true;
        }
        Element tail=head;

        while(tail.getNext()!=head)
            tail=tail.getNext();
        tail.setNext(newElem);
        return true;
    }
    public boolean insert(int index, E data) {
        if(index<0) return false;
        Element newElem=new Element(data);
        if(index==0)
        {
            newElem.setNext(head);
            head=newElem;
            return true;
        }
        Element actElem=get(index-1);
        if(actElem==null)
            return false;
        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
        return true;
    }

    public E set(int index, E e) {
        Element actElem=get(index);
        if(actElem==null)
            return null;
        E elemData=actElem.getValue();
        actElem.setValue(e);
        return elemData;
    }

    public int indexOf(E data) {
        int pos=0;
        Element actElem=head;
        boolean started = false;
        while(actElem!=head||!started)
        {
            started = true;
            if(actElem.getValue().equals(data))
                return pos;
            pos++;
            actElem=actElem.getNext();
        }
        return -1;
    }

    public boolean contains(E data) {
        return indexOf(data)>=0;
    }
    public E deletePos(int index) {
        if(head==null)
            return null;
        if(index==0){
            E retValue=head.getValue();
            head=head.getNext();
            return retValue;}
        Element actElem=get(index-1);
        if(actElem==null || actElem.getNext()==null)
            return null;
        E retValue=actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;}

    public boolean delete(E e) {
        if(head==null)
            return false;
        if(head.getValue().equals(e)){
            head=head.getNext();
            return true;}
        Element actElem=head;
        boolean started = false;
        while(actElem.getNext()!=head && !actElem.getNext().getValue().equals(e)&&!started){
            started = true;
            actElem=actElem.getNext();
        }
        if(actElem.getNext()==null)
            return false;
        actElem.setNext(actElem.getNext().getNext());
        return true;
    }
    public E deleteEl(Element e) {
        if(head==null)
            return null;
        if(head.getValue().equals(e)){
            head=head.getNext();
            return (E) head;
        }
        Element actElem=head;
        boolean started = false;
        while(actElem.getNext()!=head && !actElem.getNext().getValue().equals(e)&&!started){
            started = true;
            actElem=actElem.getNext();
        }
        if(actElem.getNext()==null)
            return null;
        actElem.setNext(actElem.getNext().getNext());
        return (E) actElem;
    }

}
