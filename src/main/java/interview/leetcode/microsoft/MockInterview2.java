package interview.leetcode.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MockInterview2 {


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }


    static ListNode createListNode(List<Integer> list){
        ListNode dummyNode  = new ListNode(-1);
        ListNode node = dummyNode;

        for(Integer i : list){
            node.next = new ListNode(i);
            node = node.next;
        }
        return dummyNode.next;
    }

    static void printLinkedList(ListNode listNode){
        System.out.println("===========");
        while (listNode != null){
            System.out.print("  -->"+listNode.val);
            listNode = listNode.next;
        }

        System.out.println("=================");

    }

    public static ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null)return head;

        ListNode dummyNode = new ListNode(-1);
        ListNode node = head;
        ListNode prev = dummyNode;

        while (node != null && node.next != null){
            ListNode nextNode = node.next.next;
            node.next.next = node;
            prev.next = node.next;
            node.next = null;

            prev = node;
            node = nextNode;
        }
        if(node != null){
            prev.next = node;
        }

        return dummyNode.next;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int N = chars.length;

        //reverse(chars, 0, N-1);

        while (end < N){
            if(chars[end] == ' '){
                reverse(chars, start, end -1);
                while (end < N && chars[end] == ' '){
                    end++;
                }
                start = end;
            }else{
                end++;
            }
        }

        if(start < end){
            reverse(chars, start, end-1);
        }


        String result = new String(chars);
        System.out.println(" "+result);

        return result;
    }


    /**
     *
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private static void reverse(char[] chars, int start, int end){
        while (start < end){
            swap(chars, start, end);
            start++;
            end--;
        }
    }


    private static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     *
     * @param board
     * @param words
     * @return
     */
    public static List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();

        for(String word : words){
            if(wordExist(board, visited, word)){
                result.add(word);
            }
        }

        System.out.println("Result : "+result);
        return result;

    }

    private static boolean wordExist(char[][] board, boolean[][] visited, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(isWordExist(board, i, j, 0, visited, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isWordExist(char[][] board, int i, int j, int index, boolean[][] visited, String word) {
        if(index > word.length())return false;
        if(index == word.length())return true;

        int m = board.length;
        int n = board[0].length;

        boolean result = false;

        if(i >= 0 && j >= 0 && i < m && j < n && !visited[i][j] && word.charAt(index) == board[i][j]){
            visited[i][j]= true;
            result = isWordExist(board, i+1, j, index + 1, visited, word)
                    || isWordExist(board, i-1, j, index + 1, visited, word)
                    || isWordExist(board, i, j+1, index + 1, visited, word)
                    || isWordExist(board, i, j-1, index + 1, visited, word);
            visited[i][j]= false;
        }


        return result;
    }


    public static void main(String[] args){

        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        findWords(board, words);


//        String s = "Let's take LeetCode contest";
//        reverseWords(s);

//        ListNode listNode = createListNode(Arrays.asList(2, 1, 3));
//        printLinkedList(listNode);
//
//        ListNode result = swapPairs(listNode);
//        printLinkedList(result);
    }
}
