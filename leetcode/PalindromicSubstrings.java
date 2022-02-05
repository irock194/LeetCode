package leetcode;

//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
	//O(n * log n)
    public int countSubstrings(String s) {
        
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            total += countPalindromes(s, i, i);
            total += countPalindromes(s, i, i + 1);
        }
        return total;
    }
    
    int countPalindromes(String s, int start, int end){
        int numberOfPalindromes = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            numberOfPalindromes++;
            start--;
            end++;
        }
        return numberOfPalindromes;
    }

    /***O(n^2 log n)
     *     public int countSubstrings(String s) {
        
        int total = 0;
        for(int i = 0; i < s.length() - 1; i++){
            for(int j = i + 1; j < s.length(); j++){
                if(isPalindrome(s, i, j)){
                    total++;
                }
            }
        }
        total += s.length();
        return total;
    }
    
    boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
     */
}
