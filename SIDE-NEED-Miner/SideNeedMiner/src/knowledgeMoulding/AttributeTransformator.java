package knowledgeMoulding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * This class takes the 87 attributes selected in the knowledge moulding phase
 * and uses their specific “Transformation Maps” to transform their original
 * values to the [-2,-1,0,1,2] range.
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
 * @input: Original XLSX database´s 87 attributes.
 * @output: An XLSX file containing 87 attributes transformed to the
 *          [-2,-1,0,1,2] range. The names of the output must be changed to the
 *          ones used in the project to identify the children characteristics
 *          (example: ExecFun_1) , and rearranged alphabetically.
 */
public class AttributeTransformator {

	private static int numRows = 16755;
	private static int numCols = 87;
	private static String inputFileName = "C:/temp/OriginalSelectedFields.xlsx";
	private static String outputFileName = "C:/temp/TransformedValues - Pre-NameChanges.xlsx";
	private static String sheetName = "TransformedValues";

	public static void main(String[] args) {
		System.out.println("--- AttributeTransformator STARTING ---");

		String[][] dataMatrix = new String[numRows][numCols];

		// Uses the XLSXManager to read the input file, defined in the class,
		// and stores it in the given matrix.
		xlsx.XLSXManager.readXLSX(inputFileName, dataMatrix);

		numerize(dataMatrix);

		transformValues(dataMatrix);

		// Uses the XLSXManager to create a file in the path defined in the
		// class, and stores the output of the process.
		xlsx.XLSXManager.createXLSX(outputFileName, sheetName, dataMatrix);

		System.out.println("--- AttributeTransformator FINISHED ---");
	}

	/**
	 * Checks if the given value is useful or one of the considered as “Missing
	 * Values” in the project.
	 * 
	 * @param value,
	 *            the value checked.
	 * @return True when the value is one of the “Missing Values”. False
	 *         otherwise.
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
	 * Overwrites the dataMatrix with only the numerical codes of each value.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 */
	private static void numerize(String[][] dataMatrix) {
		System.out.println("--- numerize STARTING ---");

		for (int row = 1; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				if (isInvalidValue(dataMatrix[row][col])) {
					dataMatrix[row][col] = "0";
				} else {
					dataMatrix[row][col] = dataMatrix[row][col].substring(0, 1);
				}
			}
		}

		System.out.println("--- numerize FINISHED ---");
	}

	/**
	 * Uses the “TransformationMapsManager” to overwrite the dataMatrix with the
	 * appropriate values for each attribute.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 */
	private static void transformValues(String[][] dataMatrix) {
		System.out.println("--- transformValues STARTING ---");

		TransformationMapsManager tmm = new TransformationMapsManager();
		tmm.initializeMaps();

		String currentAttribute = "";
		for (int col = 0; col < numCols; col++) {
			currentAttribute = dataMatrix[0][col];
			for (int row = 1; row < numRows; row++) {
				dataMatrix[row][col] = tmm.mapValue(currentAttribute, dataMatrix[row][col]);
			}
		}

		System.out.println("--- transformValues FINISHED ---");
	}

}
