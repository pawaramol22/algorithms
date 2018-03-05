import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {

    private int[] arr = {1, 2, 3, 4, 5, 6, 7 ,8 ,9, 10};

    @Test
    public void test_rotate(){
        int[] actual_result = ArrayUtils.rotate(arr, 2);
        int[] expected_result = {3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
        Assert.assertArrayEquals(expected_result, actual_result);
    }
}
