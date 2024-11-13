package com.leetcode.medium;

public class pro19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 1;
    ListNode tmp = head;
    ListNode node = new ListNode(0, head);
    while (tmp.next != null) {
      tmp = tmp.next;
      len++;
    }
    if (len == 1) {
      head.next = null;
      return head;
    }
    if (n == len) {
      return head.next;
    }
    for (int i = 1; i <= len - n && node.next != null; i++) {
      node = node.next;
    }
    if (node.next != null) {
      node.next = node.next.next;
    }
    return head;
  }

  public static void main(String[] args) {
    pro19 p = new pro19();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
//    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);
    ListNode listNode = p.removeNthFromEnd(head, 2);
    while (listNode != null) {
      System.out.println(listNode.value);
      listNode = listNode.next;
    }
  }
}
