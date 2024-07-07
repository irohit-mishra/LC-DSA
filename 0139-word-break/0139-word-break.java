class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      //convert wordDict to  hashset for the false look-up
      Set<String> wordSet = new HashSet<>(wordDict);

      //dp array to store the segmentation status
      boolean[] dp = new boolean[s.length() + 1];

      //base case 
      dp[0] = true;

      //fill the DP array
      for (int i = 1; i <= s.length(); i++) {
        for (int j=0; j < i; j++){
            if(dp[j] && wordSet.contains(s.substring(j, i))){
                dp[i]= true;
                break;
            }
        }
      }  
      //the result is whether the entire string s can be segmented
      return dp[s.length()]; 
    }
}