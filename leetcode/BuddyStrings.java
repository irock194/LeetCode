package leetcode;

//https://leetcode.com/problems/buddy-strings/

public class BuddyStrings {
	public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int[] count = new int[26];
        int numberOfDifferences = 0;
        int first = -1;
        int second = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                numberOfDifferences++;
                if(numberOfDifferences > 2){
                    return false;
                }
                if(first == -1){
                    first = i;
                }
                else{
                    second = i;
                }
            }
            count[s.charAt(i) - 'a']++;
        }
        if(numberOfDifferences == 1){
            return false;
        }
        if(numberOfDifferences == 2){
            return (s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
        }
        for(int values: count){
            if(values >= 2){
                return true;
            }
        }
        return false;
    }
}
