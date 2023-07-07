package uz.friday;

public class Main {
    public static void main(String[] args) {
        var singLinkedList = new SingleLinkedList<String>();
        singLinkedList.add("Java");
        singLinkedList.add("Scala");
        singLinkedList.add("Python");
        singLinkedList.add("C++");
        singLinkedList.add("GoLang");
//        System.out.println(singLinkedList);
//        System.out.println("singLinkedList.size() = " + singLinkedList.size());
//        System.out.println("singLinkedList.get(0) = " + singLinkedList.get(0));
//        System.out.println(singLinkedList.addAtBeginning("C++"));
//        System.out.println(singLinkedList);
//        System.out.println(singLinkedList.removeFromBeginning());
        System.out.println(singLinkedList);
//        System.out.println(singLinkedList.remove(2));
//        System.out.println(singLinkedList);
//        System.out.println(singLinkedList.remove("Java"));
//        System.out.println(singLinkedList);
//
//        for (String s : singLinkedList) {
//            System.out.println(s);
//        }
//
        singLinkedList.set(3, "Kotlin");
        System.out.println(singLinkedList);

        /*
        size(); /
        get(index); /
        addAtBeginning(element); /
        removeFromBeginning(); /
        remove(index);
        remove(object);
        set(index, element);
         */

    }
}