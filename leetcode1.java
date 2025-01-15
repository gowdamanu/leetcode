import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the substring, move the left pointer
            if (charMap.containsKey(s.charAt(right)) && charMap.get(s.charAt(right)) >= left) {
                left = charMap.get(s.charAt(right)) + 1;
            }

            // Update the last seen index of the current character
            charMap.put(s.charAt(right), right);
            
            // Calculate the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }
                return maxLength;}
        public static void main(String[] args) {
            Solution solution = new Solution();
            String s = "abcabcbb";
            System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s));
        }
    }