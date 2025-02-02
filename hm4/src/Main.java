class Main{
    static int n = 0;
    static void myRecursionFun(){
        System.out.println(n++);
        myRecursionFun();
    }
    public static void main(String[] args) {
        myRecursionFun();
    }

}