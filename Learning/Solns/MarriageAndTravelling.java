class MarriageAndTravellingChallenge {
    public String solve(String echo) {
        int i, j;
        String ans = "";
        for (i = 0, j = 1; i < echo.length();) {
            ans += echo.charAt(i);
            i += j;
            j++;
        }
        return ans;
    }
}

public class MarriageAndTravelling {
    public static void main(String[] args) {
        MarriageAndTravellingChallenge marriageAndTravellingChallenge = new MarriageAndTravellingChallenge();
        String echo = "saalllaaaammmmm";
        String result = marriageAndTravellingChallenge.solve(echo);
        System.out.println("Result : " + result);
    }
}
