package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData(String sheetName){
		String[][] data;
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(new File("./data/"+sheetName+".xlsx"));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		//System.out.println("Row count is "+rowCount); //TODO - delete
		short columnCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][columnCount];
		//System.out.println(columnCount);
		for (int i=1; i<rowCount+1; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j=0; j<columnCount; j++) {
				String cellValue = row.getCell(j).getStringCellValue();
				//System.out.println(cellValue);
				data[i-1][j] = cellValue;
			}

		}
		//System.out.println(data[1][1].toString());
		return data; 

	}

}
