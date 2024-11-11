package org.example;

public class Boy extends Human {
    public static void walk() {
        System.out.println("Boy walks");
    }
    public static void main(String args[]) {
        Human obj1 = new Boy();
        Human obj2 = new Human();
        Boy obj3 = new Boy();

        obj1.walk();
        obj2.walk();
        obj3.walk();

        Human hArr[] = {obj1, obj2, obj3};
        for (int i = 0; i < hArr.length; i++) {
            hArr[i].walk();
        }
    }
}