/* Name: Andrew Sylvester
 * Class: CS 3345
 * Section: 001
 * Semester: Fall 2019
 * Project 5 
 * Class Description: This class Main uses QuickSorter to generate an ArrayList with random elements then uses 4 different pivot strategies to
 * sort the array, recording the runtime of each in a file. The unsorted and sort array is printed to corresponding text files as well.
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		Scanner in;
		if (args.length != 4) 
		{
			System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
			System.exit(0);
		}
		try 
		{
			File reportFile = new File(args[1]);
			PrintWriter outReport = new PrintWriter(reportFile);
			File unsortedFile = new File(args[2]);
			PrintWriter outUnsorted = new PrintWriter(unsortedFile);
			File sortedFile = new File(args[3]);
			PrintWriter outSorted = new PrintWriter(sortedFile);
			
			int size = Integer.parseInt(args[0]);
			outReport.println("Array Size = " + args[0]);
			
			ArrayList<Integer> initialList = QuickSorter.generateRandomList(size);
			outUnsorted.println(initialList.toString());
			
			//For Test cases of sorted and almost sorted.
				//initialList.sort(null);
				//QuickSorter.randomSwap(initialList, 10);

			//FIRST ELEMENT
			ArrayList<Integer> firstList = new ArrayList<Integer>();
			firstList.addAll(initialList);
			outReport.println("FIRST_ELEMENT : " + QuickSorter.timedQuickSort(firstList, QuickSorter.PivotStrategy.FIRST_ELEMENT));

			//RANDOM ELEMENT
			ArrayList<Integer> randomList = new ArrayList<Integer>();
			randomList.addAll(initialList);
			outReport.println("RANDOM_ELEMENT : " + QuickSorter.timedQuickSort(randomList, QuickSorter.PivotStrategy.RANDOM_ELEMENT));

			//RANDOM MEDIAN ELEMENT
			ArrayList<Integer> randomMedianList = new ArrayList<Integer>();
			randomMedianList.addAll(initialList);
			outReport.println("MEDIAN_OF_THREE_RANDOM_ELEMENTS : " + QuickSorter.timedQuickSort(randomMedianList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_RANDOM_ELEMENTS));

			//MEDIAN ELEMENT
			ArrayList<Integer> medianList = new ArrayList<Integer>();
			medianList.addAll(initialList);
			outReport.println("MEDIAN_OF_THREE_ELEMENTS : " + QuickSorter.timedQuickSort(medianList, QuickSorter.PivotStrategy.MEDIAN_OF_THREE_ELEMENTS));
			
			//NOTE: The instructions state "After all sorting is over, record the final sorted array into a new file." Therefore I am only printing the median method.
			// the three other prints below can be uncommented to check the correctness of the sorts.
			//outSorted.println(firstList.toString());
			//outSorted.println(randomList.toString());
			//outSorted.println(randomMedianList.toString());
			outSorted.println(medianList.toString());
			
			outUnsorted.close();
			outSorted.close();
			outReport.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Exception: " + e.getMessage());
		}

	}

}
