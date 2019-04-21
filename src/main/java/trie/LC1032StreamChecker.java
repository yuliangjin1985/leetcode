package trie;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC1032StreamChecker {

    String[] words = null;
    Node root = null;
    String input = "";
    int max = 0;
    Set<String> set = null;
    List<String> prefix = null;

    public LC1032StreamChecker(String[] w) {
        root = new Node();
        words = w;
        set = new HashSet<>();
        prefix = new LinkedList<>();
        prefix.add("");

        for(String word : words) {
            if(!set.contains(word)) {
                set.add(word);
                max = Math.max(max, word.length());
                Node node = root;
                for(int i=0;i<word.length();i++) {
                    if(node.children[word.charAt(i)-'a'] == null) {
                        node.children[word.charAt(i)-'a'] = new Node();
                    }
                    node = node.children[word.charAt(i)-'a'];
                }
                node.isWord = true;
            }
        }
    }

    public boolean query(char letter) {

        List<String> temp = new LinkedList<>();
        for(String cur : prefix) {
            temp.add(cur);
            cur += letter;
            if(exists(cur)) {
                temp.add(cur);
                if(isWord(cur)) {
                    prefix = temp;
                    return true;
                }
            }
        }
        prefix = temp;
        return false;
    }

    public boolean exists(String s) {
        System.out.println(s);
        Node node = root;
        for(int i=0;i<s.length();i++) {
            if(node.children[s.charAt(i)-'a'] == null) return false;
            node = node.children[s.charAt(i)-'a'];
        }
        return true;
    }

    public boolean isWord(String s) {
        System.out.println(s);
        Node node = root;
        for(int i=0;i<s.length();i++) {
            if(node.children[s.charAt(i)-'a'] == null) return false;
            node = node.children[s.charAt(i)-'a'];
        }
        return node.isWord;
    }

    public static void main(String[] args) {
        LC1032StreamChecker lc1032StreamChecker = new LC1032StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(lc1032StreamChecker.query('a'));
        System.out.println(lc1032StreamChecker.query('b'));
        System.out.println(lc1032StreamChecker.query('c'));
        System.out.println(lc1032StreamChecker.query('d'));
        System.out.println(lc1032StreamChecker.query('e'));
        System.out.println(lc1032StreamChecker.query('f'));
        System.out.println(lc1032StreamChecker.query('g'));
        System.out.println(lc1032StreamChecker.query('h'));
        System.out.println(lc1032StreamChecker.query('i'));
        System.out.println(lc1032StreamChecker.query('j'));
        System.out.println(lc1032StreamChecker.query('k'));
        System.out.println(lc1032StreamChecker.query('l'));
    }
}

class Node {
    boolean isWord;
    Node[] children;
    Node() {
        children = new Node[26];
    }
}
