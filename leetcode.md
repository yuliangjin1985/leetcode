## 709. To Lower Case
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
### Example 1:
    Input: "Hello"
    Output: "hello"
### Example 2:
    Input: "here"
    Output: "here"
### Example 3:
    Input: "LOVELY"
    Output: "lovely"
### Solution
    class Solution {
        public String toLowerCase(String str) {
            /**
            int len = str.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<len;i++) {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
            return sb.toString();
            */

            //ASCII code for 'A' is 65, 'a' is 97
            char[] chars = str.toCharArray();
            char[] lower = new char[chars.length];
            for(int i=0;i<chars.length;i++) {
                lower[i] = chars[i] >= 'A' && chars[i] <='Z'  ? (char)(chars[i] - 'A' + 'a') : chars[i];
            }
            return new String(lower);
        }
    }

## 161. One Edit Distance
      public static boolean isOneEditDistance(String s, String t) {
        int lenS = s.length(), lenT = t.length();

        if(Math.abs(lenS - lenT) >= 2) return false;

        for(int i=0; i<Math.min(lenS, lenT); i++) {
          if(s.charAt(i) != t.charAt(i)) {
            if(lenS == lenT) return s.substring(i+1).equals(t.substring(i+1));
            else if(lenS < lenT) return s.substring(i).equals(t.substring(i+1));
            else return s.substring(i + 1).equals(t.substring(i));
          }
        }
        return Math.abs(lenS - lenT) == 1;
      }

## 72. Edit Distance
dp[i][j] is the distances from word1(0-i-1) to word2(0-j-1).

    public class EditDistance {
      public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i=1; i<=len1; i++) {
          dp[i][0] = i;
        }

        for(int i=0;i<=len2;i++) {
          dp[0][i] = i;
        }

        for(int i=1;i<=len1;i++) {
          for(int j=1;j<=len2;j++) {
            if(word1.charAt(i-1) == word2.charAt(j-1)) {
              dp[i][j] = dp[i-1][j-1];
            } else {
              dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
          }
        }
        return dp[len1][len2];
      }
    }

## 455. Assign Cookies(greedy)
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive.
You cannot assign more than one cookie to one child.

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int i=0;
            int num = 0;
            for(int j=0;j<s.length && i<g.length;j++) {
                if(g[i] <= s[j]) {
                    num++;
                    i++;
                }
            }
            return num;
        }
    }

## 234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome. Could you do it in O(n) time and O(1) space?
Hint: Use two pointers to find the middle element of the list, then reverse the second half of the list, and compare whether the two list is equal for every element in the second reversed list.

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast=head, slow=head;
        while(fast.next !=null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        if(fast.next != null) {
          slow = slow.next;
        }
        ListNode head1 = reverse(slow);
        while(head1!=null) {
          if(head.val != head1.val) {
            return false;
          }
          head1 = head1.next;
          head = head.next;
        }
        return true;
      }
      public ListNode reverse(ListNode node) {
        ListNode newHead = null;
        while(node != null) {
          ListNode next = node.next;
          node.next = newHead;
          newHead = node;
          node = next;
        }
        return newHead;
      }
