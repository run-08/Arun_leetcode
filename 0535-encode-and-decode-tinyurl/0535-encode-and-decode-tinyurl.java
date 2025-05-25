public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyURL = "";
        int n = longUrl.length();
        int i = 0;
        for(;i < n-1;i++) {
            if(longUrl.charAt(i) >= '0' && longUrl.charAt(i) <= '9') {
                tinyURL += "$"+longUrl.charAt(i); 
                continue;
            }
            if(longUrl.charAt(i) == longUrl.charAt(i+1)) {
                int cnt = 1;
                while( i+1 < n && longUrl.charAt(i) == longUrl.charAt(i+1)){
                     cnt++;
                     i++;
                }
                tinyURL += String.valueOf(cnt)+longUrl.charAt(i);
            }
            else tinyURL += longUrl.charAt(i);
        }
        if(i == n-1){
            if(longUrl.charAt(n-1) >= '0' && longUrl.charAt(n-1) <= '9') tinyURL += "$";
             tinyURL += longUrl.charAt(n-1);
        }
        return tinyURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // System.out.print(shortUrl);
        String longUrl = "";
        int n = shortUrl.length();
        for(int i = 0;i < n;i++) {
            char c = shortUrl.charAt(i);
            if(c == '$') {
                i++;
                longUrl += shortUrl.charAt(i);
                continue;
            }
            if( c >= '0' && c <= '9'){
                String num = "";
                while(shortUrl.charAt(i) >= '0' && shortUrl.charAt(i) <= '9') {
                    num += shortUrl.charAt(i);
                    i++;
                }
                char ch = shortUrl.charAt(i);
                int repeated = Integer.parseInt(num);
                for(int j = 0;j < repeated;j++) longUrl += ch;
            }
            else longUrl += c;
        }
        return longUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));