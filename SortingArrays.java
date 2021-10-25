import java.util.Arrays;
import java.util.List;

public class SortingArrays {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {29, 27, 77, 49, 75, 35, 9, 30, 95, 28};

        // SortingArrays.bubbleSort(array);
        // SortingArrays.selectSort(array);
        // SortingArrays.insertionSort(array);
        // Integer[] l = SortingArrays.mergeSort(array);
        SortingArrays.quickSort(array, 0, array.length);
        System.out.println(Arrays.asList(array));

    }

    public static void bubbleSort(Integer[] array) {
        for (int unorderedIndex = array.length - 1; unorderedIndex > 0; unorderedIndex--) {
            for (int j = 0; j < unorderedIndex; j++) {
                int current = array[j];
                if (current > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = current;
                }
            }

        }
    }

    public static void selectSort(Integer[] array) {
        for (int unorderedIndex = array.length - 1; unorderedIndex > 0; unorderedIndex--) {

            int index = 0;
            int greatest = 0;

            for (int j = 0; j < unorderedIndex; j++) {
                if (array[j] > greatest) {
                    greatest = array[j];
                    index = j;
                }
            }

            if (greatest > array[unorderedIndex]) {
                array[index] = array[unorderedIndex];
                array[unorderedIndex] = greatest;
            }
        }
    }

    public static void insertionSort(Integer[] array) {
        for (int unorderedIndex = 1; unorderedIndex < array.length; unorderedIndex++) {

            int j = unorderedIndex - 1;
            int currentItem = array[unorderedIndex];

            while (j >= 0 && array[j] > currentItem) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = currentItem;
        }
    }

    public static Integer[] mergeSort(Integer[] array) {
        if (array.length == 1)
            return array;

        int mid = array.length / 2;

        Integer[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        Integer[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        array = new Integer[left.length + right.length];

        int sortedIndex = 0, leftIndex = 0, rightIndex = 0;

        while (sortedIndex < array.length && leftIndex < left.length && rightIndex < right.length) {

            if (left[leftIndex] < right[rightIndex]) {
                array[sortedIndex] = left[leftIndex];
                leftIndex++;
            } else if (left[leftIndex] > right[rightIndex]) {
                array[sortedIndex] = right[rightIndex];
                rightIndex++;
            }

            sortedIndex++;
        }

        if (sortedIndex < array.length) {
            if (leftIndex < left.length) {
                addTheRest(array, sortedIndex, left, leftIndex);
            } else if (rightIndex < right.length) {
                addTheRest(array, sortedIndex, right, rightIndex);
            }
        }

        return array;
    }

    private static void addTheRest(Integer[] sortedArray, int sortedIndex, Integer[] rest,
            int index) {
        for (; index < rest.length; index++) {
            sortedArray[sortedIndex] = rest[index];
            sortedIndex++;
        }
    }

    public static void quickSort(Integer[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(array, start, end);

        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    private static int partition(Integer[] array, int start, int end) {
        int pivot = array[start];// 35
        int rightIndex = end;// 7
        int leftIndex = start;// 4

        while (leftIndex < rightIndex) {

            while (leftIndex < rightIndex && array[--rightIndex] >= pivot);
            if (leftIndex < rightIndex)
                array[leftIndex] = array[rightIndex];

            while (leftIndex < rightIndex && array[++leftIndex] <= pivot);
            if (leftIndex < rightIndex)
                array[rightIndex] = array[leftIndex];

        }

        array[leftIndex] = pivot;
        return leftIndex;
    }

}
