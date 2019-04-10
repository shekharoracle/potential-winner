package interview.leetcode.microsoft;

public class Interview1 {

    static class ListNode{

        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int aLength = getLength(headA);
        int bLength = getLength(headB);

        if(aLength > bLength){
            return getIntersectionNodeHelper(headB, headA, aLength-bLength);
        }
        return getIntersectionNodeHelper(headA, headB, bLength-aLength);
    }

    private ListNode getIntersectionNodeHelper(ListNode headA, ListNode headB, int diff){

        while (diff > 0){
            headB = headB.next;
            diff--;
        }

        while (headA != null && headB != null){
            if(headA.val == headB.val)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode node){
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     *
     A = -2
     B = -2
     C = 2
     D = 2
     E = 3
     F = 3
     G = 4
     H = 4
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return Math.abs(C- A) * Math.abs(D - B) + Math.abs(G- E) * Math.abs(H - F) - getCommonArea(A, B, C, D, E, F, G, H);
    }

    private int getCommonArea(int A, int B, int C, int D, int E, int F, int G, int H){
        if(A > G || C < E || B > H || F > D)return 0;

        int x = Math.min(C, G) - Math.max(A, E);
        int y = Math.min(D, H) - Math.max(B, F);

        int common = x * y;
        return common;
    }





    public static void main(String[] args){

    }
}
