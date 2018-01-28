package dataMining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * This class merges the fields that match the criteria defined in the project.
 * 
 * @attribute numRows: The number of rows of the input dataMatrix.
 * @attribute numCols: The number of columns of the input dataMatrix.
 * @attribute inputFileName: The absolute path to the input file containing the
 *            dataset used.
 * @attribute outputFileName: The absolute path where the output file will be
 *            created.
 * @attribute sheetName: The name given to the sheet in the XLSX file.
 * 
 * 
 * @input: The XLSX file containing the data from the ECLS-K:2011 study after
 *         the “Data Preprocessing” phase of the project.
 * @output: An XLSX file containing the transformed data that will be used in
 *          the modeling phase of the project.
 */
public class FieldMerger {

	private static int numRows = 16755;
	private static int numCols = 580;
	private static String inputFileName = "C:/temp/PreprocesedDataset.xlsx";
	private static String outputFileName = "C:/temp/TransformedDataset.xlsx";
	private static String sheetName = "TransformedDataset";

	public static void main(String[] args) {
		System.out.println("--- FieldTransformator STARTING ---");

		String[][] dataMatrix = new String[numRows][numCols];

		// Uses the XLSXManager to read the input file, defined in the class,
		// and stores it in the given matrix.
		xlsx.XLSXManager.readXLSX(inputFileName, dataMatrix);

		mergeFields(dataMatrix);

		// Uses the XLSXManager to create a file in the path defined in the
		// class, and stores the output of the process.
		xlsx.XLSXManager.createXLSX(outputFileName, sheetName, dataMatrix);

		System.out.println("--- FieldTransformator FINISHED ---");
	}

	/**
	 * Merges the fields that match the criteria defined in the project.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 */
	public static void mergeFields(String[][] dataMatrix) {
		System.out.println("--- mergeFields STARTING ---");

		Integer dataPoints;
		Integer validDataPoints;
		Float medValue;
		Map<Integer, String> currentMap = new TreeMap<Integer, String>();
		Map<Integer, String> auxMap = new TreeMap<Integer, String>();

		for (int col = 0; col < numCols;) {
			currentMap = getFieldValueRange(dataMatrix, col);

			// Determines the number of mergeable fields based on the
			// compatibility of their maps.
			dataPoints = 1;
			while (col + dataPoints < numCols
					&& dataMatrix[0][col].substring(0, dataMatrix[0][col].length() - 1).equals(
							dataMatrix[0][col + dataPoints].substring(0, dataMatrix[0][col + dataPoints].length() - 1))
					&& compareMaps(currentMap, getFieldValueRange(dataMatrix, col + dataPoints))) {

				auxMap = getFieldValueRange(dataMatrix, col + dataPoints);
				dataPoints++;

				// Actualizes the map to be used with the fields being merged.
				if (currentMap.size() < auxMap.size() && dataMatrix[0][col]
						.substring(0, dataMatrix[0][col].length() - 1).equals(dataMatrix[0][col + dataPoints]
								.substring(0, dataMatrix[0][col + dataPoints].length() - 1))) {
					currentMap = auxMap;
				}
			}

			// Calculates the average value of the mergeable datapoints.
			for (int row = 1; row < numRows; row++) {
				medValue = (float) (0);
				validDataPoints = 0;

				// Excludes the dataPoints with "Missing Values".
				for (int colOffset = 0; colOffset < dataPoints; colOffset++) {
					if (!isInvalidValue(dataMatrix[row][col + colOffset])) {
						medValue = medValue + Integer.valueOf(dataMatrix[row][col + colOffset].substring(0, 1));
						validDataPoints++;
					}
				}
				medValue = medValue / validDataPoints;

				// Leaves the rest of merged fields as blanks.
				for (int colOffset = 0; colOffset < dataPoints; colOffset++) {
					if (colOffset == 0) {
						dataMatrix[row][col + colOffset] = currentMap.get(Math.round(medValue));
					} else {
						dataMatrix[row][col + colOffset] = "";
						dataMatrix[0][col + colOffset] = "";
					}
				}

			}
			col = col + dataPoints;
		}
		System.out.println("--- mergeFields FINISHED ---");
	}

	/**
	 * Checks if the given value is useful or one of the considered as “Missing
	 * Values” in the project.
	 * 
	 * @param value,
	 *            the value checked.
	 * @return: True when the value is one of the “Missing Values”. False
	 *          otherwise.
	 */
	private static boolean isInvalidValue(String value) {

		// List of values considered as "Missing Values" in the project.
		ArrayList<String> nonValidValues = new ArrayList<>(Arrays.asList("REFUSED", "DON'T KNOW",
				"NO OPPORTUNITY TO OBSERVE", "NOT ASCERTAINED", "NOT APPLICABLE"));

		boolean valid = false;

		for (String nonValue : nonValidValues) {
			if (value.contains(nonValue) || value.equals(" ")) {
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * Creates a map of the values of one field and the keys that represent
	 * them.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 * @param col,
	 *            The column number of the field.
	 * 
	 * @return: A map containing the unique values of the field and their keys.
	 */
	public static Map<Integer, String> getFieldValueRange(String[][] dataMatrix, int col) {

		// Creates a list of all the values of one particular field.
		ArrayList<String> values = new ArrayList<String>();
		for (int row = 1; row < numRows; row++) {
			if (dataMatrix[row][col] != null) {
				values.add(dataMatrix[row][col]);
			}
		}

		// Leaves only one instance of each of the values.
		Set<String> uniqueValues = new HashSet<String>(values);

		// Creates a map of the values of the field and the keys that represent
		// them.
		Map<Integer, String> fieldValueRangeMap = new TreeMap<Integer, String>();
		for (Iterator<String> iter = uniqueValues.iterator(); iter.hasNext();) {
			String uniqueValue = iter.next().toString();
			int key = 0;

			// When the value is not one of the “Missing Values”, gets the key.
			if (!isInvalidValue(uniqueValue)) {
				key = Integer.valueOf(uniqueValue.substring(0, 1));
			}

			// When the key of the value is valid, adds them to the map.
			if (key != 0)
				fieldValueRangeMap.put(key, uniqueValue);
		}

		return fieldValueRangeMap;
	}

	/**
	 * Compares two maps containing the unique values of two fields to decide if
	 * they are equivalent based on the criteria established in the project.
	 * 
	 * @param map1,
	 *            one of the maps being compared.
	 * @param map2,
	 *            the other map being compared.
	 * 
	 * @return True when the two maps are considered equivalent. False
	 *         otherwise.
	 */
	public static boolean compareMaps(Map<Integer, String> map1, Map<Integer, String> map2) {
		boolean equal = true;

		Map<Integer, String> largestMap = new TreeMap<Integer, String>();
		Map<Integer, String> smallestMap = new TreeMap<Integer, String>();

		// Determines which map contains the most elements.
		if (map1.size() >= map2.size()) {
			largestMap = map1;
			smallestMap = map2;
		} else {
			largestMap = map2;
			smallestMap = map1;
		}

		// Compares the values of each map.
		for (Entry<Integer, String> entry : smallestMap.entrySet()) {
			if (!largestMap.get(entry.getKey()).equals(entry.getValue())) {
				equal = false;
			}
		}
		return equal;
	}

}
