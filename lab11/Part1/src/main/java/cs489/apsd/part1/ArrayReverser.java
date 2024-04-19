package cs489.apsd.part1;

public class ArrayReverser {
    ArrayFlattenerService arrayFlattenerService ;

    public ArrayReverser(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] arr) {
        int[] flattenedArray = arrayFlattenerService.flattenArray(arr);
        if (flattenedArray == null) {
            return null;
        }
        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }
        return reversedArray;
    }
}
