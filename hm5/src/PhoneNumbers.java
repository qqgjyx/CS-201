import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumbers {
    private static final char[][] CODES = {{},
            {}, {'A', 'B', 'C'}, {'D', 'E', 'F'},
            {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'},
            {'P', 'R', 'Q', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
    transient private ArrayList<Integer> pin = new ArrayList<>();
    final transient private ArrayList<String> rec = new ArrayList<>();
    public final boolean include01 = true; //TODO: Change to false if disregard of 0 and 1

    public boolean pinGetter(){
        String pinTemp;
        int trials = 0;
        int maxTrials = 10;

        System.out.println("Please enter a 0~6 digits integer: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt() && Integer.parseInt(pinTemp = scanner.nextLine()) >= 0 && pinTemp.length() <= 6 &&
                ((!pinTemp.contains("0") && !pinTemp.contains("1"))||include01)) {
                    pin = integerToArrayList(pinTemp);
                    return true;
                } else {
                    if (++trials == maxTrials) throw new TrailsOverflowException("Invalid input after " + maxTrials + " Trials");
                    System.out.println("Input format is not correct, please enter again: ");
                    scanner.nextLine();
                }
            }
        } catch (TrailsOverflowException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("All 0 or All 1, No valid input. ");
        }
        return false;
    }

    public ArrayList<Integer> integerToArrayList(String numberStr) throws IndexOutOfBoundsException{
        int index;
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < numberStr.length(); i++) {
            int digit = Character.getNumericValue(numberStr.charAt(i));
            index = i;
            while ((digit == 0 || digit == 1) && include01) digit = Character.getNumericValue(numberStr.charAt(++index));
            digitList.add(digit);
        }
        return digitList;
    }

    public void recGetter(int index, String current) {
        if (index == pin.size()) {
            rec.add(current);
            return;
        }

        char[] ch = CODES[pin.get(index)];
        for (char c : ch) {
            recGetter(index + 1, current + c);
        }
    }

    public static void main(String[] args) {
        PhoneNumbers p = new PhoneNumbers();
        if (p.pinGetter()) {
            p.recGetter(0, "");
            System.out.println(p.rec);
        }
    }

}
class TrailsOverflowException extends Exception{
    TrailsOverflowException(String error){super(error);}

}
