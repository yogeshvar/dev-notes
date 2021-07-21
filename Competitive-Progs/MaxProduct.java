package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MaxProduct {
    public int[] maxProduct(int[] nums) {
        return new int[] {};
    }
}

class MaxProdInArray {
    public static void main(String[] args) {
        MaxProduct aMaxProduct = new MaxProduct();
        int[] intArray = { 10, 20, 30, 40, 50 };

        Set<Integer> uniqueSet = new HashSet<Integer>();
        uniqueSet.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 4 }));
        Object[] result = uniqueSet.toArray();

        System.out.println("Set" + Arrays.toString(result));
    }
}
