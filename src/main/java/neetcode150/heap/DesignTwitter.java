package neetcode150.heap;

import java.util.*;

/**
 * 355. Design Twitter
 * <a href="https://leetcode.com/problems/design-twitter/description/">...</a>
 */
public class DesignTwitter {
    class Twitter {
        HashMap<Integer, List<int[]>> tweetMap;
        HashMap<Integer, HashSet<Integer>> userMap;
        int count;

        public Twitter() {
            tweetMap = new HashMap<>();
            userMap = new HashMap<>();
            count = 0;
        }

        public void postTweet(int userId, int tweetId) {
            if (!tweetMap.containsKey(userId)) {
                tweetMap.put(userId, new ArrayList<>());
            }
            tweetMap.get(userId).add(new int[]{count, tweetId});
            count++;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            //Max queue
            PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> Integer.compare(q[0], p[0])
            );
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new HashSet<>());
            }
            userMap.get(userId).add(userId);

            for (Integer followeeId : userMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    int index = tweetMap.get(followeeId).size() - 1;
                    int[] tweet = tweetMap.get(followeeId).get(index);
                    pq.add(new int[]{tweet[0], tweet[1], followeeId, index - 1});
                }

            }

            while (pq.size() > 0 && res.size() < 10) {
                int[] data = pq.poll();
                res.add(data[1]);
                int index = data[3];
                if (index >= 0) {
                    int[] tweet = tweetMap.get(data[2]).get(index);
                    pq.add(new int[]{tweet[0], tweet[1], data[2], index - 1});
                }

            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            userMap.computeIfAbsent(followerId, var -> new HashSet<>()).add(followeeId);
            // if(!userMap.containsKey(followerId)){
            //     userMap.put(followerId, new HashSet<Integer>());
            // }
            // userMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.computeIfAbsent(followerId, var -> new HashSet<>()).contains(followeeId)) {
                userMap.get(followerId).remove(followeeId);
            }
//         if(!userMap.containsKey(followerId)){
//             userMap.put(followerId, new HashSet<Integer>());
//         }

//         if(userMap.get(followerId).contains(followeeId))
//             userMap.get(followerId).remove(followeeId);
        }
    }


}

