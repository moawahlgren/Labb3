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
public interface MyCollection<E> extends java.lang.Iterable<E> { 
   

    abstract public boolean add(E e); 
    //Ensures that this collection contains the specified element 
        

    abstract public boolean addAll(MyCollection<? extends E> c); 
    //Adds all of the elements in the specified collection to this collection 
        
        
    abstract public void clear(); 
    //Removes all of the elements from this collection
        
    
    abstract public boolean contains (Object o); 
    //Returns true if this collection contains the specified element
        

    abstract public boolean containsAll(MyCollection <?> c); 
    //Returns true if this collection contains all of the elments in te specfied collection
        
    
    @Override
    abstract public boolean equals(Object o);
    //Compares the specified object with this collection for equality 
        
    
    abstract public boolean isEmpty();  
    //Returns true if this collection contains no elements
        
    @Override
    abstract public Iterator<E> iterator();
    //Returns an iterator over the elements in this collection
        

    abstract public void remove(Object o); 
    //Removes a single instance of the specified element from thi scollection, if present
        

    abstract public void removeAll(MyCollection <?> c); 
    //Removes all of this collection's elements that are also contained in the specified collection
        
    
    abstract public void retainAll(MyCollection <?> c);  
    //Retains only the elements in this collecton that are contained in the specified collection 
        
  
    abstract public int size();
    //Returns the number of elements in this collection
        
    abstract public Object[] toArray();  
    //Returns an array containing all of the elements in this collection
    
}
