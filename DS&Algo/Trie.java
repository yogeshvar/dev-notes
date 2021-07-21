package udemyCourse;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfString;

    public TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        System.out.println("Trie created");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Inserted Word");
    }

    public void search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println("Word not found");
            }
            current = node;
        }
        if (current.endOfString == true) {
            System.out.println("Word exists");
        } else {
            System.out.println("Prefix exists");
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("APPLICATION");
        trie.insert("API");
        trie.search("APPLICATI");
    }
}
