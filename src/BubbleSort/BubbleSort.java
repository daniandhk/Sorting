package BubbleSort;
import java.util.Random;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author dania
 */
public class BubbleSort {

    void bubbleSort(int arr[]) //algoritma bubble sort
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] dan arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 
    
    void printArray(int arr[]) //output isi array
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //perhitungan waktu eksekusi
        
        int[] arr = new int[50000]; //random array
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
           arr[i] = rd.nextInt();
        }
        
        System.out.println("Bubble sort");
        BubbleSort ob = new BubbleSort(); 
        System.out.println("Ukuran Array: "+arr.length);
        System.out.println("Array Random: "); 
        ob.printArray(arr);
        ob.bubbleSort(arr); //menjalankan bubble sort
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

