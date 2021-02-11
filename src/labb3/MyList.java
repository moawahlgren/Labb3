/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labb3;

/**
 *
 * @author moawahlgren
 */
public class MyList<E> implements java.lang.Iterable<E> {
   
    private Node<E> head;
    private Node<E> tail; 
    private int size; 
    
    MyList() {
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
    
    public int size() {
        return size; 
    }
    
    public void add(E element) {
        tail = new Node(element, tail);
        size ++; 
    }
    
    
 
    
    
}