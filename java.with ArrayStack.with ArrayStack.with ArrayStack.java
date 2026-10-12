import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ArrayWithStack {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. Push all array elements onto the stack
        for (int n : arr) {
            stack.push(n);
        }

        // 2. Pop them back into the array (this reverses it)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        System.out.println("Reversed array: " + Arrays.toString(arr));
        // Output: [50, 40, 30, 20, 10]

        // 3. Next Greater Element using a stack
        int[] data = {4, 5, 2, 25};
        int[] result = new int[data.length];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = data.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= data[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();

            st.push(data[i]);
        }

        System.out.println("Next greater: " + Arrays.toString(result));
        // Output: [5, 25, 25, -1]
    }
}