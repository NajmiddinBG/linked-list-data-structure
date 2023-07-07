package uz.friday;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class SingleLinkedList<E> implements Iterable<E>{

    private Node<E> head;

    private int size;

    public boolean add(E element) {
        var newNode = new Node<E>(element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            var current = this.head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        this.size++;
        return true;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return removeFromBeginning();
        var current = head;
        for (int i = 1; i < index; i++)
            current = current.next;
        var element = current.next.element;
        current.next = current.next.next;
        size--;
        return element;
    }
    public boolean remove(Object o) {
        if (head == null)
            return false;
        Node<E> prev = null;
        Node<E> current = head;
        while (current != null) {
            if (Objects.equals(o, current.element)) {
                if (prev == null)
                    head = current.next;
                else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0)
            return head.element;
        var current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public boolean addAtBeginning(E element) {
        var newNode = new Node<E>(element);
        if (!Objects.isNull(this.head))
            newNode.next = head;
        this.head = newNode;
        size++;
        return true;
    }

    public E removeFromBeginning() {
        if (head == null)
            throw new NoSuchElementException("LinkedList is empty");
        var old = head.element;
        head = head.next;
        size--;
        return old;
    }

    public boolean set(int index, E element) {
        Objects.checkIndex(index, size);
        if (head == null)
            return false;
        if (index == 0) {
            head.element = element;
            return true;
        }
        var current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        current.element = element;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.next;
                return element;
            }
        };
        return iter;
    }


    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "[", "]");
        var current = this.head;
        while (current != null) {
            sj.add(String.valueOf(current.element));
            current = current.next;
        }
        return sj.toString();
    }
}
