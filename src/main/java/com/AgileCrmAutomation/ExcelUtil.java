package com.AgileCrmAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
// 1.method to get the file extension based on provided file path 
	private String getFileExtention(String filePath) {
// get the file path extension
		String extention = filePath.substring(filePath.indexOf("."));
		System.out.println(extention);
		return extention;
	}

//2.method to get workbook instance based on the provided file path.
	private Workbook getWorkbookInstance(String filePath) throws IOException {
		Workbook wb;
		FileInputStream input = new FileInputStream(filePath);
//based on file extension, taek the control of workbook
		if (getFileExtention(filePath).equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else {
			wb = new HSSFWorkbook(input);
		}
		return wb;
	}

//method to get sheet reference from workbook instance
	private Sheet getSheet(String filePath, String sheetName) {
		Sheet sheet = null;
		try {
			Workbook wb = getWorkbookInstance(filePath);
			sheet = wb.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}

// will return excelfile data in 2 dimensional array
	public Object[][] getExcelData(String filePath, String sheetName) {
		Sheet sheet = getSheet(filePath, sheetName);
		int totalRow = sheet.getPhysicalNumberOfRows();
		int totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		return getCellValue(sheet, totalRow, totalColumn);
	}

//this method will return value from each cell
	private Object[][] getCellValue(Sheet sheet, int totalRows, int totalColumns) {
		Object[][] value = new Object[totalRows][totalColumns];
		for (int i = 1; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < totalColumns; j++) {
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					value[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					value[i][j] = cell.getNumericCellValue();
					break;

				case BOOLEAN:
					value[i][j] = cell.getBooleanCellValue();
					break;

				case _NONE:
					value[i][j] = null;
					break;

				case BLANK:
					value[i][j] = null;
					break;

				default:
					value[i][j] = null;
				}
			}
		}
		return value;
	}

	public static void main(String[] args) throws IOException {
//FilePath
		String filePath = "C:\\Users\\Niranjan\\Documents\\selenium document\\ExcelUtil.xlsx";
		ExcelUtil excelValues = new ExcelUtil();
		Object[][] data = excelValues.getExcelData(filePath, "LoginTestData");
		int rowLength = data.length;
		int columnLength = data[0].length;
		for (int i = 1; i <= rowLength - 1; i++) {
			for (int j = 0; j < columnLength; j++) {
				System.out.println(data[i][j]);
			}
		}
	}

	public void setDataInExcel(String filePath, String sheetName, int rowNum, int cellNum, Cell cell, Object value) {
		try {
			Workbook wb = getWorkbookInstance(filePath);
			Sheet sheet;
//get the sheet detail if it is present
			if (wb.getSheet(sheetName) != null) {
				sheet = wb.getSheet(sheetName);
			} else {
//create new sheet in the workbook
				sheet = wb.createSheet(sheetName);
			}
//create row if present else get the control of the row
			Row row;
			if (sheet.getRow(rowNum) != null) {
				row = sheet.getRow(rowNum);
			} else {
				row = sheet.createRow(rowNum);
			}
//create cell if present else get the control of the cell
			if (row.getCell(cellNum) != null) {
				cell = row.getCell(cellNum);
			} else {
				cell = row.createCell(cellNum);
			}
			setCellValue(cell, value);
			FileOutputStream output = new FileOutputStream(filePath);
			wb.write(output);
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCellValue(Cell cell, Object value) {
		if (value instanceof Integer) {
			cell.setCellValue((int) value);
		} else if (value instanceof String) {
			cell.setCellValue(value.toString());
		} else if (value instanceof Boolean) {
			cell.setCellValue((boolean) value);
		}
	}
}