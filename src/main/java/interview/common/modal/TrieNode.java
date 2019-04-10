package interview.common.modal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TrieNode {

    public Character c;
    public String s;
    public Map<Character, TrieNode> trieNodeMap = new HashMap<>();

    public TrieNode(Character c){
        this.c = c;
    }

}
