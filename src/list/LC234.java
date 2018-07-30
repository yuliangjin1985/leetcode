package list;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class LC234 {
  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode listNode1 = new ListNode(0);
    ListNode listNode2 = new ListNode(0);
    listNode.next = listNode1;
    listNode1.next = listNode2;
    System.out.println(new LC234().isPalindrome(listNode));
  }
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
}
