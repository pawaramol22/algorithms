import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void test_isPalindromeIgnoreWhitespaces(){

        Assert.assertFalse(StringUtils.isPalindromeIgnoreWhitespaces(".,"));
        Assert.assertTrue(StringUtils.isPalindromeIgnoreWhitespaces(" "));
        Assert.assertFalse(StringUtils.isPalindromeIgnoreWhitespaces(null));

        String string = "A man, a plan, a canal: Panama";
        boolean result = StringUtils.isPalindromeIgnoreWhitespaces(string);
        Assert.assertTrue(result);

        Assert.assertTrue(StringUtils.isPalindromeIgnoreWhitespaces("Aba"));
        Assert.assertFalse(StringUtils.isPalindromeIgnoreWhitespaces("race a car"));

    }
}
