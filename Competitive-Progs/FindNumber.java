package LeetCode;

class FindNumber {
    public int searchInArray(int[] intArray, int valueToSearch) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == valueToSearch) {
                return i;
            }
        }
        return -1;
    }

    public int searchBinary(int[] intArray, int valueToSearch, int low, int high) {
        int mid = (low + high) / 2;

        if (high >= mid) {
            return high;
        }

        if (intArray[mid] == valueToSearch) {
            return mid;
        }

        if (valueToSearch > mid) {
            searchBinary(intArray, valueToSearch, mid + 1, high);
        } else if (valueToSearch < mid) {
            searchBinary(intArray, valueToSearch, low, mid - 1);
        }
        return -1;
    }
}

class FindNoInArray {
    public static void main(String[] args) {
        FindNumber fNumber = new FindNumber();
        int[] intArray = { 2, 3, 4, 10, 40 };
        int result = fNumber.searchInArray(intArray, 10);
        System.out.println("Result " + result);
        int searchResult = fNumber.searchBinary(intArray, 10, 0, intArray.length);
        System.out.println("Search Result " + searchResult);

    }
}
