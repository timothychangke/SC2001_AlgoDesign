package Project1_v4;
public class insertionSort {
	    int comparisons=0;
		public long insertionSort(int arr[]) {
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
	    return comparisons;
		}
	    
		public void setComparisons(int comparisons) {
	        this.comparisons =  comparisons;
	    }

	}

