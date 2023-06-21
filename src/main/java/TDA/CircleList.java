/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author sebasceb
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class CircleList<E>{

    private Node<E> first;
    private Node<E> last;

    public CircleList() {
        this.first = null;
        this.last = null;
    }

    public int size() {
        int cont = 0;
        Node<E> viajero;
        for (viajero = first; viajero != first; viajero = viajero.getNext()) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        String result = "{";
        Node<E> p;
        for (p = first; p != null; p = p.getNext()) {

            result += p.getContent() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }

    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    public void clear() {
        this.first=null;
        this.last=null;
    }

    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        
        if (this.isEmpty()) {
            this.last = nuevo;
            nuevo.setNext(nuevo);
            nuevo.setPrevious(nuevo);
        }else{
            nuevo.setNext(first);
            nuevo.setPrevious(last);
            last.setNext(nuevo);
            first.setPrevious(nuevo);
        }
        
        this.first = nuevo;
        return true;
    }

    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(element);
        if (this.isEmpty()) {
            this.first = nuevo;
        } else {
            this.last.setNext(nuevo);
        }
        this.last = nuevo;
        return true;
    }

    public void removeFirst() {
        if(!this.isEmpty()){
            return;
        }else if(this.first.getNext()==this.last)
            this.first=null;
        else{
            this.first=this.first.getNext();
        }
    }

    public void removeLast() {
        if(!this.isEmpty()){
            return;
        }else if(this.last.getNext()==this.first)
            this.last=null;
        else{
            this.last=this.last.getPrevious();
        }
    }

    public boolean add(int index, E element) {
        if(element==null)
            return false;
        int cont=0;
        Node<E> viajero;
        if(index<=size()){
            for (viajero = first; viajero != null; viajero = viajero.getNext()) {
                if(cont== index){
                    Node<E>newPrevious=viajero.getPrevious();
                    Node<E>newNext=viajero.getNext();
                    newPrevious.setNext(newNext);
                    newNext.setPrevious(newPrevious);
                    return true;
                }
                cont++;
            }
        } 
        return false;
    }
    
    public boolean addAll(List<E> l){
        if(l.isEmpty())
            return false;
        for(E e:l){
            this.addLast(e);
        }
        return true;
    }

    
    public boolean remove(E element){
        Node<E> viajero;
        for (viajero = first; viajero != null; viajero = viajero.getNext()) {
            if(viajero.equals(element)){
                Node<E>newPrevious=viajero.getPrevious();
                Node<E>newNext=viajero.getNext();
                newPrevious.setNext(newNext);
                newNext.setPrevious(newPrevious);
                
                return true;
            } 
        }return false;
    }

    public boolean remove(int index) {
        int cont = 0;
        Node<E> viajero;
        if(index<=size()){
            for (viajero = first; viajero != null; viajero = viajero.getNext()) {
                if(cont== index){
                    Node<E>newPrevious=viajero.getPrevious();
                    Node<E>newNext=viajero.getNext();
                    newPrevious.setNext(newNext);
                    newNext.setPrevious(newPrevious);
                    return true;
                }
                cont++;
            }
        }return false;
    }

    public E get(int index) {
        int cont = 0;
        Node<E> viajero;
        if(index<=size()){
            for (viajero = first; viajero != null; viajero = viajero.getNext()) {
                if(cont== index){
                    return viajero.getContent();
                }
                cont++;
            }
        }return null;
    }

    public void set(int index, E element) {
        int cont = 0;
        Node<E> e= new Node(element);
        Node<E> viajero;
        if(index<=size()){
            for (viajero = first; viajero != null; viajero = viajero.getNext()) {
                if(cont== index){
                    viajero.getPrevious().setNext(e);
                    e.setNext(viajero);
                    viajero.setPrevious(e);
                    return;
                }
                cont++;
            }
        }
    }

    public Iterator<E> iterator() {
        
        Iterator<E> it = new Iterator<E>() {
            Node<E> cursor = first;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.getContent();
                cursor = cursor.getNext().getNext();
                return e;
            }
        };
        
        return it;
        
        
    }

   

}
