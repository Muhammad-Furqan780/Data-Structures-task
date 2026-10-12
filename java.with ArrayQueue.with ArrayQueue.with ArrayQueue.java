import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayWithQueue {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Queue<Integer> queue = new LinkedList<>();

        // 1. Enqueue all array elements
        for (int n : arr) {
            queue.offer(n);
        }

        // 2. Dequeue them back into the array (order is preserved)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.poll();
        }
        System.out.println("Array after queue: " + Arrays.toString(arr));
        // Output: [10, 20, 30, 40, 50]

        // 3. Reverse the first k elements using a queue
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        for (int n : nums) q.offer(n);

        // Reverse the first k elements using a temporary array
        int[] temp = new int[k];
        for (int i = k - 1; i >= 0; i--) temp[i] = q.poll();
        Queue<Integer> result = new LinkedList<>();
        for (int i = k - 1; i >= 0; i--) result.offer(temp[i]);

        while (!q.isEmpty()) result.offer(q.poll());

        System.out.println("First " + k + " reversed: " + result);
        // Output: [3, 2, 1, 4, 5, 6]

        // 4. Sliding window: queue holds the current window of size 3
        int[] values = {1, 3, 5, 7, 9};
        Queue<Integer> window = new LinkedList<>();
        int sum = 0;
        for (int v : values) {
            window.offer(v);
            sum += v;
            if (window.size() > 3) {
                sum -= window.poll();
            }
            if (window.size() == 3) {
                System.out.println("Window " + window + " sum = " + sum);
            }
        }
    }
}