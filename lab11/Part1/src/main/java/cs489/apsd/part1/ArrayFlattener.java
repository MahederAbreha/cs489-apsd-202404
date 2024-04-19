package cs489.apsd.part1;

public class ArrayFlattener {
    public int[] flattenArray(int[][] arr) {
        if (arr == null) {
            return null;
        }
        int totalLength = 0;
        for (int[] ints : arr) {
            totalLength += ints.length;
        }
        int[] result = new int[totalLength];
        int index = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                result[index++] = anInt;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] arr = {{1, 2, 3}, {4, 5}, {6}};
        int[] result = arrayFlattener.flattenArray(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
