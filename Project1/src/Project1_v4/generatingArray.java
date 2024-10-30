package Project1_v4;
import java.util.Random;

public class generatingArray {
    static  int arr_smallest_size = 1000; // Minimum size of generated arrays
    static  int arr_largest_size = 1_000_000; // Maximum size of generated arrays
    static  int num_of_arr = 385; // Number of arrays to generate
    static  int min_value = 1; // Minimum value in generated arrays
    static  int max_value = 1_000_000; // Maximum value in generated arrays
    static  int arrlength = 10_000; // Fixed array length
    int ranArrLength = 0;

    // Arrays of varying lengths to be generated
    public int[] generateArrayPart1() {
        Random random = new Random();
        int[] resultArr = new int[arr_largest_size];
        ranArrLength = random.nextInt(arr_largest_size - arr_smallest_size + 1) + arr_smallest_size;
        for (int i = 0; i < ranArrLength; i++) {
            resultArr[i] = random.nextInt(max_value - min_value + 1) + min_value;
        }
        return resultArr;
    }

    // Arrays of the same length to be generated
    public int[] generatingArrayPart2() {
        Random random = new Random();
        int[] resultArr = new int[arrlength];
        for (int i = 0; i < arrlength; i++) {
            resultArr[i] = random.nextInt(max_value - min_value + 1) + min_value;
        }
        return resultArr;
	}
}

