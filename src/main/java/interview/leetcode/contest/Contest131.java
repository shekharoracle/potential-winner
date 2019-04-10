package interview.leetcode.contest;

import interview.common.modal.TreeNode;

import java.util.*;

public class Contest131 {


    static String removeOuterParentheses(String s){

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                stack.pop();
                if(!stack.isEmpty()){
                    sb.append(c);
                }
            }else{
                if(!stack.isEmpty()){
                    sb.append(c);
                }
                stack.push(c);
            }
        }
        return sb.toString();
    }

    static int sumRootToLeaf(TreeNode treeNode){
        int[] sum = new int[1];
        helper(treeNode, sum, 0);
        return sum[0];
    }

    private static void helper(TreeNode treeNode, int[] sum, int number){
        if(treeNode == null)return;
        number = number * 2 | treeNode.val;
        if(treeNode.left == null && treeNode.right == null){
            sum[0] += number;
            return;
        }

        helper(treeNode.left, sum, number);
        helper(treeNode.right, sum, number);
    }


    static List<Boolean> camelCaseMatching(String pattern, String[] queries){

        List<Boolean> result = new ArrayList<>();
        parent : for(int index = 0; index < queries.length; index++){
            System.out.println(String.format("Pattern : %s, Query : %s", pattern, queries[index]));
            int start = 0;
            for(char c : queries[index].toCharArray()){
                if(start < pattern.length() && c == pattern.charAt(start)){
                    start++;
                }else{
                    if(!Character.isLowerCase(c)){
                        result.add(false);
                        continue parent;
                    }
                }
            }
            if(start < pattern.length()){
                result.add(false);
            }else{
                result.add(true);
            }

        }

        System.out.println("Result : "+result);

        return result;
    }

    static class Clip{
        int start;
        int end;

        Clip(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", start, end);
        }
    }

    /**
     *
     * @param clips
     * @param T
     * @return
     */
    static int videoStitching(int[][] clips, int T) {

        Stack<Clip> result = new Stack<>();

        List<Clip> clipsList = new ArrayList<>();
        for(int[] clip : clips){
            clipsList.add(new Clip(clip[0], clip[1]));
        }

        Collections.sort(clipsList, new Comparator<Clip>() {
            @Override
            public int compare(Clip c1, Clip c2) {
                if(c1.start == c2.start){
                    return Integer.compare(c1.end, c2.end);
                }
                return Integer.compare(c1.start, c2.start);
            }
        });

        System.out.println(""+clipsList);
        int maxLength = Integer.MIN_VALUE;

        for(Clip clip : clipsList){
            if(clip.end > maxLength){
                maxLength = clip.end;
                if(!result.isEmpty() && result.peek().start == clip.start){
                    result.peek().end = clip.end;
                }else{
                    result.push(clip);
                }
            }
        }

        System.out.println("  "+result+", max Length "+maxLength);


        return -1;
    }


    public static void main(String[] args){
        System.out.println("Start contest 131....");

        int[][] clips2 = {
                {0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}
        };

        int[][] clips = {
                        {0,2},
                        {4,6},
                        {8,10},
                        {1,9},
                        {1,5},
                        {5,9}
        };
        videoStitching(clips2, 9);


//        String result = removeOuterParentheses("(()())(())");
//        System.out.println("Result : "+result);

//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String pattern = "FoBa";
//        camelCaseMatching(pattern, queries);

    }
}
