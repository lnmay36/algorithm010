//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode new_t , temp;
        if (t1!=null||t2!=null){
            new_t = new ListNode();
            if (t1!=null&&t2==null) {
                new_t.val = t1.val;
                t1 = t1.next;
            }else if(t2!=null&&t1==null){
                new_t.val = t2.val;
                t2 = t2.next;
            }else {
                if (t1.val < t2.val) {
                    new_t.val = t1.val;
                    t1 = t1.next;
                }else {
                    new_t.val = t2.val;
                    t2 = t2.next;
                }
            }
            temp = new_t;

            while (t1!=null&&t2!=null) {
                ListNode temp1 = new ListNode();
                temp.next = temp1;
                if (t1.val < t2.val) {
                    temp1.val = t1.val;
                    t1 = t1.next;
                }else {
                    temp1.val = t2.val;
                    t2 = t2.next;
                }
                temp = temp.next;
            }
            while(t1!=null){
                ListNode temp1 = new ListNode();
                temp.next = temp1;
                temp1.val = t1.val;
                t1=t1.next;
                temp = temp.next;
            }
            while(t2!=null){
                ListNode temp1 = new ListNode();
                temp.next = temp1;
                temp1.val = t2.val;
                t2=t2.next;
                temp = temp.next;
            }
        }else{
            return null;
        }
        return new_t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
