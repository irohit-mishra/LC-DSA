class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int [] dp = new int[n + 1];
        dp[0] = 1; //there is one way to decode an empty string
        dp[1] = s.charAt(0) != '0'? 1 : 0; //there is one way to decode a non 0 first character

        for (int i = 2; i <= n; i++){
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            //check if single digit decode is valid
            if (oneDigit >= 1 && oneDigit <= 9){
                dp[i] += dp[i - 1];
            }

            //check if two digit is valid
            if (twoDigits >=10 && twoDigits <=26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}