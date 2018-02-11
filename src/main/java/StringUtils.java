
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
}
