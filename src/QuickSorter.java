
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class QuickSorter
{
	private static final int SMALL_ARRAY_LIMIT = 20;

    /*
     * This private constructor is optional, but it does help to prevent accidental client instantiation of QuickSorter
     * via the default constructor.  (defining any constructor prevents the compiler from creating a default constructor)
     * This particular anti-instantiation technique is exactly what {@link java.util.Collections} does.
     */
    private QuickSorter() { }

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
    			while(list.get(++i).compareTo(pivot) < 0) {} //Just iterate till found greater element.
    			while(list.get(--j).compareTo(pivot) > 0) {} //Just iterate till found lesser element.
    			if( i < j)
    				swapElements(list, i, j);
    			else
    				break;
    		}
    			swapElements(list, i, right - 1 );   // Restore pivot
    			
    			firstElementQuickSort(list, left, i - 1);
    			firstElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
    private static <E extends Comparable<E>> void randomElementQuickSort(ArrayList<E> list, int left, int right)
    {
    	//If subarray is smaller than 20 then use insertion sort.
    	if(left + SMALL_ARRAY_LIMIT <= right)
    	{
    		Random random = new Random();
    		// Place pivot at position right - 1
            swapElements( list, random.nextInt(right - left + 1) + left, right - 1 );
    		E pivot = list.get(right - 1);
    		
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
    			
    			firstElementQuickSort(list, left, i - 1);
    			firstElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
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
    			while(list.get(++i).compareTo(pivot) < 0) {} //Just iterate till found greater element.
    			while(list.get(--j).compareTo(pivot) > 0) {} //Just iterate till found lesser element.
    			if( i < j)
    				swapElements(list, i, j);
    			else
    				break;
    		}
    			swapElements(list, i, right - 1 );   // Restore pivot
    			
    			firstElementQuickSort(list, left, i - 1);
    			firstElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
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

        // Place pivot at position right - 1
        swapElements( list, y, right - 1 );
        return list.get(right - 1);
    }
    
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
    			
    			firstElementQuickSort(list, left, i - 1);
    			firstElementQuickSort(list, i + 1, right);
    	}
    	else
    		insertionSort(list, left, right);
    }
    
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
    
    private static <E extends Comparable<E>> void swapElements(ArrayList<E> list, int i, int j)
    {
    	E temp = list.get(i);
    	list.set(i, list.get(j));
    	list.set(j, temp);
    }
    
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

    public static ArrayList<Integer> generateRandomList(int size) throws IllegalArgumentException
    {
    	if(size < 0)
    		throw new IllegalArgumentException("Size should be nonnegative!");
    	
    	Random random = new Random();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for(int x = 0; x < size; x++)
    	{
    		list.add(random.nextInt(50 - -50 + 1) + -50);
    	}
    	
		return list;
    }

    public static enum PivotStrategy
    {
        FIRST_ELEMENT,
        RANDOM_ELEMENT,
        MEDIAN_OF_THREE_RANDOM_ELEMENTS,
        MEDIAN_OF_THREE_ELEMENTS
    }

}