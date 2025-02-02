import java.util.Arrays;

public class TestOnly {
    public static void main(String[] args) {
        int[] arr1 = {0,};
        int[] arr2 = {1, 2, 4, 3, 5, 7, 6};
        int[] arr3 = {1, 2, 2, 3, 4};
        int[] arr4 = {0, 1, 2, 0, 3, 4, Integer.MAX_VALUE, Integer.MIN_VALUE};
        CheckDuplicate_1(arr1);
        CheckDuplicate_1(arr2);
        CheckDuplicate_1(arr3);
        CheckDuplicate_1(arr4);
        CheckDuplicate_2(arr1);
        CheckDuplicate_2(arr2);
        CheckDuplicate_2(arr3);
        CheckDuplicate_2(arr4);
    }
    public static void CheckDuplicate_1(int[] arr) {
//        your solution here
        int[] newArr = new int[arr.length];
        boolean hasDuplicate = false;
        boolean seen0 = false;
        label:
        for (int i = 0; i < arr.length; i++) {
            for (int k : newArr) {
                if (arr[i] == 0 && !seen0) {
                    seen0 = true;
                    break;
                } else if (arr[i] == 0 && seen0) {
                    hasDuplicate = true;
                    break label;
                } else if (arr[i] == k) {
                    hasDuplicate = true;
                    break label;
                }
            }
            newArr[i] = arr[i];
        }
//        System.out.println(Arrays.toString(newArr));
//        System.out.println(count0);
        if (hasDuplicate) {
            System.out.println("Yes Duplicate");
        } else {
            System.out.println("No Duplicate");
        }
    }

    public static void CheckDuplicate_2(int[] arr) {
//        your solution here
        boolean pin = false;
//        int counter = 0;
        label:
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
//                counter ++;
                if (arr[i] == arr[j]) {
                    pin = true;
                    break label;
                }
            }
        }
        if (pin) {
            System.out.println("Yes Duplicate");
        } else {
            System.out.println("No Duplicate");
        }
//        System.out.println(counter);
    }
}


}


