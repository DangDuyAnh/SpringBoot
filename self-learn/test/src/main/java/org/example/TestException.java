package org.example;

public class TestException {
    public static int divide(int a, int b) {
        return a/b;
    }

    public static void main (String args[]) {
        int a = 1;
        int b = 0;
        int c;
        try {
            c = divide(a,b);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
