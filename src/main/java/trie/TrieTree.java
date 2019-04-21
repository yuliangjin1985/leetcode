package trie;

public class TrieTree {

    /**
     * Trie is an efficient information reTrieval data structure. Using Trie, search complexities can be brought to optimal limit (key length).
     * If we store keys in binary search tree, a well balanced BST will need time proportional to M * log N, where M is maximum string length
     * and N is number of keys in tree. Using Trie, we can search the key in O(M) time. However the penalty is on Trie storage requirements
     * (Please refer Applications of Trie for more details)
     * @param args
     */
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        TrieNode root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(root, keys[i]);

        // Search for different keys
        if(search(root, "the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search(root, "these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search(root, "their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search(root, "thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }

    public static void insert(TrieNode root, String word) {
        int len = word.length();
        TrieNode cur = root;
        for(int i=0;i<len;i++) {
            if(cur.children[word.charAt(i)-'a'] == null) {
                cur.children[word.charAt(i)-'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i)-'a'];
        }

        cur.isEndOfWord = true;
    }

    public static boolean search(TrieNode root, String word) {
        int len = word.length();
        TrieNode cur = root;
        for(int i=0;i<len;i++) {
            if(cur.children[word.charAt(i)-'a'] == null) {
                return false;
            }
            cur = cur.children[word.charAt(i)-'a'];
        }

        return cur.isEndOfWord;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = true;
    }
}
