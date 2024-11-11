package org.example;

public class Main {

    static void test(Object o) {
        System.out.println(o.toString());
    }

    static<E> void test2(E o) {
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        int a = 5;
        test(a);
        test2(a);
//        Person p1 = new Person();
//        Person p2 = new Employee();
//        Person p3 = new Manager();
//        Manager p4 = new Manager();
//
//        System.out.println(p2 instanceof Person);
//        System.out.println(p2 instanceof Employee);
//        System.out.println(p1.getDetail());  // Kết quả: "Person Detail"
//        System.out.println(p2.getDetail());  // Kết quả: "Employee Detail"
//        System.out.println(p3.getDetail());  // Kết quả: "Manager Detail"
//        System.out.println(p4.only());
//        Human h = new Human();
//        Human b = new Boy();
//        h.walk();
//        b.walk();



    }
}