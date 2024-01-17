package neetcode150.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange change = new CoinChange();
        System.out.println(change.coinChange(new int[]{2, 5}, 11)); // 4: 5222/2522
//        System.out.println(change.coinChange(new int[]{1,2,5}, 100)); // 4: 5222/2522
        System.out.println(change.coinChangeTabulation(new int[]{2,5}, 11)); // 4: 5222/2522
        System.out.println(change.coinChangeTabulation(new int[]{2}, 3)); // 4: 5222/2522
        System.out.println(change.coinChangeTabulation(new int[]{1,2147483647}, 2)); // 4: 5222/2522
        System.out.println(change.coinChangeTabulation(new int[]{456,117,5,145}, 1459)); // 4: 5222/2522
    }

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new HashMap<>(100));
    }

    public int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return  0;
        if (amount <  0) return -1;

        int shortest = -1;
        for (int coin : coins) {
            int remain = amount - coin;
            int ret = coinChange(coins, remain);
            if (ret != -1) {
                ret+=1;
                if (shortest == -1 || shortest>ret) {
                    shortest = ret;
                }
            }
        }
        memo.put(amount, shortest);
        return shortest;
    }

    public int coinChangeTabulation(int[] coins, int amount){
        /*
        case: [2,3,5] 8 -> [2,2,2,2], [2,3,3], [3,5]
               0 1 2 3 4 5 6 7 8
              [0,0,0,0,0,0,0,0,0]
i=0,递增1次0=>2[0,0,1,0,0,0,0,0,0]
i=0,递增1次0=>3[0,0,1,1,0,1,0,0,0]
i=0,递增1次0=>5[0,0,1,1,0,1,0,0,0]
i=1,无法到达不变[0,0,1,1,0,1,0,0,0]
i=2,递增1次2=>4[0,0,1,1,2,1,0,0,0]
i=2,递增1次2=>5[0,0,1,1,2,1,0,0,0] [2]=1,1+1=2=>[5],但是[5]已经有1了,所以保留1
i=2,递增1次2=>7[0,0,1,1,2,1,0,1,0]
i=3,递增1次3=>5[0,0,1,1,2,1,0,1,0] [3]=1,1+1=2=>[5],但是[5]已经有1了,所以保留1
i=3,递增1次3=>6[0,0,1,1,2,1,2,1,0] [3]=1,1+1=2=>[6],[6]=0, [6]=2
i=3,递增1次3=>8[0,0,1,1,2,1,2,1,0] [3]=1,1+1=2=>[8],[8]=0, [8]=2

         */
        if (amount == 0) return  0;
        if (amount <  0) return -1;
        int[] table = new int[amount+1];
        for (int i = 0; i < amount; i++) {
            if (i != 0 && table[i] == 0) continue;
            for (int coin : coins) {
                int change = table[i] + 1;
                if (i + coin > 0 && i + coin <= amount && table[i + coin] == 0) table[i + coin] = change;
                if (i + coin > 0 && i + coin <= amount && table[i + coin] > change) table[i + coin] = change;
            }
        }
        return table[amount] > 0 ? table[amount] : -1;
    }

    public int coinChange12ms(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] table = new int[amount+1];
        Arrays.fill(table,Integer.MAX_VALUE);
        table[amount] = 0;

        //Time complexity O(coins * amount)
        for (int i = amount; i>= 0; i--){

            //if this index is unreachable by any coin
            if (table[i] == Integer.MAX_VALUE)
                continue;

            for (int coin : coins){
                if (i - coin >= 0){
                    table[i-coin] = Math.min(table[i-coin],1 + table[i]);
                }
            }
        }

        return table[0] == Integer.MAX_VALUE ? -1: table[0];

    }
}
