package HeapSort;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dania
 */
public class HeapSort { //heapsort
    
    public void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
    
    void heapify(int arr[], int n, int i) //max-heapify
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
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
        
        System.out.println("Heapsort");
        HeapSort ob = new HeapSort(); 
        System.out.println("Ukuran Array: "+arr.length);
        System.out.println("Array Random: "); 
        ob.printArray(arr);
        ob.sort(arr); //menjalankan heapsort
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

