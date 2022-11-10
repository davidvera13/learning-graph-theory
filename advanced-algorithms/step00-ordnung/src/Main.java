public class Main {
    public static void main(String[] args) {
        // O(1)
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        long start = System.currentTimeMillis();
        // getFirst(numbers);
        System.out.println(getFirst(numbers));
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println("Process duration " + duration);

        // ordered numbers
        int[] ordered = { 1, 2, 3, 4, 5, 6, 11, 12, 13,  15, 18, 21, 42, 67, 68, 69, 113};
        start = System.currentTimeMillis();
        System.out.println(search(ordered, 15));
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Process duration " + duration);

        // unordered
        int[] unordered = { 13, 18, 42, 15, 2, 21, 1, 68, 113, 3, 69, 4, 12, 5, 6, 11, 67};
        start = System.currentTimeMillis();
         System.out.println(searchUnordered(unordered, 15));
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Process duration " + duration);

        start = System.currentTimeMillis();
        System.out.println(sum(unordered));
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Process duration " + duration);


        start = System.currentTimeMillis();
        unordered =  bubbleSort(unordered);
        for (int i = 0; i < unordered.length; i++) {
            System.out.print(unordered[i] + " ");
        }
        System.out.println();
        end = System.currentTimeMillis();
        duration = end - start;
        System.out.println("Process duration " + duration);


    }

    // O(1) time complexity example
    private static int getFirst(int[] numbers) {
        return numbers[0];
    }

    // O(LogN) time complexity example: binary search with sorted array
    public static int search(int[] nums, int item) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] == item) {
                return  middle;
            }

            // discard half of the
            if(nums[middle] < item) {
                // remove left : we keep right
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        // search miss
        return - 1;
    }

    // O(n) time complexity: find item in an unsorted array
    public  static int searchUnordered(int[] nums, int item) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == item)
                return i;
        }
        // not found
        return -1;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
    // O(n²) time complexity example: bubble sort algorithm
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 1; j < nums.length - i; ++j) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }




}