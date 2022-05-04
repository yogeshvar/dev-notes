import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class HouseNumberingChallenge {
    public Object[] prepareDigits(int firstHouse, int numberOfHouses) {
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        int[] houseNumbers = new int[numberOfHouses];
        houseNumbers[0] = firstHouse;
        for (int i = 1; i < houseNumbers.length; i++) {
            houseNumbers[i] = houseNumbers[i - 1] + 2;
        }

        for (int i = 0; i < houseNumbers.length; i++) {
            char[] digits = getDigits(houseNumbers[i]);
            for (int j = 0; j < digits.length; j++) {
                Random random = new Random();
                result.add(random.nextInt(10), Character.getNumericValue(digits[j]));
            }
        }

        return result.toArray();
    }

    private char[] getDigits(int number) {
        String numberString = String.valueOf(number);
        char[] digits = numberString.toCharArray();
        return digits;
    }
}

public class HouseNumbering {
    public static void main(String[] args) {
        HouseNumberingChallenge houseNumberingChallenge = new HouseNumberingChallenge();
        int firstHouse = 7;
        int numberOfHouses = 4;
        Object[] result = houseNumberingChallenge.prepareDigits(firstHouse, numberOfHouses);
        System.out.println("Result : " + Arrays.toString(result));
    }

}
