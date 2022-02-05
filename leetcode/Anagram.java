package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/
public class Anagram {
	
	//O(3n) also works for any value besides letters
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> storageOne = new HashMap<Character, Integer>();
        HashMap<Character, Integer> storageTwo = new HashMap<Character, Integer>();
        

        for(int i = 0; i < s.length(); i++)
        {
            if(storageOne.containsKey(s.charAt(i)))
                storageOne.replace(s.charAt(i), storageOne.get(s.charAt(i)) + 1);
            else
                storageOne.put(s.charAt(i), 1);          
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            if(storageTwo.containsKey(t.charAt(i)))
                storageTwo.replace(t.charAt(i), storageTwo.get(t.charAt(i)) + 1);
            else
                storageTwo.put(t.charAt(i), 1);            
        }
    
        for (Map.Entry entry : storageOne.entrySet()) 
        {
            if(!storageTwo.containsKey(entry.getKey()))
            {
                System.out.println("Not exact Key");
                return false;
            }
            if(!entry.getValue().equals(storageTwo.get(entry.getKey())))
            {
                return false;
            }

        }
        
        return true;
    }
    
    /****Optimal Solution for only alphabet letters O(2n) 
     *     public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        int[] values = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            values[s.charAt(i) - 'a']++;
            values[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < values.length; i++)
        {
            if(values[i] != 0)
                return false;
        }
        
        return true;

    }
     */

}
