class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        // Step 1: Reverse the string
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        // Step 2: Create the modified string with a separator
        String combined = s + "#" + reversed;

        // Step 3: Compute the LSP (Longest Prefix Suffix) array for the combined string
        int[] lsp = new int[combined.length()];
        int j = 0;  // Length of the previous longest prefix suffix

        // Start computing LSP from index 1
        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                // Mismatch after j matches, fallback to previous match
                j = lsp[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                // Found matching character
                j++;
            }
            lsp[i] = j;
        }

        // Step 4: Using the LSP value, find the part that needs to be prepended to make the palindrome
        int suffixLengthToPrepend = s.length() - lsp[combined.length() - 1];

        // Step 5: Prepend the reverse of the suffix to the original string
        return reversed.substring(0, suffixLengthToPrepend) + s;
    }
}
