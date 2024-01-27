package neetcode150.stack;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
 * 2390. Removing Stars From a String <p/>
 * Medium <p/>
 */
public class RemovingStarsFromAString {

    public String removeStars(String s) {
        StringBuilder c = new StringBuilder();
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) == '*') {
                c.deleteCharAt(c.length()-1);
            } else {
                c.append(s.charAt(i));
            }
        }
        return c.toString();
    }
    public static void main(String[] args) {
        
    }
}