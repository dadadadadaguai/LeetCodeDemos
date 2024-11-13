package com.leetcode.medium;

/** 24. 两两交换链表中的节点 */
public class pro24 {
  public ListNode swapPairs(ListNode head) {
    ListNode node = new ListNode(0,head);
    ListNode tmp= node;
    while (tmp.next!=null && tmp.next.next != null) {
      ListNode pre=tmp.next;
      ListNode cur=tmp.next.next;
      tmp.next=cur;
      pre.next = cur.next;
      cur.next=pre;
      tmp = pre;
    }
    return node.next;
  }

  public static void run() {
    pro24 p = new pro24();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    //空节点
    node1.next = null;
    p.swapPairs(node1);
  }

  public static void main(String[] args) {
    run();
  }
}
