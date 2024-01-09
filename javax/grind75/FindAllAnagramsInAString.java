package grind75;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(s.length()-1);
        if (s.length() < p.length()) return res;
        Map<Character, Integer> table =  new HashMap<>();
        for (char c : p.toCharArray()) {
            table.put(c, table.getOrDefault(c, 0)+1);
        }
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                // maybe answer
                // way 1, substring and sort and equals compare
                // way 2
                int l=0;
                while (l<p.length() && table.containsKey(s.charAt(i+l))) {
                    l++;
                }
                if (l==p.length()-1) {
                    res.add(i);
                }
            }
        }

        return res;        
    }
}
