public class ComputeTuition {
    public static void main(String[] args) {
        double tuition = 10000;
        double interest = 0.05;
        double total = 0;
        int year = 10;
        int[] period = {11, 14};

        for (int i = 2; i <= Math.max(year, period[1]); i++) {
            tuition += tuition * interest;
            if (i == year) System.out.println("Tuition for the tenth year: $" + tuition);
            if (i >= period[0]) total += tuition;
            if (i == period[1]) System.out.println("Total cost of four years' worth of tuition (11th to 14th year): $" + total);
        }
        /*
        System.out.println(10000*Math.pow(1.05, 9));
        System.out.println(10000*(Math.pow(1.05, 10)+Math.pow(1.05, 11)+Math.pow(1.05, 12)+Math.pow(1.05, 13)));
        */
    }
}

