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
 */
public interface MyList<E> extends MyCollection {
    
    
    abstract public void add(int index, E element);
    //Appends the specified element to the end of this list

    
    abstract public boolean addAll(int index, MyCollection<? extends E> c); 
    //Inserts all of the elements in the specified collection into this list att the specified position 
        
    
    abstract public E get(int index);  
    //Returns the element at the specified position in this list
    
    
    abstract public int indexOf(Object o); 
    //Returns the index of the first occurence of the specifiked element in this list, or -1 if this list does not contain the element
        
 
    abstract public E set(int index, E element); 
    //Replaces the element at the specified position in this list with the specified element 
      
    
    abstract public MyList<E> subList(int fromIndex, int toIndex); 
    //Returns a view of the poirtion of this list between the specified fromIndex, inclusive, and toIndex, exclusive 
        
    
}