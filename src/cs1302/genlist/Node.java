package cs1302.genlist;

/** Represents a node in a linked list. */
public class Node<T> {
    private Node<T> next;
    private T element;

    /** Creates an empty node and sets {@code element} and {@code next} to null. */
    public Node() {
        next = null;
        element = null;
    } //Node

    /**
     * Creates a node that stores the specified element and has no {@code next} value.
     * @param e the element that is to be stored in the node
     */
    public Node(T e) {
        next = null;
        element = e;
    } //Node
    
    /**
     * Creates a node that stores the specified {@code element} and {@code next} values.
     * @param e the element that is to be stored in the node
     * @param node node that is to follow the current one
     */
    public Node(T e, Node<T> node) {
        element = e;
        next = node;
    } //Node

    /**
     * Returns a reference to the node that follows the current one.
     * @return a reference to the next node
     */
    public Node<T> getNext() {
        return next;
    } //getNext

    /**
     * Sets {@code next} to the specified node.
     * @param node the node that is to follow the current one
     */
    public void setNext(Node<T> node) {
        next = node;
    } //setNext

    /**
     * Returns the element stored in the current node.
     * @return the element stored in the node
     */
    public T getElement() {
        return element;
    } //getElement

    /**
     * Sets the current node's element.
     * @param e element to be stored in the node
     */
    public void setElement(T e) {
        element = e;
    } //setElement
} //Node
