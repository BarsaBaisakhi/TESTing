package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	private FileInputStream fis;
	Workbook testdatafile=null;
	
	DataFormatter df= new DataFormatter();
	public void createSheet() throws IOException {
String filePath= System.getProperty("user.dir")+"\\src\\main\\resources\\inputData\\TestData.xlsx";

File file =  new File(filePath);
FileInputStream inputStream = new FileInputStream(file);
testdatafile=new XSSFWorkbook(inputStream);
}
}
