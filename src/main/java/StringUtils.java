
public class StringUtils {

    public static boolean isPalindromeIgnoreWhitespaces(String string){

        if(null == string){
            return false;
        }
        if("" == string.trim()){
            return true;
        }

        int length = string.length();
        for(int i = 0, j = length - 1; i < j; i++, j--){
            char start = string.charAt(i);
            while(!(start > 64 && start < 91) && !(start > 96 && start < 123)){
                i++;
                if(i > j){
                    return false;
                }

                start = string.charAt(i);
            }

            char end = string.charAt(j);
            while(!(end > 64 && end < 91) && !(end > 96 && end < 123)){
                j--;
                if(i > j){
                    return false;
                }
                end = string.charAt(j);
            }

            if(start != end && start - 32 != end && start + 32 != end){
                return false;
            }
        }

        return true;
    }

    /**
     * https://leetcode.com/problems/reverse-string/
     *
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
     * extra memory. You may assume all the characters consist of printable ascii characters.
     *
     * @param str
     * @return reversed string
     */
    public static String reverse(String str){
        if (null == str || "".equals(str.trim()))
            return str;

        char[] arr = str.toCharArray();

        for(int i = 0, j = str.length() - 1; i < arr.length / 2; i++, j--){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return String.copyValueOf(arr);
    }

    public static void reverseRecursive(char[] str, int start, int end) {

        if (null == str || 0 == str.length){
            return;
        }

        if (start < str.length / 2) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            reverseRecursive(str, start+1, end-1);
        }

    }
    public static String reverseRecursive(String str){

        if(null == str || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        reverseRecursive(chars, 0, chars.length - 1);

        return String.valueOf(chars);
    }

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     *
     * Given an input string, reverse the string word by word.
     *
     * Example:
     * Input: "the sky is blue",
     * Output: "blue is sky the".
     *
     * Note:
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or
     * trailing spaces. You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     * Follow up: For C programmers, try to solve it in-place in O(1) space.
     *
     * @param str
     * @return reversed words in a string
     */
    public static String reverseWords(String str){
        // TODO To be implemented
        if (null == str || str.length() < 1) {
            return str;
        }

        return str;

    }

    /**
     * https://leetcode.com/problems/reverse-words-in-a-string-iii/
     *
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
     * whitespace and initial word order.
     *
     * Example:
     * Input: "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     *
     * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     *
     * @param str
     * @return reversed words in a string
     */
    public static String reverseWords3(String str){
        // TODO To be implemented
        return str;
    }
}
