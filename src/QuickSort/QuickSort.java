package QuickSort;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dania
 */
public class QuickSort {
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
    
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
    
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //perhitungan waktu eksekusi
        
        int[] arr = new int[50000]; //random array
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
           arr[i] = rd.nextInt();
        }
        int n = arr.length;
        
        System.out.println("Quick sort");
        QuickSort ob = new QuickSort(); 
        System.out.println("Ukuran Array: "+arr.length);
        System.out.println("Array Random: "); 
        ob.printArray(arr);
        ob.sort(arr,0,n-1);
        System.out.println("Array Terurut: "); 
        ob.printArray(arr);
        
        System.out.println("");
        System.out.println("Waktu Eksekusi: ");
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(totalTime);
        System.out.println(durationInMs+" milliseconds");
        long durationInSec = TimeUnit.NANOSECONDS.toSeconds(totalTime);
        System.out.println(durationInSec+" seconds");
    }
}
