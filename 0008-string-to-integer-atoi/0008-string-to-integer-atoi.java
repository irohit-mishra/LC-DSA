class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        boolean neg = false;
        long ans = 0;
        int i = 0;
        
        if (s.charAt(0) == '-') {
            neg = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int dig = ch - '0';
                ans = ans * 10 + dig;

                if (ans > Integer.MAX_VALUE) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }
}
