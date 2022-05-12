public class QuicksortThreeMedian {
    public static int a[];
    public static int bp=10;
    public QuicksortThreeMedian(int arr[],int n){
        int left = 0;
        int right = n-1;
        a=arr;    
        //quickSort(left, right);
        //if(n<=150)
        	//bp=150;
        HybridquickSort(left, right);
    }
    
    public static void insertionSort(int low, int n)
    {  
        for (int i = low + 1; i <= n; i++)
        {
            int value = a[i];
            int j = i;

            while (j > low && a[j - 1] > value)
            {
                a[j] = a[j - 1];
                j--;
            }

 
            a[j] = value;
        }
    }
      
/*public static void quickSort(int left,int right){
         
        
        if(left >= right)
            return;
         
        
        int pivot = getMedian(left, right);
        int partition = partition(left, right, pivot);
         
        
        quickSort(0, partition);
        quickSort(partition+1, right);
    }*/
    
/*private static void HybridquickSort(int left,int right){ // Problematic
         while(left<right)
         {
        	 if(right-left<12)
        	 {
        		 insertionSort(left,right);
        		 break;
        	 }
        	 else
        	 {
        		 int pivot = getMedian(left, right);
        		 int partition=partition(left, right, pivot);
        	     if (partition - left < right - partition)
                 {
        	    	 HybridquickSort(left, partition );
                     left = partition ;
                 }
                 else {
                	 HybridquickSort( partition + 1, right);
                     right = partition +1 ;
                 }
        	 }
         }
         
    }*/
    
    public static void HybridquickSort( int low, int high)
    {
        while (low < high)
        {
            // switch to insertion sort if the size is 10 or smaller
            if (high - low < 25)
            {
                insertionSort( low, high);
                break;
            }
            else {
                int pivot = getMedian(low, high);
                int partition=partition(low, high, pivot);
                // tail call optimizations – recur on the smaller subarray
                if (partition - low < high - partition)
                {
                    HybridquickSort(low, partition );
                    low = partition +1;
                }
                else {
                    HybridquickSort(partition+1 , high);
                    high = partition;
                }
            }
        }
    }
    
    public static int partition( int lo, int hi,int p) { // Hoare Partition
        int pivot = p;
        int i = lo-1, j = hi+1;
        while(true) {
          do { i++; } while(a[i] < pivot);
          do { j--; } while(a[j] > pivot);
          if (i < j) swap( i, j);
          else return j;
        }
      }
     
    public static int getMedian(int left,int right){ // Right One
        int center = (left+right)/2;
         
        if(a[right] < a[left])
        	swap(left,right);
         
        if(a[center] < a[left])
            swap(center, left);
         
        if(a[right] < a[center])
            swap(right, center);
        
        swap(left,center);
        return a[left];
    }
    
 
     
    public static void swap(int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
    
}
