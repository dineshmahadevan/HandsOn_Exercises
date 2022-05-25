package cpsat.handson.exercise.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public String readData(String filename, String sheetname, int rownumber, int columnnumber) throws IOException {
		
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet wsheet = wbook.getSheet(sheetname);
		String value = wsheet.getRow(rownumber).getCell(columnnumber).getStringCellValue();
		fis.close();
		return value;
	}
}
