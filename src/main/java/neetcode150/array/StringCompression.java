package neetcode150.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/string-compression/description">443. String Compression</a>
 */
public class StringCompression {
    /**
     * 1.考虑两 pointers,index 指向原字符串,indexAns 指向压缩后的答案放置位置。
     * <p>
     * 2.用 while 循环迭代原字符串,curr 记录当前字符,count 记录字符出现次数。
     * <p>
     * 3.内层 while 循环统计当前字符连续出现的次数 count。
     * <p>
     * 4.将当前字符写入答案 chars[indexAns++]。
     * <p>
     * 5.如果次数不为 1,将次数转换成字符串,逐个字符写入答案。
     * <p>
     * 6.两 pointers 同时向后移,开始统计下一个字符。
     */
    public int compress(char[] chars) {
        int indexAns = 0, index = 0; // 使用两 pointers 分别指原字符串和答案,可在原地修改答案
        while (index < chars.length) {
            char curr = chars[index];
            int count = 0;
            while (index < chars.length &&
                    chars[index] == curr) {
                index++;
                count++;
            }
            chars[indexAns++] = curr;
            if (count != 1) { // 统计当前字符次数,如果>1就需要写入次数字符串,否则直接跳过
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }

    static class Solution {

        public int compress(char[] chars) {
            int lastIndex = 1;
            char lastChar = chars[0];
            int count = 1;

            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == lastChar) {
                    count++;
                } else {
                    if (count == 1) {
                        lastChar = chars[i];
                        chars[lastIndex] = lastChar;
                    } else {
                        lastIndex = getCount(chars, lastIndex, count);
                        lastChar = chars[i];
                        chars[lastIndex] = lastChar;
                    }
                    lastIndex++;
                    count = 1;
                }
            }
            if (count > 1) {
                lastIndex = getCount(chars, lastIndex, count);
                count = 1;
            }
            return lastIndex;
        }

        public int getCount(char[] chars, int lastIndex, int count) {
            for (char ch : reverse(count)) {
                chars[lastIndex] = ch;
                count /= 10;
                lastIndex++;
            }
            return lastIndex;
        }

        public List<Character> reverse(int num) {
            List<Character> res = new ArrayList<Character>();
            while (num > 0) {
                char ch = (char) (num % 10 + '0');
                res.add(0, ch);
                num /= 10;
            }
            return res;
        }
    }
}

