package basic;

class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }
}

// 1 2 3 4
// cur, next
public class KForce {
    ListNode<Integer> reverseLinkedList(ListNode<Integer> l) {
        ListNode<Integer> pre = null;
        while(l != null) {
            ListNode<Integer> next = l.next;
            l.next = pre;
            pre = l;
            l = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>(1);
        node.next = new ListNode<>(2);
        node.next.next = new ListNode<>(3);
        node.next.next.next = new ListNode<>(4);
        node.next.next.next.next = new ListNode<>(5);
        ListNode<Integer> listNode = new KForce().reverseLinkedList(node);
        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }
    }

    public boolean isBeautifulString(String inputString) {
        int[] count = new int[26];
        for(char c : inputString.toCharArray()) {
            count[c-'a']++;
        }
        for(int i=1;i<26;i++) {
            if(count[i] > count[i-1]) return false;
        }
        return true;
    }
}
