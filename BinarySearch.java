public class BinarySearch {

    

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        
       var i = binarySearch(0, array, 0, array.length);
        if(i >= 0) {
            System.out.println(array[i]);
        } else {
            System.out.println("No luck bro!");
        }

    }

    private static int binarySearch(int value, Integer[] array, int start, int end) {
        int mid = (start + end) / 2;
        if(end - start < 1) {
            return -1;
        }

        if(array[mid] == value) {
            return mid;
        } else if(array[mid] > value) {
           return binarySearch(value, array, start, mid);
        } else if(array[mid] < value) {
           return binarySearch(value, array, mid, end);
        } else {
            return -1;
        }
    }
}
