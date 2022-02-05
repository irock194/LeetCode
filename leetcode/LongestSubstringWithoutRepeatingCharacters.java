package leetcode;

import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
	
	//sliding Window O(n)
    public int lengthOfLongestSubstring(String s) {
        
        int answer = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> letters = new HashSet<Character>();
        
       while(end < s.length()){
           if(!letters.contains(s.charAt(end))){
               letters.add(s.charAt(end));
               end++;
               answer = Math.max(answer, letters.size());
           }
           else{
               letters.remove(s.charAt(start));
               start++;
           }
       }
        
        answer = Math.max(answer, letters.size());
        return answer;
    }

	/***O(n^2) 
    public int lengthOfLongestSubstring(String s) {
        
        int answer = 0;
        List<Character> letters = new ArrayList<Character>();
        
        for(int i = 0; i < s.length(); i++){
            if(letters.contains(s.charAt(i))){
                answer = Math.max(answer, letters.size());
                letters = letters.subList(letters.indexOf(s.charAt(i)) + 1, letters.size());
                letters.add(s.charAt(i));
            }
            else{
                letters.add(s.charAt(i));
            }
            
        }
        
        answer = Math.max(answer, letters.size());
        return answer;
    }
    ***/
}
