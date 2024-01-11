package neetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfaPhoneNumber {


        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.isEmpty()) return res;
            StringBuilder sb = new StringBuilder();

            getCombo(digits, 0, sb, res);

            return res;
        }

        private void getCombo(String digits, int idx, StringBuilder sb, List<String> res) {
            if (idx == digits.length()) {
                res.add(sb.toString());
                return;
            }

            String letters = keypad[digits.charAt(idx) - '0'];
            for (char c : letters.toCharArray()) {
                sb.append(c);
                getCombo(digits, idx + 1, sb, res);
                sb.deleteCharAt(idx);
            }
        }


    public static void main(String[] args) {
        LetterCombinationsOfaPhoneNumber l = new LetterCombinationsOfaPhoneNumber();
        String case1 = "23";
        // "ad","ae","af","bd","be","bf","cd","ce","cf"
        // [ad,  bd,  cd,  ae,  be,  ce,  af,  bf,  cf]
        System.out.println(l.letterCombinations(case1));
    }
}
