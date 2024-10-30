package Project1_v4;
public class mersertionSorting {

    public long comparisons = 0;
    public int threshold = 43; // threshold value, S

    public void setComparisons(int comparisons) {
        this.comparisons =  comparisons;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
    public void getThreshold() {
        System.out.println("The threshold is: " + this.threshold);
    }

    public void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparisons++;
            }
            arr[j + 1] = key;
        }
    }

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void merge_InSort(int[] arr) {
        if (arr.length < 2)
            return;
        if (arr.length <= threshold)
            insertionSort(arr);
        else {
            int mIndex = arr.length / 2;
            int[] leftHalf = new int[mIndex];
            int[] rightHalf = new int[arr.length - mIndex];

            for (int i = 0; i < mIndex; i++)
                leftHalf[i] = arr[i];
            for (int i = 0; i < arr.length - mIndex; i++)
                rightHalf[i] = arr[mIndex + i];

            if (leftHalf.length > threshold)
                merge_InSort(leftHalf);
            else
                insertionSort(leftHalf);
            if (rightHalf.length > threshold)
                merge_InSort(rightHalf);
            else
                insertionSort(rightHalf);

            merge(arr, leftHalf, rightHalf);
        }
    }

    public void merge_InSort(int[] arr, int threshold) {
        this.threshold = threshold;
        if (arr.length < 2)
            return;
        if (arr.length <= threshold)
            insertionSort(arr);
        else {
            int mIndex = arr.length / 2;
            int[] leftHalf = new int[mIndex];
            int[] rightHalf = new int[arr.length - mIndex];

            for (int i = 0; i < mIndex; i++)
                leftHalf[i] = arr[i];
            for (int i = 0; i < arr.length - mIndex; i++)
                rightHalf[i] = arr[mIndex + i];

            if (leftHalf.length > threshold)
                merge_InSort(leftHalf);
            else
                insertionSort(leftHalf);
            if (rightHalf.length > threshold)
                merge_InSort(rightHalf);
            else
                insertionSort(rightHalf);

            merge(arr, leftHalf, rightHalf);
        }
    }

    public void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
        int lSize = leftHalf.length;
        int rSize = rightHalf.length;
        int i = 0; // index for left half
        int k = 0; // index for merged array
        int j = 0; // index for right half
        while (i < lSize && j < rSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k] = leftHalf[i];
                comparisons++;
                i++;
            } else {
                arr[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < lSize) {
            arr[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rSize) {
            arr[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    public long merge_InMain(int arr[]){
        merge_InSort(arr);
        return comparisons;
    }

    public long merge_InMain(int arr[], int threshold){
        merge_InSort(arr, threshold);
        return comparisons;
    }
}
