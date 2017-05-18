/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.pkg1;

/**
 *
 * @author danielochoa
 */
public class Recursion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    // Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
    public int count11(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.substring(0, 2).equals("11")) {
            return 1 + count11(str.substring(2));
        }
        return count11(str.substring(1));
    }

    //Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.   
    public boolean strCopies(String str, String sub, int n) {
        if (n == 0) //this will always be executed first than the condition of the next false statement
        {
            return true;
        }
        if (str.length() < sub.length()) {
            return false;
        }
        if (str.substring(0, sub.length()).equals(sub)) {  //its not sub.length()-1 here because for the substring(a,b) method the ending index is exclusive.
            return strCopies(str.substring(1), sub, n - 1);  //note that its not "str.substring(sub.length())" here because sub can overlap for example: strCopies("iiijjj", "ii", 2) should be true but if you write str.substring(sub.length()) it will give you false.
        }
        return strCopies(str.substring(1), sub, n);
    }

//Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char.
//So "yyzzza" yields "yza".
    public String stringClean(String str) {
        if (str.length() == 1) {
            return "" + str.charAt(0);
        }

        if (str.charAt(0) == (str.charAt(1))) {
            str = str.substring(1);
            return stringClean(str);
        } else {
            return str.charAt(0) + stringClean(str.substring(1));
        }

    }

    //Given a string, compute recursively a new string where all the 'x' chars have been removed.
    public String noX(String str) {

        if (str.equals("")) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return noX(str.substring(1));
        } else {
            return str.charAt(0) + noX(str.substring(1));
        }

    }
}
