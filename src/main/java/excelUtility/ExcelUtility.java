package excelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import propertyUtility.PropertyUtility;

public class ExcelUtility {
	static org.apache.logging.log4j.Logger log;

	private static String excelPath;
	static String excelCellData;
	 static List<String> completeRow;
	static List<String> completeColumn;

	public static String getSpecificCellValue(int sheet_no, int row_no, int column_no, String excelPath) {

		try {
			log = LogManager.getLogger("ExcelUtility");
			log.info("inside getSpecificCellValue method");
			excelPath=PropertyUtility.getPropertyData("excel.data.path");
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheet_no);
			excelCellData = sheet.getRow(row_no).getCell(column_no).getStringCellValue();
			log.info(sheet.getRow(row_no).getCell(column_no).getStringCellValue() + " :- Added from excel file");

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return excelCellData;

	}

	public static List<String> getCompleteCoulmnData(int sheet_no, int coulmn, String excelPath) {

		try {
			
			completeColumn=new ArrayList<String>();
			log = LogManager.getLogger("ExcelUtility");

			log.info("inside getCompleteRowData method");
			excelPath=PropertyUtility.getPropertyData("excel.data.path");
			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheet_no);

			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				completeColumn.add(sheet.getRow(i).getCell(coulmn).getStringCellValue());
				log.info(sheet.getRow(i).getCell(coulmn).getStringCellValue() + " :- Added from excel file in list");

			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return completeColumn;

	}

	public static List<String> getCompleteRowData(int sheet_no, int rowNo, String excelPath) {
		log = LogManager.getLogger("ExcelUtility");

		log.info("inside getCompleteColumnData method");

		if (!excelPath.isEmpty()) {
			try {
//          System.out.println("Excel file path:----"+excelPath);
			excelPath=PropertyUtility.getPropertyData("excel.data.path");
				
				completeRow=new ArrayList<String>();

				FileInputStream fis = new FileInputStream(excelPath);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(sheet_no);

				for (int i = 0; i < sheet.getRow(rowNo).getLastCellNum(); i++) {
					completeRow.add(sheet.getRow(rowNo).getCell(i).getStringCellValue());
					log.info(
							sheet.getRow(rowNo).getCell(i).getStringCellValue() + " :- Added from excel file in list");
				}
			} 
			
			catch (Exception e) {
				log.error(e.getMessage());
			}

		} else {
			log.info("excelPath is null");
		}
		return completeRow;

	}
}
