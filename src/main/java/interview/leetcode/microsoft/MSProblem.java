package interview.leetcode.microsoft;

import interview.common.modal.TrieNode;

import java.util.Map;

public class MSProblem {

    static private TrieNode root = new TrieNode('#');

    static void insertString(String s){
        Map<Character, TrieNode> cNodeMap = root.trieNodeMap;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!cNodeMap.containsKey(c)){
                cNodeMap.put(c, new TrieNode(c));
            }

            if(i == s.length()-1){
                cNodeMap.get(c).s = s;
            }
            cNodeMap = cNodeMap.get(c).trieNodeMap;
        }
    }

    static TrieNode getNode(String prefix){
        TrieNode t = null;
        Map<Character, TrieNode> cNodeMap = root.trieNodeMap;
        for(int i=0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cNodeMap.containsKey(c))break;
            if(i == prefix.length()-1){
                t = cNodeMap.get(c);
            }
            cNodeMap = cNodeMap.get(c).trieNodeMap;
        }

        return t;
    }

    /**
     *
     * @param s
     * @return
     */
    static boolean hasString(String s){

        TrieNode trieNode = getNode(s);
        if(trieNode == null || trieNode.s == null)return false;
        return true;
    }





    /**
     *
     * @param nums
     * @return
     */
    static int singleNumber(int[] nums){
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }

        System.out.println("Number that exist only once is : "+result);
        return result;
    }

    public static void main(String[] args){

        insertString("shekhar");
        insertString("vijeta");
        insertString("shilpi");

        System.out.println(hasString("shekhar"));
        System.out.println(hasString("shekha"));


//        int[] nums = {4, 1, 2, 1, 2};
//        System.out.println("  "+singleNumber(nums));

    }
}
