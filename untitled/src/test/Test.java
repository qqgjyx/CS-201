package test;
import aaa.*;
public class Test extends aaa.Test{
//    public void eat(){
//        System.out.println("eat");
//    }
}

class Human implements Life {
    @Override
    public void giveBirth() {
        System.out.println("born");
    }

    public static void main(String[] args) {
//        new aaa.Test().eat();
        Human human = new Human();
        human.giveBirth();
        human.method();
        Life.die();

    }

}

interface Life {
    void giveBirth();
    static void die(){
        System.out.println("Animal all died");
    }
    default void method() {
        System.out.println("Default Method");
    }
}
