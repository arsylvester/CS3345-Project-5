Name: Andrew Sylvester
NetID: ars170007
Class: CS 3345
Section: 001
Semester: Fall 2019

This is Project 5 with the following files:
	QuickSorter.java
	Main.java

The code was developed in eclispe IDE. The code also can be compiled and ran in eclispe. 

Steps for compilation and running if needed (eclipse):
First, set up a java project with the 2 java files in the src folder (default package).
Next, add the desired input files to the project folder (above src). 
Next go to Run -> Run Configurations -> Argument. Under "Program Arguments" add 100000 report.txt unsorted.txt sorted.txt.
Apply these changes. 
Now Main.java should be able to run and compile via the eclispe run button.

Steps for compilation and running if needed (Command Line):
CD to the folder with all the java files and input files in it. Enter the command javac Main.java to compile.
Now run the program with java Main 100000 report.txt unsorted.txt sorted.txt.

Analysis of the runtime of the pivot strategies:
For a general randomly generated array I found that the MEDIAN_OF_THREE_ELEMENTS strategy to be the most efficent and most consistant. The consistancy makes since as it doesn't involve random elements, and by having the pivot be the median it is far more likely to split into larger mopre even subarrays.
For both fully sorted and almost sorted arrays I found that both strategies that used medians to be fairly faster than the other strategies. And then out of the median strategies I found that the non random MEDIAN_OF_THREE_ELEMENTS to be yet again to be quickest. 
The data used to formulate this analysis can be found in the reports below.


Sample of three standard runs: java Main 100000 report.txt unsorted.txt sorted.txt

Report 1:
Array Size = 100000
FIRST_ELEMENT : PT0.0426255S
RANDOM_ELEMENT : PT0.0394654S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0489547S
MEDIAN_OF_THREE_ELEMENTS : PT0.0376159S

Report 2:
Array Size = 50000
FIRST_ELEMENT : PT0.0249213S
RANDOM_ELEMENT : PT0.0388304S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0279083S
MEDIAN_OF_THREE_ELEMENTS : PT0.023545S


Report 3:
Array Size = 4000
FIRST_ELEMENT : PT0.0048485S
RANDOM_ELEMENT : PT0.0030548S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0037835S
MEDIAN_OF_THREE_ELEMENTS : PT0.0023501S

Sample Reports of three already sorted arrays:

Report 1:
Array Size = 1000
FIRST_ELEMENT : PT0.0095724S
RANDOM_ELEMENT : PT0.0013207S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0007546S
MEDIAN_OF_THREE_ELEMENTS : PT0.0003751S

Report 2:
Array Size = 1000
FIRST_ELEMENT : PT0.0094497S
RANDOM_ELEMENT : PT0.001089S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0005377S
MEDIAN_OF_THREE_ELEMENTS : PT0.0003647S

Report 3:
Array Size = 1000
FIRST_ELEMENT : PT0.0100369S
RANDOM_ELEMENT : PT0.0011686S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0005128S
MEDIAN_OF_THREE_ELEMENTS : PT0.0004171S

Sample Reports of three almost sorted (10% off) arrays:

Report 1:
Array Size = 1000
FIRST_ELEMENT : PT0.0026088S
RANDOM_ELEMENT : PT0.0010915S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0005298S
MEDIAN_OF_THREE_ELEMENTS : PT0.000436S

Report 2:
Array Size = 1000
FIRST_ELEMENT : PT0.0025394S
RANDOM_ELEMENT : PT0.001139S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0005863S
MEDIAN_OF_THREE_ELEMENTS : PT0.0004251S

Report 3:
Array Size = 1000
FIRST_ELEMENT : PT0.0024238S
RANDOM_ELEMENT : PT0.0013671S
MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.0007388S
MEDIAN_OF_THREE_ELEMENTS : PT0.0005304S

