package leetcode;

//https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalindromicSubstring {

	//O(n^2)
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String currentLongest = "";
        int longest;
        for(int i = 0; i < s.length() - 1; i++){
            longest = longestPalindrome(s, i, i);
            if(longest > currentLongest.length()){
                currentLongest = s.substring(i - (longest / 2), i + (longest / 2) + 1);
            }
            longest = longestPalindrome(s, i, i + 1);
            if(longest > currentLongest.length()){
                longest--;
                currentLongest = s.substring(i - (longest / 2), i + (longest / 2) + 2);
            }
        }
        return currentLongest;
    }
    
    int longestPalindrome(String s, int i, int j){
        int longest = 1;
        if(i != j && s.charAt(i) == s.charAt(j)){
            longest = 2;
        }
        else if(i != j && s.charAt(i) != s.charAt(j)){
            return 0;
        }
        i--;
        j++;
        while(i > -1 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                longest += 2;
                i--;
                j++;
            }
            else{
                break;
            }
        }
        return longest;
    }

}
