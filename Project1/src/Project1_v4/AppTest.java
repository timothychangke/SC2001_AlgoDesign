package Project1_v4;
import java.util.Arrays;
import java.util.Scanner;

public class AppTest {
    public static void main(String[]args){
        System.out.println(
        "---------- java SortApp ----------\n" +
        "======== Sort Computation ========\n" +
        "|1. Mersertion sort              |\n" + // done, try to test
        "|2. Merge vs Mersertion          |\n" + // done, try to test
        "|3. Merge vs insertion           |\n" + 
        "|4. Quit                         |\n" +
        "=============================");

        mergeSorting mergeSort = new mergeSorting();
        generatingArray gen = new generatingArray();
        mersertionSorting mer = new mersertionSorting();
        insertionSort inser = new insertionSort();

        // EDIT the varibles which overides the classes variables
        mer.threshold = 39; //Set Threshold
        generatingArray.arr_largest_size = 10_000_000; // Maximum size of generated arrays
        generatingArray.max_value = 1_00_000; // Maximum date value 
        generatingArray.arrlength = 10_000_000; // Fixed array length
        int numOfArr = 385;

        
        int start =1;
        while (start == 1){
            System.out.println("Choose option (1-4):");
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            
            
            switch (input){
                case 1:
                    //mersertion.class has insertion sort already
                    System.out.println("Choose type of array for mersertion Sort");
                    System.out.println("1)Fixed S (Arrays of different lengths are sorted");
                    System.out.println("2)Different S (Arrays of the same lengths are sorted)");
                    int choice = scan.nextInt();
                    System.out.println("Processing...");
                    long [][]arrCSV = new long [4][385];
                    int []array;
                    int size = 0;
                    long comparisons;
                    for (int i=0; i<numOfArr; i++){
                        if (choice == 1){
                            array = gen.generateArrayPart1();
                            size = gen.ranArrLength;
                        }
                        else{
                            array = gen.generatingArrayPart2();
                            size = generatingArray.arrlength;
                        }
                        long startTime = System.nanoTime();
                        if (choice == 1) {
                            comparisons = mer.merge_InMain(array);
                        }
                        else {
                            comparisons = mer.merge_InMain(array, i);
                        }
                        long endTime = System.nanoTime();
                        long executionTime = endTime - startTime;
                        arrCSV[0][i] = size;
                        arrCSV[1][i] = executionTime;
                        arrCSV[2][i] = comparisons;
                        arrCSV[3][i] = mer.threshold;
                        mer.setComparisons(0);
                    }
                    // System.out.println(Arrays.deepToString(arrCSV));
                    if (choice == 1) writeCSV.writeArrayToCSV1(arrCSV, "OutputDifferentN.csv");
                    if (choice == 2) writeCSV.writeArrayToCSV1(arrCSV, "OutputFixedN.csv");
                    break;
                    // System.out.println("HERE now");
                    
                case 2:
                // mersertion vs megre
                System.out.println("Processing...");
                long [][]arrCSV3 = new long [5][385];
                int []array3;
                long comparisons31;
                long comparisons32;
                for (int i=0; i<numOfArr; i++){
                    array3 = gen.generateArrayPart1();
                    size = gen.ranArrLength;
                    int[] copiedArray = Arrays.copyOf(array3, size); // create copied array with same elements
                    //mersertion
                    long startTime = System.nanoTime();
                    comparisons31 = mer.merge_InMain(array3);
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;

                    //merge
                    long startTime2 = System.nanoTime();
                    comparisons32 = mergeSort.Merging(copiedArray);
                    long endTime2 = System.nanoTime();
                    long executionTime2 = endTime2 - startTime2;

                    arrCSV3[0][i] = size;
                    arrCSV3[1][i] = executionTime; // mersertion
                    arrCSV3[2][i] = comparisons31;
                    arrCSV3[3][i] = executionTime2; //merge
                    arrCSV3[4][i] = comparisons32;
                    mer.setComparisons(0);
                    mergeSorting.setComparisons(0); 
                }
                // System.out.println(Arrays.deepToString(arrCSV));
                writeCSV.writeArrayToCSV2(arrCSV3, "MergeVsMersertionOutput.csv");
                // System.out.println("HERE now");
                    break;
                case 3:
                	// insertion_sort vs megre_sort
                    System.out.println("Processing...");
                    int []array4;
                    int x = 1000;
                    long [][]arrCSV31 = new long [5][x];
                    
                    for (int i=x-1; i>0; i--){ 
                        array4 = gen.generateArrayPart1();
                        size = i; 
                        int[] copiedArray11 = Arrays.copyOf(array4, size); // create copied array with same elements
                        int[] copiedArray22 = Arrays.copyOf(array4,size);
                        //insertion_sort 
                        long startTime = System.nanoTime();
                        long comparisons311 = inser.insertionSort(copiedArray11);
                        long endTime = System.nanoTime();
                        long executionTime = endTime - startTime;

                        //merge_sort
                        long startTime2 = System.nanoTime();
                        long comparisons321 = mergeSort.Merging(copiedArray22);
                        long endTime2 = System.nanoTime();
                        long executionTime2 = endTime2 - startTime2;

                        arrCSV31[0][i] = size;
                        arrCSV31[1][i] = executionTime; // insertion
                        arrCSV31[2][i] = comparisons311;
                        arrCSV31[3][i] = executionTime2; //merge
                        arrCSV31[4][i] = comparisons321;
                        inser.setComparisons(0);
                        mergeSorting.setComparisons(0); 
                    }
                    // System.out.println(Arrays.deepToString(arrCSV));
                    writeCSV.writeArrayToCSV3(arrCSV31, "InsertionSortVsMergeOutput.csv");
                    // System.out.println("HERE now");
                        break;
                case 4:
                    start = 0;
                    System.out.println("Thank you!");
                    scan.close();
                    break;
                }
            }
    }
}
