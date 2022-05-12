import java.util.Random;

//Code By Charchit Rajput
//Comparison of different sorting methods of Quick sort
//Quick Sort is Preferred over Merge Sort despite having n^2 worse case


public class QuickSortComparison {
	static void printArray(int[] arr, int size, long t,String S)
	{
	    for(int i = 0; i < size; i++)
	        System.out.print(arr[i] + " ");
	         
	    System.out.println("  "+t+"ns"+S);
	}
	 static void printDet(long t,String s)
	 {
		 System.out.println("  "+t/1000000+"ms"+s);
	 }
	public static void main(String[] args) {
		     //int[] arr = {4,1,35,9,6,10,32,14,30,27,24,73,68,39,18,95,37,11,34,49,69};
		     //int n=arr.length;
		     Random r =new Random();
		     int n=1200000;//choose length of array
		     int high=n;//Choose range of random number from 0 to high
		     int arr[]=new int[n];
		     for(int i=0;i<n;i++)
		     {
		    	 arr[i]=r.nextInt(high);
		     }
		     long startTime,endTime,timeElapsed,timeElapsed1=0;
		  
		     System.out.println("Start");
		     
		     int[] arr1=arr.clone();
		     startTime = System.nanoTime();
		     QuickSortMedian qsm=new QuickSortMedian(arr1);
			 endTime = System.nanoTime();
	         timeElapsed = endTime - startTime;
	         printDet( timeElapsed," Choosing Median As the pivot every time");
	         arr1=null;
	          

		 
	         
	         

		     int[] arr3=arr.clone();
		     startTime = System.nanoTime();
		     QuickSortRandom qsr=new QuickSortRandom(arr3,n);
			 endTime = System.nanoTime();
	         timeElapsed = endTime - startTime;
	         printDet( timeElapsed," Choosing a random element as a pivot");
	         arr3=null;
		  

		     int[] arr4=arr.clone();
		     startTime = System.nanoTime();
		     QuicksortThreeMedian qstm=new QuicksortThreeMedian(arr4,n);
			 endTime = System.nanoTime();
	         timeElapsed = endTime - startTime;
	         printDet( timeElapsed," Hybrid + Hoard Partitioning + Three Median(Modified)");
	         arr4=null;
	        
	}

}

