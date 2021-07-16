public class AimToTen {

    public static int need(int[] marks) {
        double sum = 0;
        int ans = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        while (sum / (marks.length + ans) <= 9.5) {
            sum += 10;
            ans++;
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        int[] marks = { 8, 9 };
        int minAssignments = need(marks);
        System.out.println("Assignments still required : " + minAssignments);
    }

}
