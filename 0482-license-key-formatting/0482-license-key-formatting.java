class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder reformattedLicense = new StringBuilder();
        int n = s.length();
        StringBuilder groupForms = new StringBuilder() ; int groupMemberCount = 0;
        for (n = n-1;n >= 0;n--) {
            char c = s.charAt(n);
            if ( c == '-' ) continue;
            groupMemberCount++;
            if ( c >= 97) c = (char)(c-32);
            groupForms.append(c);
            if( groupMemberCount == k ) {
                groupForms.append("-");
                reformattedLicense.append(groupForms);
                groupMemberCount = 0;
                groupForms = new StringBuilder();
            }
        }
        if( groupForms.length() > 0 ) reformattedLicense.append(groupForms);
        reformattedLicense = reformattedLicense.reverse();
        if( reformattedLicense.length() > 0 && reformattedLicense.charAt(0) == '-') reformattedLicense.delete(0,1);
        return reformattedLicense.toString();
    }
}