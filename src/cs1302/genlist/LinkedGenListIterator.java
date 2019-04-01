package cs1302.genlist;
import cs1302.genlistadt.GenList;
import java.util.*;

/** Represents an iterator for LinkedGenList objects, allowing for for-each operations. */
public class LinkedGenListIterator<T> implements Iterator<T> {
    private Node<T> current;

    /**
     * Creates a {@code LinkedGenListIterator} object that iterates through a {@code Node<T>} list.
     * @param list the linked list that the iterator will iterate through 
     */
    public LinkedGenListIterator(Node<T> list) {
        current = list;
    } //LinkedGenListIterator
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        if(current.getNext() != null) {
            return true;
        } else {
            return false;
            
        }
    } //hasNext

    /**
     * {@inheritDoc}
     */
    @Override
    public T next() {
        if(hasNext() == false) {
            throw new NoSuchElementException("Iteration has no more elements");
        } else {
            T next = current.getNext().getElement();
            current = current.getNext();
            return next;
        }
    } //next
} //LinkedGenListIterator
