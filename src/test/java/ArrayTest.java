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

    @Test
    public void test_mergeSortedArrays(){

        int[] arr1 = {1, 3 , 4};
        int[] arr2 = {2, 5, 6, 7, 8};

        int[] actual_result = ArrayUtils.mergeSortedArrays(arr1, arr2);

        int[] expected_result = {1, 2, 3 ,4, 5, 6, 7, 8};
        Assert.assertArrayEquals(expected_result, actual_result);

        int[] actual_result2 = ArrayUtils.mergeSortedArrays(arr1, null);
        Assert.assertArrayEquals(arr1, actual_result2);
    }
}
