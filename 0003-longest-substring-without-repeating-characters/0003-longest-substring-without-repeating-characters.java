class Solution {
    public int lengthOfLongestSubstring(String s) {
        int substring=s.length();
        int Lsub=0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for(int start =0, end =0; end<substring; end++){
            char currentChar = s.charAt(end);
            if(charIndexMap.containsKey(currentChar)){
                start=Math.max(charIndexMap.get(currentChar) + 1, start);
            }
            Lsub = Math.max(Lsub,end-start + 1);
            charIndexMap.put(currentChar, end);
        }
        return Lsub;
    }
}