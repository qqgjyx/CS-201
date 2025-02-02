public class RecursionPower {
    static long calPower(int x, int n) {
//uncomment try...catch part if in-method exception catch is needed
//        try {
        if (n < 0) {
            throw new ArithmeticException("Exponent must be non-negative");
        }
        if (x == 0) {
            if (n == 0) {
                throw new ArithmeticException("zero to the power of zero");
            }
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long temp = calPower(x, n / 2);
        if ((temp>0 && temp > Long.MAX_VALUE / temp) ||
                (temp<0 && temp < Long.MAX_VALUE / temp)) {
            throw new ArithmeticException("Overflow occurred during calculation");
        }

        long tempSquared = temp * temp;
        if (n % 2 != 0) {
            if ((x > 0 && tempSquared > Long.MAX_VALUE / x) ||
                    (x < 0 && tempSquared > Long.MIN_VALUE / x)) {
                throw new ArithmeticException("Overflow occurred during calculation");
            }
        }
        return tempSquared * (n % 2 != 0 ? x : 1);
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException thrown: " + e.getMessage());
//            return 0;
//        }
    }



    public static void main(String[] args) {
        System.out.println((long)Math.pow(2, 50));
        long answer = calPower(2, 50);
        System.out.println(answer);
    }
}
