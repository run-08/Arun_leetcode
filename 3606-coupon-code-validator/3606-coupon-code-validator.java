class Solution {
    public List<String> validateCoupons(String[] code, String[] buisnessLine, boolean[] isActive) {
        int n=code.length;
        List<Coupon> coupons = IntStream
               .range(0,n)
               .mapToObj(i -> new Coupon(code[i],buisnessLine[i],isActive[i]))
               .collect(Collectors.toList());
        coupons = coupons
              .stream()
              .filter(coupon -> validateCode(coupon.code))
              .filter(coupon -> coupon.isActive)
              .filter(coupon -> coupon.buisnessLine.equals("electronics") || coupon.buisnessLine.equals("grocery") || coupon.buisnessLine.equals("pharmacy") || coupon.buisnessLine.equals("restaurant"))
              .collect(Collectors.toList());
        // coupons.forEach(coupon -> System.out.print(coupon.toString()));
        Collections.sort(coupons,(a,b)->{
            if(!(a.buisnessLine.equals(b.buisnessLine))) {
                if(a.buisnessLine.charAt(0)<b.buisnessLine.charAt(0)) return -1;
                return 1;
            }
            return a.code.compareTo(b.code);
        });
        List<String> result = coupons
                                .stream()
                                .map(coupon -> coupon.code)
                                .collect(Collectors.toList());
        // Collections.sort(result);
        return result;
    }
    private boolean validateCode(String code){
        if(code.length()==0) return false;
        for(char c : code.toCharArray()){
           if((c >='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9') || c == '_') continue;
           return false;
        }
        return true;
    } 

    // private int getBuisnessLinePriority(String BuisnessLine){
    //     switch(BuisnessLine){
    //         case "electronics": return 1;
    //         case "grocery": return 2;
    //         case "pharmacy": return 3;
    //         default: return 4;
    //     }
    // }
}
class Coupon{
    String code;
    String buisnessLine;
    boolean isActive;
    Coupon(String code,String buisnessLine,boolean isActive){
        this.code = code;
        this.buisnessLine = buisnessLine;
        this.isActive = isActive;
    }
    @Override
    public String toString(){
        return "[ "+(code)+", "+(buisnessLine)+", "+(isActive)+" ]";
    }
}