public class ReverseLinkedListII {
    /**
     * For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     return 1->4->3->2->5->NULL.
     1->2->3->4->5
     p  c  t
     time : O(n);
     space : O(1);
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //建立虚拟节点，指向头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //建立两个指针，分别指向虚拟节点和头节点
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        //遍历指针到需要反转的部分节点的起点
        for (int i = 1; i < m; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        //翻转节点，反转的长度用n - m控制
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
