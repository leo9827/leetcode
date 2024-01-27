package neetcode150.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75">649. Dota2 Senate</a>
 * Medium
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();

        int len = senate.length();
        for (int i = 0; i < len; i++) {
            if (senate.charAt(i) == 'R') {
                rad.add(i);
            } else {
                dir.add(i);
            }
        }
        // Use increasing n to keep track of position
        while (!rad.isEmpty() && !dir.isEmpty()) {
            // only winner stays in their queue
            if (rad.peek() < dir.peek()) {
                rad.add(len++);
            } else {
                dir.add(len++);
            }
            rad.poll();
            dir.poll();
        }
        return (rad.isEmpty()) ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();
        System.out.println(d.predictPartyVictory("RD") == "Radiant");
        System.out.println(d.predictPartyVictory("RDD") == "Dire");
    }

}