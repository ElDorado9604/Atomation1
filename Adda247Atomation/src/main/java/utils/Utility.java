package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreen(WebDriver driver ,int testID) throws IOException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh mm ss");
		Date d = new Date();
		String date = simpleDateFormat.format(d);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\New Program files\\Atomation\\ScreenShots\\Test-"+testID+" "+date+".jpeg");
		FileHandler.copy(src, dest);
	}
	
	public static String getDataFromExcelSheet(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		String path = "D:\\Software Testing\\Atomation\\Selenium\\Apache POI\\JayHo.xlsx";
		
		FileInputStream file = new FileInputStream (path);
		
		Sheet sheet_ = WorkbookFactory.create(file).getSheet(sheet);
		Row r = sheet_.getRow(row);
		Cell c = r.getCell(cell);
		
		String data = "";
		
		try {
			data = c.getStringCellValue();
		}
		catch(IllegalStateException e) {
			double value = c.getNumericCellValue();
			data = String.valueOf(value);
			
		}
		catch(Exception f)
		{
			f.printStackTrace();
			f.getMessage();
		}
		
		return data;
	}
}
