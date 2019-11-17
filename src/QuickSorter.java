/* Name: Andrew Sylvester
 * Class: CS 3345
 * Section: 001
 * Semester: Fall 2019
 * Project 5 
 * Class Description: This class QuickSorter is an implementation of an in place quicksort with 4 different pivot options. It also returns the time taken to sort.
 * A method to create a random array list is also included.
 */
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class QuickSorter
{
	private static final int SMALL_ARRAY_LIMIT = 20;

    /**
     * Constructor
     */
    private QuickSorter() { }

    /**
     * This method quicksorts the provided ArrayList using the provided pivot strategy. 
     * @param list The ArrayList to sort.
     * @param strategy The PivotStrategy for the quicksort to use.
     * @return The runtime of the quicksort.
     * @throws NullPointerException
     */
    public static <E extends Comparable<E>> Duration timedQuickSort(ArrayList<E> list, PivotStrategy strategy) throws NullPointerException
    {
    	if(list == null || strategy == null)
    	{
    		throw new NullPointerException("Argument[s] are null!");
    	}
    	
    	long startTime = 0;
    	
    	switch(strategy)
    	{
    	case FIRST_ELEMENT:
    		startTime = System.nanoTime();
    		firstElementQuickSort(list, 0, list.size() - 1);
    		break;
    	case RANDOM_ELEMENT:
    		startTime = System.nanoTime();
    		randomElementQuickSort(list, 0, list.size() - 1);
    		break;
    	case MEDIAN_OF_THREE_RANDOM_ELEMENTS:
    		startTime = System.nanoTime();
    		randomMedianQuickSort(list, 0, list.size() - 1);
    		break;
    	case MEDIAN_OF_THREE_ELEMENTS:
    		startTime = System.nanoTime();
    		medianQuickSort(list, 0, list.size() - 1);
    		break;
    	}
    	
    	long finishTime = System.nanoTime();
        Duration elapsedTime = Duration.ofNanos(finishTime - startTime);
		return elapsedTime;
    }
    
    /**
     * Private recursive quicksort method that uses the first element of the array as the pivot.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     */
    private static <E extends Comparable<E>> void firstElementQuickSort(ArrayList<E> list, int left, int right)
    {
    	//If subarray is smaller than 20 then use insertion sort.
    	if(left + SMALL_ARRAY_LIMIT <= right)
    	{
    		 // Place pivot at position right - 1
            swapElements( list, left, right);
    		E pivot = list.get(right);
    		
    		int i = left;
    		int j = right - 1;
    		while(true)
    		{
    			while(list.get(i).compareTo(pivot) < 0) {i++;} //Just iterate till found greater element.
    			while(j >= 0 &&list.get(j).compareTo(pivot) > 0) {j--;} //Just iterate till found lesser element.
    			if( i < j)
    			{
    				swapElements(list, i, j);
    				i++;
    				j--;
    			}
    			else
    				break;
    		}
    			swapElements(list, i, right);   // Restore pivot
    			
    			firstElementQuickSort(list, left, i - 1);
    			firstElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
    /**
     * Private recursive quicksort method that uses a random element of the array as the pivot.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     */
    private static <E extends Comparable<E>> void randomElementQuickSort(ArrayList<E> list, int left, int right)
    {
    	//If subarray is smaller than 20 then use insertion sort.
    	if(left + SMALL_ARRAY_LIMIT <= right)
    	{
    		Random random = new Random();
    		// Place pivot at position right - 1
            swapElements( list, random.nextInt(right - left + 1) + left, right - 1 );
    		E pivot = list.get(right);
    		
    		int i = left;
    		int j = right - 1;
    		while(true)
    		{
    			while(list.get(i).compareTo(pivot) < 0) {i++;} //Just iterate till found greater element.
    			while(j >= 0 && list.get(j).compareTo(pivot) > 0) {j--;} //Just iterate till found lesser element.
    			if( i < j)
    			{
    				swapElements(list, i, j);
    				i++;
    				j--;
    			}
    			else
    				break;
    		}
    			swapElements(list, i, right);   // Restore pivot
    			
    			randomElementQuickSort(list, left, i - 1);
    			randomElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
    /**
     * Private recursive quicksort method that uses the median of 3 random elements of the array as the pivot.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     */
    private static <E extends Comparable<E>> void randomMedianQuickSort(ArrayList<E> list, int left, int right)
    {
    	//If subarray is smaller than 20 then use insertion sort.
    	if(left + SMALL_ARRAY_LIMIT <= right)
    	{
    		E pivot = randomMedian(list, left, right);
    		
    		int i = left;
    		int j = right - 1;
    		while(true)
    		{
    			while(list.get(i).compareTo(pivot) < 0) {i++;} //Just iterate till found greater element.
    			while(j >= 0 && list.get(j).compareTo(pivot) > 0) {j--;} //Just iterate till found lesser element.
    			if( i < j)
    			{
    				swapElements(list, i, j);
    				i++;
    				j--;
    			}
    			else
    				break;
    		}
    			swapElements(list, i, right);   // Restore pivot
    			
    			randomMedianQuickSort(list, left, i - 1);
    			randomMedianQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
    /**
     * Helper method to the randomMedianQuickSort method that gets the median element of 3 random elements in the subarray.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     * @return The pivot.
     */
    private static <E extends Comparable<E>> E randomMedian(ArrayList<E> list, int left, int right)
    {
    	Random random = new Random();
    	int x = random.nextInt(right - left + 1) + left;
    	int y = random.nextInt(right - left + 1) + left;
    	int z = random.nextInt(right - left + 1) + left;
    	
        if(list.get(y).compareTo(list.get(x) ) < 0 )
            swapElements( list, x, y );
        if( list.get(z).compareTo(list.get(x) ) < 0 )
        	swapElements( list, x, z );
        if( list.get(z).compareTo(list.get(y) ) < 0 )
        	swapElements( list, y, z );

        swapElements( list, y, right);
        return list.get(right);
    }
    
    /**
     * Private recursive quicksort method that uses the median of the subarray as the pivot.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     */
    private static <E extends Comparable<E>> void medianQuickSort(ArrayList<E> list, int left, int right)
    {
    	//If subarray is smaller than 20 then use insertion sort.
    	if(left + SMALL_ARRAY_LIMIT <= right)
    	{
    		E pivot = median(list, left, right);
    		
    		int i = left;
    		int j = right - 1;
    		while(true)
    		{
    			while(list.get(++i).compareTo(pivot) < 0) {} //Just iterate till found greater element.
    			while(list.get(--j).compareTo(pivot) > 0) {} //Just iterate till found lesser element.
    			if( i < j)
    				swapElements(list, i, j);
    			else
    				break;
    		}
    			swapElements(list, i, right - 1 );   // Restore pivot
    			
    			medianQuickSort(list, left, i - 1);
    			medianQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
    /**
     * Helper method to the medianQuickSort method that gets the median element in the subarray.
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     * @return The pivot.
     */
    private static <E extends Comparable<E>> E median(ArrayList<E> list, int left, int right)
    {
    	int center = ( left + right ) / 2;
    	if(list.get(center).compareTo(list.get(left) ) < 0 )
            swapElements( list, left, center );
        if( list.get(right).compareTo(list.get(left) ) < 0 )
        	swapElements( list, left, right );
        if( list.get(right).compareTo(list.get(center) ) < 0 )
        	swapElements( list, center, right );

        // Place pivot at position right - 1
        swapElements( list, center, right - 1 );
        return list.get(right - 1);
    }
    
    /**
     * Private method that swaps the elements at index i and j.
     * @param list ArrayList that elements are being swapped in.
     * @param i The first index to be swapped.
     * @param j The second index to be swapped.
     */
    private static <E extends Comparable<E>> void swapElements(ArrayList<E> list, int i, int j)
    {
    	E temp = list.get(i);
    	list.set(i, list.get(j));
    	list.set(j, temp);
    }
    
    /**
     * Private insertion sort method. Used when a subarray in the quick sort becomes too small (20 or less).
     * @param list The ArrayList being sorted.
     * @param left Start of subarray being sorted.
     * @param right End of subarray being sorted.
     */
    private static <E extends Comparable<E>> void insertionSort(ArrayList<E> list, int left, int right)
    {
    	for(int x = left + 1; x <= right; x++)
    	{
    		E current = list.get(x);
    		int y;
    		for(y = x; y > left && current.compareTo(list.get(y - 1)) < 0; y--)
    		{
    			list.set(y, list.get(y - 1));
    		}
    		list.set(y, current);
    	}
    }

    /**
     * The method instantiates an ArrayList and generates random integers in the arraylist.
     * @param size The size of the ArrayList/number of elements to randomly generate
     * @return The randomly generated ArrayList
     * @throws IllegalArgumentException
     */
    public static ArrayList<Integer> generateRandomList(int size) throws IllegalArgumentException
    {
    	if(size < 0)
    		throw new IllegalArgumentException("Size should be nonnegative!");
    	
    	Random random = new Random();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for(int x = 0; x < size; x++)
    	{
    		list.add(random.nextInt());
    	}
    	
		return list;
    }

    /**
     * Public Enum for each pivot strategy that the quicksort method can use.
     */
    public static enum PivotStrategy
    {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS
    }
    
    /**
     * This method randomly swaps a elements in an ArrayList by a percent. This is used for testing purposes of an almost sorted array.
     * @param list ArrayList to randomly swap.
     * @param percent The percentage to swap around elements by.
     */
    public static <E extends Comparable<E>> void randomSwap(ArrayList<E> list, int percent)
    {
    	Random random = new Random();
    	for(int x = 0; x < list.size()/percent; x++)
    	{
    		int i = random.nextInt(list.size() - 2);
        	int j = random.nextInt(list.size() - 2);
        	swapElements(list, i, j);
    	}
    }

}