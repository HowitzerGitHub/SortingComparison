import java.util.Random;
 
public class QuickSortRandom 
{
    public static int N = 20;
    public static int[] sequence = new int[N];
 
    public static void QuickSort(int left, int right) 
    {
        if (right - left <= 0)
            return;
        else 
        {
            Random rand = new Random();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            swap(pivotIndex, right);
 
            int pivot = sequence[right];
            int partition = partitionIt(left, right, pivot);
            QuickSort(left, partition - 1);
            QuickSort(partition + 1, right);
        }
    }
 
    public static int partitionIt(int left, int right, long pivot) 
    {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) 
        {
            while (sequence[++leftPtr] < pivot)
                ;
            while (rightPtr > 0 && sequence[--rightPtr] > pivot)
                ;
 
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }
 
    public static void swap(int dex1, int dex2) 
    {
        int temp = sequence[dex1];
        sequence[dex1] = sequence[dex2];
        sequence[dex2] = temp;
    }
	

	public QuickSortRandom(int arr[],int n) {
		sequence = arr;
	    QuickSort( 0, n - 1);
	}

}
