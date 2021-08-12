public class Anagrams {
    public static void main(String[] args) {
        System.out.println();

        String word = "cat";
    

    }

    /* Program to Anagram a word with n distinct letters: 
        1. Anagram the rightmost n-1 letters
        2. Rotate all n letters (shift all letters to the left, first index move to end)
        3. Repeat these steps n times 

        ex: word: CAT 
        function(CAT)      -->  function(AT)      --> function(T)
        first letter: C         first letter: A       return T (cannot rotate one letter)
                                                      print CAT
                             rotate: function(TA) --> function (A)
                                first letter: T       return A
                                                      print CTA
        rotate: function (ATC) --> function (TC) --> function (C)        
    */ 

    public static String doAnagram(String word) {
        if (word.length() == 1) { //  for java ONLY, string is a class, so need to do .length(). For array though can just do .length
            return word;
        } else {
            System.out.println(doAnagram(word.substring(1)));
            
            return word;
        }
    }

    public static String rotateString(String word) {
        char temp = word.charAt(0);
        
    }
}
