package cpsat.handson.exercise.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	
	File f;
	FileOutputStream fos;
	XSSFWorkbook wbook;

	public void writeData(String linktext, String href, int rownumber) throws IOException {
			
			f = new File("./ConfigFiles/TopStories.xlsx");
			if(!f.exists()) {
				f.createNewFile();
			}
			fos = new FileOutputStream(f, true);
			wbook = new XSSFWorkbook();
			XSSFSheet wsheet = wbook.getSheet("Data");
			if(wsheet == null) {
				wsheet = wbook.createSheet("Data");
			}
			XSSFRow wsheetrow = wsheet.createRow(rownumber);
			XSSFCell cell2update1 = wsheetrow.getCell(0);
			cell2update1.setCellValue(linktext);
			XSSFCell cell2update2 = wsheetrow.getCell(1);
			cell2update2.setCellValue(href);
			
			
		}
	
	public void saveFile() throws IOException {
		wbook.write(fos);
		wbook.close();
		fos.close();
	}
	

	
}
