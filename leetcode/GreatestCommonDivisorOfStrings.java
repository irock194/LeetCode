package leetcode;

//https://leetcode.com/problems/greatest-common-divisor-of-strings/

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        String divisor = "";
        int i = 0;
        while(i < str1.length() && i < str2.length()){
            if(str1.charAt(i) == str2.charAt(i)){
                divisor += str1.charAt(i);
            }
            else{
                break;
            }
            i++;
        }
        
        while(divisor.length() != 0){
            if(isDivisable(str1, divisor) && isDivisable(str2, divisor)){
                return divisor;
            }
            else{
                divisor = divisor.substring(0, divisor.length() - 1);
            }
        }
        
        return divisor;
        
    }
    
    boolean isDivisable(String str, String divisor){
        int divCount = 0;
        
        for(int i = 0; i < str.length(); i++){
            
            if(str.charAt(i) == divisor.charAt(divCount)){
                divCount++;
                if(divCount == divisor.length()){
                    divCount = 0;
                }
            }
            else{
                return false;
            }
        }
        if(divCount != 0){
            return false;
        }
        return true;
    }
}
