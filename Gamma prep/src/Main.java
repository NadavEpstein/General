import java.util.*;

class main {

    /*
    2-SUM problem:

    input: An array A of n integers and another integer k

    output: If there exist two numbers A[i] and A[j] such that
            A[i] + A[j] = k
            return true, otherwise return false.
    */
    public static boolean twoSum (int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length ; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (map.get(k - arr[i]) != null && map.get(k - arr[i]) != i) {
                System.out.println(arr[i] + ", " + (k - arr[i]));
                return true;
            }
        }

        return false;
    }

    //And now 3-Sum!

    /*
    3-SUM problem:

    input: An array A of n integers and another integer k

    output: If there exist three numbers A[i], A[j] and a[l] such that
            A[i] + A[j] + A[l]= k
            return true, otherwise return false.
    */

    public static boolean threeSum (int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < arr.length ; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr.length ; j++) {
                if (j == i) {
                    continue;
                }

                int complement = k - arr[i] - arr[j];
                Integer wanted = map.get(complement);
                if (wanted != null && wanted != i && wanted != j) {
                    System.out.println(arr[i] + ", " + arr[j] + ", " + arr[wanted]);
                    return true;
                }
            }
        }

        return false;
    }
    public static void main (String[] args) {
        // Let's try 2-sum!
        System.out.println("Let's try 2-sum!\n");
        int[] twoSumArr = {1 ,43, 6, 3, 50, 8 ,7 , 6 , 6 ,88};
        boolean res1 = twoSum(twoSumArr, 16);
        System.out.println(res1);

        //Let's try 3-sum!
        System.out.println("Let's try 3-sum!\n");
        int[] threeSumArr = {1 ,43, 6, 3, 50, 8 ,7 , 6 , 6 ,88};
        boolean res2 = threeSum(threeSumArr, 15);
        System.out.println(res2);
    }
}