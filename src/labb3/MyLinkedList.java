/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

/**
 * 
 * @author SaraRoempke & MoaWahlgren
 * @param <E>
 *
 */
public abstract class MyLinkedList<E> extends Object implements MyList {
   
    private Node<E> head; 
    private Node<E> tail; 
    private int size; 
    
    MyLinkedList() {
        head = null; 
        tail = null; 
        size = 0; 
    }

    
    private static class Node<E> {
    E element; 
    Node<E> nextElement; 
        
    public Node(E element) {
        this.element = element; 
    }
    public Node(E element, Node<E> nextElement) {
        this.element = element; 
        this.nextElement = nextElement; 
    }
        
    }
    
    @Override
    public java.util.Iterator<E> iterator() {
        return new MyIterator(tail); 
    }
    
    
    private class MyIterator <E> implements java.util.Iterator<E> {
        private Node<E> current,previous; 
        public MyIterator(Node<E> node) {
            current = node; 
            previous = null; 
        }
        
        @Override 
        public boolean hasNext() {
            return (current!= null); 
        }
        
        @Override
        public E next() {
            if(current != null) {
                previous = current;
                current = previous.nextElement; 
                return previous.element; 
            }
            else {
                return null; 
            }
        }
        
        @Override
        public void remove() {
            previous.nextElement = current.nextElement; 
            current = previous.nextElement; 
        }
    }
    

    

    
    //Nedan är metoder i MyCollection 

    @Override
    public boolean add(E e) {
        //Ensures that this collection contains the specified element 
        tail = new Node(e, tail); 
        size ++;
        
        return true; 
    }

    @Override
    public boolean addAll(MyCollection<? extends E> c) {
        //Adds all of the elements in the specified collection to this collection
        return true; 
    }

    @Override
    public void clear() {
        //Removes all of the elements from this collection

        
    }

    @Override
    public boolean contains(Object o) {
        //Returns true if this collection contains the specified element
        
  
    }

    @Override
    public boolean containsAll(MyCollection<? extends E> c) {
        //Returns true if this collection contains all of the elments in te specfied collection
        return true; 
    }
    
    @Override
    public boolean equals(Object o) {
        //Compares the specified object with this collection for equality 
        
        
        return true; 
    }

    @Override
    public boolean isEmpty() {
        //Returns true if this collection contains no elements
  
        
        return true; 
    }

    @Override
    public Iterator<E> iterator() {
        //Returns an iterator over the elements in this collection
        
        return ;
    }

    @Override
    public void remove(Object o) {
        //Removes a single instance of the specified element from thi scollection, if present
        boolean ready = false; 
        Node<E> current = tail; 
        while(!ready && current != null) {
            if(current.element.equals(o)) {
                tail = current.nextElement; 
                size--; 
                ready = true; 
            }
            current = current.nextElement; 
        }
    }

    @Override
    public void removeAll(MyCollection <?> c) {
        //Removes all of this collection's elements that are also contained in the specified collection
      
    }

    @Override
    public void retainAll(MyCollection <?> c) {
        //Retains only the elements in this collecton that are contained in the specified collection 
        
    }
    

    @Override
    public int size() {
        //Returns the number of elements in this collection
        return size; 
    }

    @Override
    public Object[] toArray() {
        //Returns an array containing all of the elements in this collection
        
 

    }

    //Nedan är metoder i MyList
    
    @Override
    public void add(int index, E element) {
        //Appends the specified element to the end of this list
        if(index > size) {
            //error
        }
        else if(index == size) {
            add(element); 
        }
        else {
            Node<E> current = tail; 
            for (int i = size-index-1; i>0; i--, current = current.nextElement) { 
            }
            Node<E> temp = current.nextElement; 
            current.nextElement = new Node(element, temp); 
            size++; 
        }
    }

    @Override
    public boolean addAll(int index, MyCollection <? extends E> c) {
        //Inserts all of the elements in the specified collection into this list att the specified position 
        
        return ; 

    }

    @Override
    public E get(int index) {
        //Returns the element at the specified position in this list
        Node<E> current = tail; 
        for (int i = size-index-1; i>0; i--) {
            current = current.nextElement;
        }
        return current.element; 

    }

    @Override
    public int indexOf(Object o) {
        int indexOfObject = 0; 
        //Returns the index of the first occurence of the specifiked element in this list, or -1 if this list does not contain the element
        
        return indexOfObject; 

    }

    @Override
    public E set(int index, Object element) {
        //Replaces the element at the specified position in this list with the specified element 

    }

    @Override
    public MyLinkedList<E> subList(int fromIndex, int toIndex) { 
        //Returns a view of the poirtion of this list between the specified fromIndex, inclusive, and toIndex, exclusive 

    }
    
    
    // Från Object
    
    @Override 
    public String toString() {
        
    }
    
    @Override 
    public Object clone() {
        
        return; 
        
    }
    
    

}
