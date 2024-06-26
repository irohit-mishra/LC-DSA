class Solution {
    public int divide(int dividend, int divisor) {
        if (Integer.MIN_VALUE == dividend && divisor == -1)
            return Integer.MAX_VALUE;

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;

        while (a - b >= 0) {
            int x = 0;
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }

        // Apply sign
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -res;
        } else {
            return res;
        }
    }
}
