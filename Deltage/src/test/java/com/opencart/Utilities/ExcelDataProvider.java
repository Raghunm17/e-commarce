package com.opencart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src=new File("./testData/LoginTestDeltage-TestData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
		System.out.println("unable to read the excel file " + e.getMessage() );
		}
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue() ;	
	}
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue() ;	
	}
	public double getNumaricData(String sheetIndex, int row, int column) {
		return wb.getSheet(sheetIndex).getRow(row).getCell(column).getNumericCellValue() ;	
	}
}
