import java.util.Arrays;
import java.util.List;

public class SortingArrays {

    public static void main(String[] args) {
        Integer[] array = new Integer[] { 29, 27, 77, 49, 75, 35, 9, 30, 95, 28 };

        // SortingArrays.bubbleSort(array);
        // SortingArrays.selectSort(array);
        SortingArrays.insertionSort(array);
        List<Integer> l = Arrays.asList(array);
        System.out.println(l);

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

}
