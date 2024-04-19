package cs489.apsd.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArrayReverserTest {
    @Mock
    ArrayFlattenerService arrayFlattenerService;
    private ArrayReverser arrayReverser;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        arrayReverser = new ArrayReverser(arrayFlattenerService);
    }

    @Test
    public void testReverseArray() {
        int[][] arr = {{1, 2, 3}, {4, 5}, {6}};
        when(arrayFlattenerService.flattenArray(arr)).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        int[] result = arrayReverser.reverseArray(arr);
        int[] expected = {6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, result);
        verify(arrayFlattenerService).flattenArray(arr);
    }

    @Test
    public void testReverseArrayWithNull() {
        int[][] arr = {{1, 2, 3}, {4, 5}, {6}};
        when(arrayFlattenerService.flattenArray(arr)).thenReturn(null);
        int[] result = arrayReverser.reverseArray(arr);
        assertArrayEquals(null, result);
        verify(arrayFlattenerService).flattenArray(arr);
    }
}
