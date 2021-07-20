package udemyCourse;

import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public int magicFn(String key, int magicNumber) {
        char ch[];
        ch = key.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < key.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % magicNumber;
    }

    public void insert(String word) {
        int newIndex = magicFn(word, hashTable.length);
        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        } else {
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            return;
        }
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("At index " + i + "\t ||  Value " + hashTable[i]);
        }
    }

    public boolean search(String word) {
        int newIndex = magicFn(word, hashTable.length);
        if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
            System.out.println("Word found at : " + newIndex);
            return true;
        } else {
            System.out.println("Word not found");
            return false;
        }
    }

    public boolean deleteWord(String word) {
        int newIndex = magicFn(word, hashTable.length);
        boolean result = search(word);
        if (result == true) {
            hashTable[newIndex].remove(word);
            System.out.println("Deleted Word");
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        DirectChaining directChaining = new DirectChaining(15);
        directChaining.insert("The");
        directChaining.insert("quick");
        directChaining.insert("brown");
        directChaining.insert("fox");
        directChaining.insert("over");

        directChaining.displayHashTable();
    }

}
