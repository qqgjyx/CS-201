public class RecursiveMethod {

    //Answer starts here: (delete other part if not need)
    static void checkEvenOdd(int num) {
        if (num == 0) {
            System.out.println("The number is even.");
        } else if (num == 1 || num == -1) {
            System.out.println("The number is odd.");
        } else if (num > 0) {
            checkEvenOdd(num - 2);
        } else {
            checkEvenOdd(num + 2);
        }
    }
    //Answer ends here (delete other part if not need)
    public static void main(String[] args) {
        checkEvenOdd(0);
    }
}
