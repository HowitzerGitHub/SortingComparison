import java.util.Arrays;
public class QuickSortMedian {
	static int pass = 0;
	static int n = 0;
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	public static void insertionSort(int a[],int low, int n)
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
	
	static int partition(int[] arr, int low, int high)
	{
		//pass++;
		int b=high;  
		//printArray(arr,low,high," Original");
	    int temparr[]=new int[high-low+1];
	    System.arraycopy(arr, low, temparr, 0, high-low+1);
	    //printCopiedArray(temparr," Copied");
	    Arrays.sort(temparr);
	    //printCopiedArray(temparr," Copied Sorted");
	    //System.out.println(" Median is : "+temparr[temparr.length/2]);
	   for(int i=low;i<=high;i++)
	    {
	    	if(arr[i]==temparr[temparr.length/2])
	    	{
	    		b=i;
	    		break;
	    	}
	    }
	   //System.out.println(" Median is at :"+ (b+1));
	   swap(arr, b, high);
	   //printArray(arr,low,high," Original Swapped Pivot");
	    int pivot=arr[high];
		
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	  
	        if (arr[j] < pivot)
	        {
	            
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	    
	}
	 
	
	static void quickSort(int[] arr, int low, int high)
	{
	    if (low < high)
	    {
	         
	       
	        int pi = partition(arr, low, high);
	        //System.out.println("Partition= "+arr[pi]);
	        //printArray(arr,0,n-1," sorted Array");
	        //System.out.println();
	        quickSort(arr, low, pi - 1);
	        //System.out.println(" Second half");
	        quickSort(arr, pi + 1, high);
	    }
	}
	 
	

	public QuickSortMedian(int arr[]) {
	    n = arr.length;
	    quickSort(arr, 0, n - 1);
	}
	static void printArray(int[] arr,int low,int high,String s)
    {
        for(int i = low; i <= high; i++){
           System.out.print(arr[i] + " ");
        }
        System.out.print(" pass : "+pass+s);
        System.out.println();
    }
	
	static void printCopiedArray(int[] arr,String s)
    {
        for(int i = 0; i < arr.length; i++){
           System.out.print(arr[i] + " ");
        }
        System.out.print(" pass : "+pass+s);
        System.out.println();
    }

}
