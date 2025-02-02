import java.util.Scanner;

public class Solution {
    public static void main(String args[])
    {
        try {
            int data=25/0;
            System.out.println(data);
        }
        catch(NullPointerException e)
        {
            System.out.println("exception is handled");
        }
        finally
        {
            System.out.println("in the finally block …");
        }
        System.out.println("rest of the code...");
    }
}

class Crow extends BirdAbs
        implements BirdInt_1 {
    public void eat() {
        System.out.println("eat");
    }
    public void sound(){
        System.out.println("sound");
    }
}

abstract class BirdAbs {
    public abstract void
    eat();
}



interface BirdInt_1 {
    public void sound();
}

interface BirdInt_2 {
    public void sound();
}

class Crow1 implements BirdInt_1,
        BirdInt_2
{
    public void sound() {
         }
}

abstract class BirdAbs1 {
    public abstract void eat();
    public void perch ()
    { }
}

class Crow12 extends BirdAbs1
{
    @Override
    public void eat() {

    }

    public void perch() {}
}
