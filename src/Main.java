import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		Integer[] test = {-40, -12, -25, -1, 29, -26, 3, -7, -17, 36, -41, 8, 1, -17, 12, -24, -17, -10, -48, 33, 10, 6, -3, -26, -27, 1, 14, -13, 7, -33};
		ArrayList<Integer> initialList = QuickSorter.generateRandomList(30);
//		for(int x = 0; x < test.length; x++)
//		{
//			initialList.add(test[x]);
//		}
		System.out.println(initialList.toString());
		
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		firstList.addAll(initialList);
		System.out.println(QuickSorter.timedQuickSort(firstList, QuickSorter.PivotStrategy.FIRST_ELEMENT));
		System.out.println(firstList.toString());
		
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		randomList.addAll(initialList);
		System.out.println(QuickSorter.timedQuickSort(randomList, QuickSorter.PivotStrategy.RANDOM_ELEMENT));
		System.out.println(randomList.toString());
		
		ArrayList<Integer> randomMedianList = new ArrayList<Integer>();
		randomMedianList.addAll(initialList);
		System.out.println(QuickSorter.timedQuickSort(randomMedianList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));
		System.out.println(randomMedianList.toString());
		
		ArrayList<Integer> medianList = new ArrayList<Integer>();
		medianList.addAll(initialList);
		System.out.println(QuickSorter.timedQuickSort(medianList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS));
		System.out.println(medianList.toString());
	}

}
