// Leet Code Problem

public class FindEvenNos {
    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            String numString = Integer.toString(nums[i]);
            if (numString.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 555, 901, 482, 1771 };
        System.out.println(findNumbers(nums));
    }
}
