package cs1302.genlist;
import cs1302.genlistadt.GenList;
import java.util.function.*;
import java.util.*;

/** Represents a generic linked list object. */
public class LinkedGenList<T> implements GenList<T> {
    private Node<T> list;

    /** Creates a {@code LinkedGenList} object with an empty node as its first and only node. */
    public LinkedGenList() {
        list = new Node<T>();
    } //LinkedGenList
    
    /**
     * Creates a {@code LinkedGenList} object with an empty node as its first node and then appends
     * a copy of the specified list to the end.
     * @param <U> the type of the objects in the specified list
     * @param other the list whose elements are to be copied
     */
    public <U extends T> LinkedGenList(GenList<U> other) {
        list = new Node<T>();
        Node<T> current = list;
        for(int i = 0; i < other.size(); i++) {
            T t = other.get(i);
            current.setNext(new Node<T>(t, null));
            current = current.getNext();
        }
    } //LinkedGenList
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        int size = 0;
        Node<T> current = list.getNext();
        while (current != null) {
            size++;
            if(size > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            current = current.getNext();
        }
        return size;
    } //size
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    } //isEmpty
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T o) {
        boolean contains = false;
        if (o == null) {
            throw new NullPointerException("Object is null");
        }
        for (T e : this) {
            if(o.equals(e)) {
                contains = true;
            }
        }
        return contains;
    } //contains

    /**
     * {@inheritDoc}
     */
    @Override
    public T[] toArray(IntFunction<T[]> gen) {
        T[] array = gen.apply(size());
        for(int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    } //toArray
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(T obj) {
        boolean add = false;
        if (obj == null) {
            throw new NullPointerException("Object is null");
        } 
        Node<T> current = list;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node<T>(obj));
        add = true;
        return add;
    } //add
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <U extends T> boolean add(GenList<U> list) {
        boolean add = false;
        if (list == null) {
            throw new NullPointerException("List is null");
        }
        if (this == list) { //Handles self reference
            GenList<U> list1 = new LinkedGenList<U>(list);
            add(list1);
        } else {
            Node<T> current = getNode(size());
            for(int i = 0; i < list.size(); i++) {
                current.setNext(new Node<T>(list.get(i)));
                current = current.getNext();
            }
        }
        add = true;
        return add;
    } //add

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, T obj) {
        boolean add = false;
        if (obj == null) {
            throw new NullPointerException("Object is null");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            Node<T> front = new Node<T>();
            Node<T> temp = new Node<T>(obj, list.getNext());
            front.setNext(temp);
            list = front;
        } else if (index == size()) { //if adding to end
            add(obj);
        } else { //if adding to middle
            Node<T> front = list.getNext();
            for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                front = front.getNext();
            }
            Node<T> back = new Node<T>(obj, front.getNext());
            front.setNext(back); //merges the 2 nodes with the added string in between
        }
        add = true;
        return add;
    } //add

    /**
     * {@inheritDoc}
     */
    @Override
    public <U extends T> boolean add(int index, GenList<U> list) {
        boolean add = false;
        if (list == null) {
            throw new NullPointerException("List is null");
        }
        if (this == list) { //Handles self reference
            GenList<U> list1 = new LinkedGenList<U>(list);
            add(index, list1);
        } else {
            if (index == size()) {
                add(list);
            } else {
                Node<T> front = this.list.getNext();
                for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                    front = front.getNext();
                }
                Node<T> back = front.getNext(); //sets back to the node currently at index
                for (int i = 0; i < list.size(); i++) { //adds list to front
                    front.setNext(new Node<T>(list.get(i)));
                    front = front.getNext();
                }
                front.setNext(back); //merges the 2 lists together
            }
            add = true;
        }
        return add;
    } //add

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        T t = null;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = list.getNext(); //Skips the first node that is always empty
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        t = current.getElement();
        return t;
    } //get

    /**
     * Returns a reference to the index-th node in a linked list
     * @param index the index of the node
     * @return a reference to the index-th node
     */
    private Node<T> getNode(int index) {
        Node<T> current;
        if (size() == 0) {
            current = list;
        } else {
            current = list.getNext();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
        }
        return current;
    } //getNode

    /**
     * {@inheritDoc}
     */
    @Override
    public T set(int index, T obj) {
        T t = null;
        if (obj == null) {
            throw new NullPointerException("Object is null");
        } else if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = getNode(index + 1);
        t = current.getElement();
        current.setElement(obj);
        return t;
    } //set

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(int index) {
        T t = null;
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> front = list.getNext();
        if(index == 0) { //if you want to remove the first element in the list
            t = front.getElement();
            list = front;
        } else {
            for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                front = front.getNext();
            }
            t = front.getNext().getElement();
            //back equals the node after the index node
            Node<T> back = front.getNext().getNext();
            front.setNext(back); //merges front and back, omitting the index node
        }
        return t;
    } //remove

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(T obj) {
        int index = -1;
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }
        for(int i = 0; i < size(); i++) {
            if(obj.equals(get(i))) {
                index = i;
            }
        }
        return index;
    } //indexOf

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        Node<T> list1 = new Node<T>();
        list = list1;
    } //clear

    /**
     * {@inheritDoc}
     */
    @Override
    public GenList<T> distinct() {
        GenList<T> list1 = new LinkedGenList<T>();
        Node<T> current = list.getNext();
        for(int i = 0; i < size(); i++) {
            if(list1.indexOf(current.getElement()) == -1) {
                list1.add(current.getElement());
            }
            current = current.getNext();
        }
        return list1;
    } //distinct

    /**
     * {@inheritDoc}
     */
    @Override
    public GenList<T> reverse() {
        GenList<T> list1 = new LinkedGenList<T>();
        for(int i = size() - 1; i >= 0; i--) {
            list1.add(get(i));
        }
        return list1;
    } //reverse

    /**
     * {@inheritDoc}
     */
    @Override
    public String makeString(String sep) {
        String string = "";
        if(size() != 0) {
            for(int i = 0; i < size() - 1; i++) {
                string = string + get(i) + sep;
            }
            string = string + get(size() - 1);
        }
        return string;
    } //makeString

    /**
     * {@inheritDoc}
     */
    @Override
    public GenList<T> splice(int fromIndex, int toIndex) {
        GenList<T> list1 = new LinkedGenList<T>();
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for(int i = fromIndex; i < toIndex; i++) {
            list1.add(get(i));
        }
        return list1;       
    } //splice

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new LinkedGenListIterator<T>(list);
        return iterator;
    } //iterator

    /**
     * {@inheritDoc}
     */
    @Override
    public T min(Comparator<T> c) {
        if(c == null) {
            throw new NullPointerException("Comparator is null");
        }
        T min = get(0);
        for(T e : this) {
            if(c.compare(min, e) > 0) {
                min = e;
            }
        }
        return min;
    } //min

    /**
     * {@inheritDoc}
     */
    @Override
    public T max(Comparator<T> c) {
        if(c == null) {
            throw new NullPointerException("Comparator is null");
        }
        T max = get(0);
        for(T e : this) {
            if(c.compare(max, e) < 0) {
                max = e;
            }
        }
        return max;
    } //max

    /**
     * {@inheritDoc}
     */
    @Override
    public GenList<T> filter(Predicate<T> p) {
        if (p == null) {
            throw new NullPointerException("Predicate is null");
        }
        GenList<T> list1 = new LinkedGenList<T>();
        for(T e : this) {
            if(p.test(e)) {
                list1.add(e);
            }
        }
        return list1;
    } //filter
    
    /**
     * {@inheritDoc}
     */
    @Override
    public <R> GenList<R> map(Function<T, R> f) {
        if (f == null) {
            throw new NullPointerException("Function is null");
        }
        GenList<R> list1 = new LinkedGenList<R>();
        for(T e : this) {
            if(f.apply(e) == null) {
                throw new NullPointerException("Result of the function is null");
            }
            list1.add(f.apply(e)); 
        }
        return list1;
    } //map
    
    /**
     * {@inheritDoc}
     */
    @Override
    public T reduce(T start, BinaryOperator<T> f) {
        if(f == null) {
            throw new NullPointerException("Function is null");
        }
        T result = start;
        if(result == null) {
                throw new NullPointerException("Result of the function is null");
        }
        for(T e : this) {
            result = f.apply(result, e);
            if(result == null) {
                throw new NullPointerException("Result of the function is null");
            }
        }
        return result;
    } //reduce

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allMatch(Predicate<T> p) {
        boolean allMatch = true;
        if(p == null) {
            throw new NullPointerException("Predicate is null");
        } else {
            for(T e : this) {
                if(p.test(e) == false) {
                    allMatch = false;
                }
            }
        }
        return allMatch;
    } //allMatch

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean anyMatch(Predicate<T> p) {
        boolean anyMatch = false;
        if(p == null) {
            throw new NullPointerException("Predicate is null");
        } else {
            for(T e : this) {
                if (p.test(e)) {
                    anyMatch = true;
                }
            }
        }
        return anyMatch;
    } //anyMatch
} //LinkedGenList
