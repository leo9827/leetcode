package grind75;

public class ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        // tow pointer
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        for(int i = 0, j = s.length()-1;i<j;i++,j--){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

}
