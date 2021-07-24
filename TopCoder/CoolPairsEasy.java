
// 88.68% success rate.
import java.util.Arrays;

class CoolPairsEasyChallenge {
    public int count(String[] firstname, String[] lastname) {
        int result = 0;
        if (firstname.length == 1) {
            return Arrays.asList(firstname).contains(lastname[0]) ? 0 : 1;
        }
        for (int i = 0; i < firstname.length; i++) {
            for (int j = 0; j < lastname.length; j++) {
                if (firstname[i].contains(lastname[j])) {
                    if (i == j)
                        continue;
                    result++;
                }
            }
        }
        return result;
    }
}

public class CoolPairsEasy {
    public static void main(String[] args) {
        CoolPairsEasyChallenge challenge = new CoolPairsEasyChallenge();
        String[] firstname = { "james", "taylor" };
        String[] lastname = { "taylor", "james" };
        int result = challenge.count(firstname, lastname);
        System.out.println("Result " + result);
    }
}
