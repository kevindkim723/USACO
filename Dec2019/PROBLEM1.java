package Dec2019;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class PROBLEM1 {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = new FileReader("input.txt");

		Scanner sc = new Scanner(fr);

		int cases = sc.nextInt();
		int cows = sc.nextInt();
		String[][] array = new String[cases][cows];
		for (int i = 0; i < cases; i++) {
			for (int j = 0; j < cows; j++) {
				array[i][j] = sc.next();
			}
		}
		returnPairs(cases, cows, array);
	}

	public static void printArray(String[][] array) {
		for (String row[] : array) {
			for (String letter : row) {
				System.out.print(letter.concat(" "));
			}
			System.out.println();
		}
	}

	public static void returnPairs(int rows, int cows, String[][] array) {
		int pairs = findNumPairs(cows);
		String[][] cowArray = new String[rows][pairs];

		String onePair = "";
		int pairCounter = 0;

		for (int i = 0; i < rows; i++) {
			pairCounter = 0;
			for (int j = 0; j < cows; j++) {
				for (int k = j + 1; k < cows; k++) {
					onePair = array[i][j].concat(array[i][k]);
					cowArray[i][pairCounter] = onePair;
					pairCounter++;
				}
			}
		}
		System.out.println(compare(cowArray, pairCounter, rows));

	}

	public static int findNumPairs(int input) {
		int output = 0;
		input = input - 1;

		for (int i = input; input > 0; input--) {
			output = output + input;
		}
		return output;
	}

	public static int compare(String[][] inputArray, int numPairs, int rows) {
		String currentPair = "";
		String nextPair = "";
		int counter = 0;
		int outputCounter = 0;
		if (rows == 1) {
			outputCounter = numPairs;
		} else {
			for (int i = 0; i < numPairs; i++) {
				counter = 0;
				for (int j = 1; j < rows; j++) {
					for (int k = 0; k < numPairs; k++) {
						currentPair = inputArray[0][i];
						nextPair = inputArray[j][k];
						if (currentPair.equals(nextPair)) {
							counter++;
							break;
						}
					}
				}
				if (counter == rows - 1) {
					outputCounter++;
				}
			}
		}
		return outputCounter;
	}

}
