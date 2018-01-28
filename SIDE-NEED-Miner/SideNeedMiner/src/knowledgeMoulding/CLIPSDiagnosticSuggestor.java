package knowledgeMoulding;

import java.util.ArrayList;

import CLIPSJNI.Environment;
import CLIPSJNI.PrimitiveValue;

/**
 * This class uses the CLIPSJNI library in combination with the diagnosis rules
 * defined in the project to produce a diagnostic suggestion for each child in
 * the database.
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
 * @input: The output file from the “QuestionnaireAnswerer”, after removing the
 *         blank fields.
 * @output: An XLSX file containing the diagnosis suggestions for each child and
 *          their respective ID in the database. When a multiple detection
 *          happens, the ID is replicated for each diagnosis and appended at the
 *          end of the file.
 */
public class CLIPSDiagnosticSuggestor {

	private static int numRows = 16755;
	private static int numCols = 25;
	private static String inputFileName = "C:/temp/QuestionnaireAnswers - Cleaned.xlsx";
	private static String outputFileName = "C:/temp/DiagnosisSuggestions.xlsx";
	private static String sheetName = "DiagnosisSuggestions";

	public static void main(String[] args) {
		System.out.println("--- CLIPSDiagnosticator STARTING ---");

		String[][] dataMatrix = new String[numRows][numCols];

		// Uses the XLSXManager to read the input file, defined in the class,
		// and stores it in the given matrix.
		xlsx.XLSXManager.readXLSX(inputFileName, dataMatrix);

		dataMatrix = obtainSuggestions(dataMatrix);

		// Uses the XLSXManager to create a file in the path defined in the
		// class, and stores the output of the process.
		xlsx.XLSXManager.createXLSX(outputFileName, sheetName, dataMatrix);

		System.out.println("--- CLIPSDiagnosticator FINISHED ---");
	}

	/**
	 * Creates a matrix containing the results of the detection process using
	 * CLIPS.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 * 
	 * @return: A matrix containing the diagnostic suggestions.
	 */
	private static String[][] obtainSuggestions(String[][] dataMatrix) {

		// Creates and initializes the CLIPS environment.
		Environment clips = new Environment();
		clips.load("Rules.clp");
		clips.reset();

		// Creates and sets the field names of the resultMatrix, including extra
		// rows to accommodate the possible multiple diagnosis.
		String[][] resultMatrix = new String[17000][2];
		resultMatrix[0][0] = "ID";
		resultMatrix[0][1] = "DIAGNOSIS";

		// Variable used to keep count of the multiple diagnosis detected.
		int multipleDiag = 0;

		// Adds the suggestions for each child, using the “ID”.
		for (int id = 1; id < dataMatrix.length; id++) {

			// Resets the facts before each evaluation.
			clips.reset();

			// Adds all the facts of the current child to the CLIPS environment.
			for (String fact : getFacts(dataMatrix, id)) {
				clips.eval("(assert " + fact + ")");
			}

			// Launches the detection algorithm.
			clips.run();

			// Gets the results of the evaluation.
			PrimitiveValue suggestions = clips.eval("(find-all-facts ((?v diagnosis)) TRUE)");

			// Adds the results to the resultMatrix, and set the new amount of
			// multiple diagnosis if necessary.
			multipleDiag = addResults(resultMatrix, id, suggestions, multipleDiag);
		}

		return resultMatrix;
	}

	/**
	 * Creates a list of the facts about the given child.
	 * 
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 * @param childRow,
	 *            The dataMatrix row that contains the data for that child.
	 * 
	 * @return: A list containing the facts about the given child.
	 */
	private static ArrayList<String> getFacts(String[][] dataMatrix, int childRow) {
		ArrayList<String> facts = new ArrayList<String>();

		for (int col = 0; col < dataMatrix[childRow].length; col++) {
			if (dataMatrix[childRow][col].equals("YES")) {
				facts.add(dataMatrix[0][col]);
			}
		}
		return facts;
	}

	/**
	 * Adds the diagnosis suggestions for a given child into the result matrix.
	 * Increasing the multipleDiag when necessary.
	 * 
	 * @throws Exception
	 *             when getting CLIPS results.
	 * @param resultMatrix,
	 *            the matrix where the suggestions are stored.
	 * @param id,
	 *            the “ID” of the child being studied.
	 * @param suggestions,
	 *            the suggestions about the child being studied.
	 * @param multipleDiag,
	 *            the counter of multiple diagnoses that has happened.
	 * 
	 * @return The number of multiple diagnoses of the child being studied.
	 * 
	 */
	private static int addResults(String[][] resultMatrix, int id, PrimitiveValue suggestions, int multipleDiag) {
		int currectMultipleDiag = multipleDiag;
		try {

			// Sets the appropriate “ID” and the suggestion to “NULL” in case of
			// no detections.
			if (suggestions.size() == 0) {
				resultMatrix[id][0] = String.valueOf(id);
				resultMatrix[id][1] = "NULL";
			}

			// Iterates over the number of detections.
			for (int detections = 0; detections < suggestions.size(); detections++) {

				// Sets the appropriate “ID” and the suggestion in the cases of
				// only one detection.
				if (detections == 0) {
					resultMatrix[id][0] = String.valueOf(id);
					resultMatrix[id][1] = suggestions.get(detections).getFactSlot("need").toString();
				}

				// Sets the appropriate “ID” and the suggestion in the cases of
				// multiple detections.
				else {
					resultMatrix[numRows + currectMultipleDiag][0] = String.valueOf(id);
					resultMatrix[numRows + currectMultipleDiag][1] = suggestions.get(detections).getFactSlot("need")
							.toString();
					currectMultipleDiag++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currectMultipleDiag;
	}
}
