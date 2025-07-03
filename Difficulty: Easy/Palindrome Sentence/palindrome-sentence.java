class Solution {

    public boolean sentencePalindrome(String s) {
        // code here
        // System.out.println(ispalind(s) ? "True" : "False");
        if(ispalind(s)) return true;
        return false;
    }
    static boolean ispalind(String s){
        StringBuilder s1 = new StringBuilder();
        for(Character ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                s1.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder rev = new StringBuilder(s1.toString());
        rev.reverse();
        return s1.toString().equals(rev.toString());
    }
}