package knowledgeMoulding;

/**
 * This class combines the multiple fields containing information about the same
 * characteristic and assigns a “YES/NO” type of answer according to the limits
 * stablished.
 * 
 * @attribute numRows: The number of rows of the input dataMatrix.
 * @attribute numCols: The number of columns of the input dataMatrix.
 * @attribute inputFileName: The absolute path to the input file containing the
 *            dataset used.
 * @attribute outputFileName: The absolute path where the output file will be
 *            created.
 * @attribute sheetName: The name given to the sheet in the XLSX file.
 * @attribute lowerNoLimit: The lower limit beyond which the answer is
 *            considered “NO”.
 * @attribute upperYesLimit: The upper limit beyond which the answer is
 *            considered “YES”.
 * 
 * 
 * @input: The output file from the “AtributeTransformator”, after the names of
 *         the fields are changed to the ones used in the project to identify
 *         the children characteristics (example: ExecFun_1) , and rearranged
 *         alphabetically.
 * 
 * @output: An XLSX file containing 25 fields that are the answers to the
 *          questionnaire defined in the expert system. The file will contain
 *          empty fields that must be eliminated.
 * 
 */
public class QuestionnaireAnswerer {

	private static int numRows = 16755;
	private static int numCols = 87;
	private static String inputFileName = "C:/temp/TransformedValues - Names Changed.xlsx";
	private static String outputFileName = "C:/temp/QuestionnaireAnswers  - Pre-Cleaning.xlsx";
	private static String sheetName = "QuestionnaireAnswers";
	private static double lowerNoLimit = -0.2;
	private static double upperYesLimit = 0.2;

	public static void main(String[] args) {

		System.out.println("--- ValueMerger STARTING ---");

		String[][] dataMatrix = new String[numRows][numCols];

		// Uses the XLSXManager to read the input file, defined in the class,
		// and stores it in the given matrix.
		xlsx.XLSXManager.readXLSX(inputFileName, dataMatrix);
		
		mergeValues(dataMatrix);

		// Uses the XLSXManager to create a file in the path defined in the
		// class, and stores the output of the process.
		xlsx.XLSXManager.createXLSX(outputFileName, sheetName, dataMatrix);
		
		System.out.println("--- ValueMerger FINISHED ---");

	}

	/**
	 * Overwrites the dataMatrix with the answers to the questionnaire.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 */
	private static void mergeValues(String[][] dataMatrix) {
		System.out.println("--- mergeValues STARTING ---");

		Integer dataPoints;
		Integer validDataPoints;
		Float medValue;

		for (int col = 0; col < numCols;) {
			dataPoints = 1;
			// Compares the names of the fields to determine how many are used
			// to answer the same question.
			while (col + dataPoints < numCols && dataMatrix[0][col].equals(dataMatrix[0][col + dataPoints])) {
				dataPoints++;
			}

			for (int row = 1; row < numRows; row++) {
				medValue = (float) (0);

				// Excludes the dataPoints with value “0” (Missing Values").
				validDataPoints = 1;
				for (int currentCol = 0; currentCol < dataPoints; currentCol++) {
					if (!dataMatrix[row][col + currentCol].equals("0")) {
						medValue = medValue + Integer.valueOf(dataMatrix[row][col + currentCol]);
						validDataPoints++;
					}
				}

				// Calculates the average value of the dataPoints.
				medValue = medValue / validDataPoints;

				assignAnswer(dataMatrix, dataPoints, medValue, row, col);
			}
			
			// Jumps to the next question according to the number of dataPoints.
			col = col + dataPoints;
		}

		System.out.println("--- mergeValues FINISHED ---");
	}

	/**
	 * Overwrites the dataMatrix assigning “YES” “NO” or “NULL” answers to the
	 * questionnaire according to the average value of the fields. Leaves the
	 * fields combined in the process as blanks.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 * @param dataPoints,
	 *            the amount of data points for one particular answer.
	 * @param medValue
	 *            the average value of the fields.
	 * @param row,
	 *            current row in the dataMatrix.
	 * @param col,
	 *            current column in the dataMatrix.
	 */
	private static void assignAnswer(String[][] dataMatrix, int dataPoints, float medValue, int row, int col) {
		for (int currentCol = 0; currentCol < dataPoints; currentCol++) {
			// Assigns "YES" "NO" or "NULL" according to the limits.
			if (currentCol == 0) {
				if (medValue < lowerNoLimit) {
					dataMatrix[row][col + currentCol] = "NO";
				} else if (medValue > upperYesLimit) {
					dataMatrix[row][col + currentCol] = "YES";
				} else {
					dataMatrix[row][col + currentCol] = "NULL";
				}
				
			// Leaves the field as blanks.
			} else {
				dataMatrix[row][col + currentCol] = "";
				dataMatrix[0][col + currentCol] = "";
			}
		}
	}
}
