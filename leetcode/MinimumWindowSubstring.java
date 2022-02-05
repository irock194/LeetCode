package leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/submissions/
public class MinimumWindowSubstring {
	
	// O(m + n) where m is the length of s and n is the length of t
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return "";
        
        HashMap<Character, Integer> valuesToFind = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            int count = valuesToFind.getOrDefault(t.charAt(i), 0);
            valuesToFind.put(t.charAt(i), count + 1);
        }
        
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        int required = valuesToFind.size();
        int formed = 0;
        int[] answer = new int[3];
        answer[0] = -1;
        
        while(end < s.length()){
            char c = s.charAt(end);
            int count = letters.getOrDefault(c, 0);
            letters.put(c, count + 1);
            if(valuesToFind.containsKey(c) && valuesToFind.get(c).intValue() == letters.get(c).intValue()){
                formed++;
            }
            while(start <= end && formed == required){
                c = s.charAt(start);
                if(answer[0] == -1 || answer[0] > end - start + 1){
                    answer[0] = end - start + 1;
                    answer[1] = start;
                    answer[2] = end;
                }
                
                letters.put(c, letters.get(c) - 1);
                if(valuesToFind.containsKey(c) && valuesToFind.get(c).intValue() > letters.get(c).intValue()){
                    formed--;
                }
                start++;
            }
            end++;
        }

        return answer[0] == -1 ? "" : s.substring(answer[1], answer[2] + 1);
    }

}
