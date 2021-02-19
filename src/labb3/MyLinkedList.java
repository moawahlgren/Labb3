/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaraRoempke & MoaWahlgren
 * @param <E>
 */
public class MyLinkedList<E> extends Object implements MyList<E> {

    private Node<E> head;
    private Node<E> tail; 
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<E> {

        E element;
        Node<E> next;   
        Node<E> previous; 

        public Node(E element) { //Constructor to create new node 
            this.element = element;
        }

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous; 
        }
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator<E> implements java.util.Iterator<E> {

        private Node<E> current, previous;

        public MyIterator(Node<E> node) {
            current = node;
            previous = null;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            if (current != null) {
                previous = current;
                current = previous.next;
                return previous.element;
            } 
            else {
                return null;
            }
        }

        @Override
        public void remove() {
            previous.next = current.next;
            current = previous.next;
        }
    }

    private void addFirst(E e) {
        if (size == 0) {
            Node<E> newNode = new Node<>(e);
            newNode.previous = null;
            head = newNode;            
        }
        else {
            Node<E> newNode = new Node<>(e); 
            newNode.next = head; 
            newNode.previous = null;
            if (head != null) {
                head.previous = newNode; 
            }
            head = newNode; 
            size ++;
        }
        
        
    }

    private void addLast(E e) {
        Node<E> newNode = new Node<>(e); 
        Node<E> testNode = head; 
        newNode.next = null; 
        if (head == null) {
            head.next = newNode; 
            newNode.previous = null;
            head = newNode; 
        }
        else {
            while (testNode.next != null) {
                testNode = testNode.next;
            }
            testNode.next = newNode; 
            newNode.previous = testNode; 
        }
    }

    //Nedan är metoder i MyCollection 
    @Override
    public boolean add(E e) {
        //Ensures that this collection contains the specified element 
        if (size == 0) {
            addFirst(e);
        }
        else {
            addLast(e);
        }
        size++;
        return true;
    }

    @Override
    public boolean addAll(MyCollection<E> c) {
        //Adds all of the elements in the specified collection to this collection 
        Object[] array; 
        array = c.toArray(); 
        MyLinkedList<E> list = new MyLinkedList<>(); 
        Node<E> testNode = head; 
        for (int i = 0; i < c.size(); i++) {

        }
        
        return true;
    }

    @Override
    public void clear() {
        //Removes all of the elements from this collection
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        //Returns true if this collection contains the specified element
        for (int i = 0; i < size; i++) {
            if (get(i) == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyCollection<E> c) {
        //Returns true if this collection contains all of the elments in the specfied collection
        Object[] array;
        array = c.toArray();
        for (int i = 0; i<c.size(); i++) {
            if (contains(array[i]) == false) {
                return false; 
            }
        }
        return true; 
    }

    @Override
    public boolean equals(Object o) {
        //Compares the specified object with this collection for equality 
        return (this == o);
    }

    @Override
    public boolean isEmpty() {
        //Returns true if this collection contains no elements
        return head == null; 
    }

    private boolean removeFirst() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        head.previous = null; 

        size --;
        return true;
    }

    private boolean removeLast() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            clear();
        }

        Node<E> current = head;
        for (int i = 0; i < size - 2; i++) {
            current = current.next;
        }
        tail = current;
        tail.next = null;
        size --;
        return true;
    }
    
    @Override
    public boolean remove(Object o) { 
        if (contains(o) == false) {
            return false; 
        }
        if (indexOf(o) < 0 || indexOf(o) >= size) {
            return false;
        }
        if (indexOf(o) == 0) {
            return removeFirst(); 
        }
        if (indexOf(o) == size -1) {
            return removeLast(); 
        }
        Node<E> testNode = head;
        for (int i=0; i < indexOf(o); i++) {
            testNode = testNode.next; 
        }
        testNode.previous.next = testNode.next; 
        testNode.next.previous = testNode.previous;
        size --; 
        
        return contains(o) == false; 
    }
    
   
    public boolean remove(int index) {
        //Removes a single instance of the specified element from this collection, if present
        if (index == 0) {
            return removeFirst(); 
        }
        if (index == size-1) {
            return removeLast();
        }
        if (index >= size) {
            return false; 
        }
        Node<E> testNode = head; 
        for (int i=0; i<index; i++) {
            testNode = testNode.next; 
        }
        testNode.previous.next = testNode.next; 
        testNode.next.previous = testNode.previous; 
        System.out.println("Tar bort" + testNode.element);
        size--; 
        
        return true;
    }

    @Override
    public boolean removeAll(MyCollection c) {
        //Removes all of this collection's elements that are also contained in the specified collection
        int removedElements = 0; 
        Object[] array;
        array = c.toArray();
        System.out.println("Printar arrray som ska raderas. " + Arrays.toString(c.toArray()));
        for (int i = 0; i<c.size(); i++) {
            if (contains(array[i])) {
                remove(array[i]);
                removedElements ++; 
            }
        }
        return removedElements == c.size(); 
    }

    @Override
    public void retainAll(MyCollection c) {
        //Retains only the elements in this collecton that are contained in the specified collection 
        for (int i = 0; i < size; i++) {
            if (c.contains(get(i)) == false) {
                this.remove(i);
            }
        }
    }

    @Override
    public int size() {
        //Returns the number of elements in this collection
        return size;
    }

    @Override
    public Object[] toArray() {
        //Returns an array containing all of the elements in this collection
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = get(i);
        }
        return array;
    }

    //Nedan är metoder i MyList
    @Override
    public void add(int index, E element) throws LinkedException {
        //Appends the specified element to the end of this list
        if (index > size) {
            throw new LinkedException("Index bigger than size");
        } 
        if (index == size) {
            add(element);
        }
        if (index == 0) {
            addFirst(element); 
        } else {
            
            Node<E> newNode = new Node<>(element); 
            Node <E> previous = head; 
            for (int i = 0; i < index-1; i++) {
                previous = previous.next; 
            }
            newNode.next = previous.next; 
            previous.next = newNode; 
            newNode.previous = previous; 
 
            size++;
        }
    }

    @Override
    public boolean addAll(int index, MyCollection<E> c) {
        //Inserts all of the elements in the specified collection into this list at the specified position 
        // Vi vill kunna använda add? Objekt behöver bli element..
        MyIterator<E> iteratorTest = (MyIterator<E>) c.iterator(); 
 
        for(int i = 0; i<c.size(); i++){
            try {
                add(index, iteratorTest.next());
            } catch (LinkedException ex) {
                Logger.getLogger(MyLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return containsAll(c); 
    }

    @Override
    public E get(int index) {
        //Returns the element at the specified position in this list
        if (size == 0) {
            //Throw exception?? 
            return null;
        }
        if (index > size) {
            return null; 
        }
        
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int indexOf(Object o) {
        //Returns the index of the first occurence of the specified element in this list, or -1 if this list does not contain the element
        
            for (int i = 0; i < size; i++) {
                if (get(i) == o) {
                    return i;
                }
            }

        return -1;
    }

    @Override
    public E set(int index, Object element) {
        //Replaces the element at the specified position in this list with the specified element 

    }

    @Override
    public MyLinkedList<E> subList(int fromIndex, int toIndex) {
        //Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive 
        if (fromIndex >= toIndex) {
            //Throw exception???
            return null;
        }

        MyLinkedList<E> copyList = new MyLinkedList();

        for (int i = fromIndex; i < toIndex; i++) {
            copyList.add(this.get(i));
        }
        return copyList;
    }

    //Från Object
    @Override
    public String toString() {

        StringBuilder string = new StringBuilder(" ");

        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode != null) {
                string.append(currentNode.element);
                currentNode = currentNode.next;
            } 
            if(currentNode != null) {
                string.append(", ");
            }
            if (currentNode == null) {
                string.append(" ");
            }
        }
        return string.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        try {
            return super.clone();
        } catch (CloneNotSupportedException b) {
            return null;
        }
    }

}

