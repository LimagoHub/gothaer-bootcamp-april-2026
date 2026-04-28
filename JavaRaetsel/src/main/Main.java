package main;

public class Main {
    public static void main(String[] args) {
        new B();
        new B();
    }
}
class A {
    static {  System.out.println("A");  }
    { System.out.println("B"); }
    public A() {
        System.out.println("C");
        foo();
    }
    public void foo() {
        System.out.println("Foo von a");
    }
}
class B extends A {
    public B() {
        System.out.println("D");
    }
    public void foo() {
        System.out.println("Foo von b");
    }
}
