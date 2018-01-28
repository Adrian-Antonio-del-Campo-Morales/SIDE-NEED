package xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXManager {

	/**
	 * Reads a XLSX file and stores the data in the given matrix.
	 * 
	 * @param fileName,
	 *            the path of the file that will be read.
	 * @param dataMatrix,
	 *            the matrix where the data is stored.
	 */
	public static void readXLSX(String fileName, String[][] dataMatrix) {
		System.out.println("--- STARTING TO READ XLSX FILE : " + fileName + " ---");
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName));

			Workbook workBook = new XSSFWorkbook(inputStream);
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();

			int row = 0;
			int col = 0;
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					try {
						dataMatrix[row][col] = cell.getStringCellValue();
					} catch (Exception e) {
						if (row < dataMatrix.length)
							dataMatrix[row][col] = String.valueOf(cell.getNumericCellValue());
					}
					col++;
				}

				row++;
				col = 0;
			}

			workBook.close();
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--- XLSX FILE READED : " + fileName + " ---");
	}

	/**
	 * Creates a XLSX file containing the given dataMatrix in the specified
	 * path.
	 * 
	 * @param fileName,
	 *            the name of the file that will be created.
	 * @param sheetName,
	 *            the name of the sheet that will contain the data.
	 * @param dataMatrix,
	 *            the matrix containing the information that will be stored.
	 */
	public static void createXLSX(String fileName, String sheetName, String[][] dataMatrix) {
		System.out.println("--- STARTING TO CREATE XLSX FILE : " + fileName + " ---");

		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet(sheetName);

		for (int r = 0; r < dataMatrix.length; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < dataMatrix[0].length; c++) {
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(dataMatrix[r][c]);
			}
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			workBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			workBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--- XLSX FILE CREATED : " + fileName + " ---");
	}

}