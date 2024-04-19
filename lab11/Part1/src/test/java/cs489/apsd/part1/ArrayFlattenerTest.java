package cs489.apsd.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArray(){
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] arr = {{1,3}, {0}, {4,5,9}};
        int[] result = arrayFlattener.flattenArray(arr);
        int[] expected = {1,3,0,4,5,9};
        for (int i = 0; i < result.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testFlattenArrayNull(){
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] arr = null;
        int[] result = arrayFlattener.flattenArray(arr);
        assertNull(result);
    }
}
