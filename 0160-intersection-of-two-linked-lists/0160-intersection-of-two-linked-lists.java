/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     //calculate lengths of both list
     int lenA = getLength(headA);
     int lenB = getLength(headB);

     //align the start of both lists
     while(lenA > lenB){
        headA = headA.next;
        lenA--;
     }   
     while (lenB > lenA){
        headB = headB.next;
        lenB--;
     }

     //traverse both lists together
     while (headA != null && headB != null){
        if (headA == headB){
            return headA; //intersection code found
        }
        headA = headA.next;
        headB = headB.next;
     }
     return null; //no intersection
    }

    //helper function to calculate the length of a linked list
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}