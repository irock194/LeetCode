package leetcode;

//https://leetcode.com/problems/license-key-formatting/

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) 
    {        
        s = s.replaceAll("-", "");
        s = s.toUpperCase();
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i > -1; i--){
            if(count == k){
                answer.append("-");
                count = 0;
            }
            answer.append(s.charAt(i));
            count++;
        }
        
        return answer.reverse().toString();
        
    }
}
