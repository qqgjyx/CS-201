abstract class Animal{
    private int age = 10;

    public void move(){
        System.out.println("跑步数："+this.age);
    }
}

abstract class Dog extends Animal{
    public Dog(int age){
        System.out.println("初始化Dog");
    }

}

public class BigDogs extends Dog{
    public BigDogs(){
        super(20);
        System.out.println("初始化BigDog");
    }

    public static void main(String[] args){
        BigDogs a = new BigDogs();
        a.move();
    }
}
