package blind75;

public class Numberof1Bits {

    public static void main(String[] args) {
        Numberof1Bits bi = new Numberof1Bits();
        System.out.println(bi.hammingWeight(00000000000000000000000000001011));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n= n>>>1;
        }
        return count;
    }
}
